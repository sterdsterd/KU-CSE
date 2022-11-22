#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include <Windows.h>
#include "MATRIX_METHODS.h"
#include "constructHaarMatrix.h"
#include "bitmapManager.h"

void problem1();
void problem2();
void problem3();

int main() {
    problem1();
    problem2();
    problem3();

    return 0;
}

void doDHWT(double** originalImageMatrix, int imgHeight, int imgWidth, int imgSize, BITMAPHEADER outputHeader, char** filePathToSave) {
    //Haar matrix H 구성 (orthonormal column을 갖도록 구성)
    int n = imgHeight; //이미지가 정사각형(Height==Width)이라고 가정; n = 2^t,t=0,1,2,...

    // 1. (b)
    double** H = constructHaarMatrixRecursive(n);
    double** normalisedH = normaliseMatrix(H, n, n);

    // 1. (c)
    double** transposedNormalisedH = transposeMatrix(normalisedH, n, n);
    double** HTA = multiplyTwoMatrices(transposedNormalisedH, n, n, originalImageMatrix, n, n);
    double** B = multiplyTwoMatrices(HTA, n, n, normalisedH, n, n);

    // 1. (d)
    double** Bhat = allocateMemory(imgHeight, imgWidth);

    for (int s = 0; s <= 9; s++) { // 2^9 = 512
        int k = pow(2, s);

        // Construct Matrix B Hat
        for (int i = 0; i < imgHeight; i++) {
            for (int j = 0; j < imgWidth; j++) {
                if (i < k && j < k) Bhat[i][j] = B[i][j];
                else Bhat[i][j] = 0;
            }
        }

        // 1. (e)
        double** HBhat = multiplyTwoMatrices(normalisedH, n, n, Bhat, n, n);
        double** Ahat = multiplyTwoMatrices(HBhat, n, n, transposedNormalisedH, n, n);

        // 1. (f)
        // Write Reconstructed Image
        // Ahat을 이용해서 위의 image와 같은 형식이 되도록 구성 (즉, Ahat = [a b;c d]면 [a a a b b b c c c d d d]를 만들어야 함)
        BYTE* Are = (BYTE*)malloc(BYTES_PER_PIXEL * sizeof(BYTE) * imgSize);

        for (int i = 0; i < imgHeight; i++)
            for (int j = 0; j < imgWidth; j++)
                for (int k = 0; k < BYTES_PER_PIXEL; k++)
                    Are[(i * imgWidth + j) * BYTES_PER_PIXEL + k] = (BYTE)Ahat[i][j];

        char fileName[50] = "";
        strcat(fileName, filePathToSave);
        strcat(fileName, "_");
        char kStr[5];
        sprintf(kStr, "%d", k);
        strcat(fileName, kStr);
        strcat(fileName, ".bmp");

        writeBitmapFile(BYTES_PER_PIXEL, outputHeader, Are, imgSize, fileName);
        printf("%s saved.\n", fileName);

        releaseMemory(HBhat, n);
        releaseMemory(Ahat, n);
        free(Are);
    }

    releaseMemory(H, n);
    releaseMemory(normalisedH, n);
    releaseMemory(transposedNormalisedH, n);
    releaseMemory(HTA, n);
    releaseMemory(B, n);
    releaseMemory(Bhat, n);
}

void problem1() {
    BITMAPHEADER outputHeader;
    int imgSize, imgWidth, imgHeight;

    double** A = getImageMatrixFromFileName(&outputHeader, &imgWidth, &imgHeight, &imgSize, "problem1/image_lena_24bit.bmp");

    doDHWT(A, imgHeight, imgWidth, imgSize, outputHeader, "problem1/image_lena_24bit");
    
    releaseMemory(A, imgHeight);
}

void problem2() {
    BITMAPHEADER lowFreqOutputHeader, highFreqOutputHeader;
    int lowFreqWidth, lowFreqHeight, lowFreqSize, highFreqWidth, highFreqHeight, highFreqSize;

    double** lowFreqImgMatrix = getImageMatrixFromFileName(&lowFreqOutputHeader,
        &lowFreqWidth,
        &lowFreqHeight,
        &lowFreqSize,
        "problem2/low_freq.bmp");

    doDHWT(lowFreqImgMatrix, lowFreqHeight, lowFreqWidth, lowFreqSize, lowFreqOutputHeader, "problem2/low_freq");


    double** highFreqImgMatrix = getImageMatrixFromFileName(&highFreqOutputHeader,
        &highFreqWidth,
        &highFreqHeight,
        &highFreqSize,
        "problem2/high_freq.bmp");

    doDHWT(highFreqImgMatrix, highFreqHeight, highFreqWidth, highFreqSize, highFreqOutputHeader, "problem2/high_freq");

    releaseMemory(lowFreqImgMatrix, lowFreqHeight);
    releaseMemory(highFreqImgMatrix, highFreqHeight);
}

void problem3() {
    BITMAPHEADER outputHeader;
    int imgSize, imgWidth, imgHeight;

    double** A = getImageMatrixFromFileName(&outputHeader, &imgWidth, &imgHeight, &imgSize, "problem3/image_lena_24bit.bmp");

    int n = imgHeight;

    // Split H^T into H_l and H_h
    double** H = constructHaarMatrixRecursive(n);
    double** normalisedH = normaliseMatrix(H, n, n);
    double** transposedNormalisedH = transposeMatrix(normalisedH, n, n);

    double** Hl = allocateMemory(n / 2, n);
    double** Hh = allocateMemory(n / 2, n);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i < n / 2) Hl[i][j] = transposedNormalisedH[i][j];
            else Hh[i - n / 2][j] = transposedNormalisedH[i][j];
        }
    }
    double** HlT = transposeMatrix(Hl, n / 2, n);
    double** HhT = transposeMatrix(Hh, n / 2, n);

    // 3. (a) LHS
    double** HTA = multiplyTwoMatrices(transposedNormalisedH, n, n, A, n, n);
    double** B = multiplyTwoMatrices(HTA, n, n, normalisedH, n, n);

    // 3. (a) RHS
    double** HlA = multiplyTwoMatrices(Hl, n / 2, n, A, n, n);
    double** HhA = multiplyTwoMatrices(Hh, n / 2, n, A, n, n);

    double** HlAHlT = multiplyTwoMatrices(HlA, n / 2, n, HlT, n, n / 2);
    double** HlAHhT = multiplyTwoMatrices(HlA, n / 2, n, HhT, n, n / 2);
    double** HhAHlT = multiplyTwoMatrices(HhA, n / 2, n, HlT, n, n / 2);
    double** HhAHhT = multiplyTwoMatrices(HhA, n / 2, n, HhT, n, n / 2);

    // 3. (a) Check LHS == RHS
    bool isASame = true;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            double cmp = 0;
            if (i < n / 2 && j < n / 2) cmp = HlAHlT[i][j];
            else if (i < n / 2 && j >= n / 2) cmp = HlAHhT[i][j - n / 2];
            else if (i >= n / 2 && j < n / 2) cmp = HhAHlT[i - n / 2][j];
            else cmp = HhAHhT[i - n / 2][j - n / 2];

            if (!doubleEquals(cmp, B[i][j])) isASame = false;
        }
    }

    printf("3. (a): %s\n", isASame ? "true" : "false");


    // 3. (b) LHS
    double** HB = multiplyTwoMatrices(normalisedH, n, n, B, n, n);
    double** HBHT = multiplyTwoMatrices(HB, n, n, transposedNormalisedH, n, n);

    // 3. (b) RHS
    double** HlTHlAHlT = multiplyTwoMatrices(HlT, n, n / 2, HlAHlT, n / 2, n / 2);
    double** HlTHlAHlTHl = multiplyTwoMatrices(HlTHlAHlT, n, n / 2, Hl, n / 2, n);

    double** HlTHlAHhT = multiplyTwoMatrices(HlT, n, n / 2, HlAHhT, n / 2, n / 2);
    double** HlTHlAHhTHh = multiplyTwoMatrices(HlTHlAHhT, n, n / 2, Hh, n / 2, n);

    double** HhTHhAHlT = multiplyTwoMatrices(HhT, n, n / 2, HhAHlT, n / 2, n / 2);
    double** HhTHhAHlTHl = multiplyTwoMatrices(HhTHhAHlT, n, n / 2, Hl, n / 2, n);

    double** HhTHhAHhT = multiplyTwoMatrices(HhT, n, n / 2, HhAHhT, n / 2, n / 2);
    double** HhTHhAHhTHh = multiplyTwoMatrices(HhTHhAHhT, n, n / 2, Hh, n / 2, n);

    double** LURU = addTwoMatrices(HlTHlAHlTHl, n, n, HlTHlAHhTHh, n, n);
    double** LURULL = addTwoMatrices(LURU, n, n, HhTHhAHlTHl, n, n);
    double** RHS = addTwoMatrices(LURULL, n, n, HhTHhAHhTHh, n, n);

    // 3. (b) Check LHS == RHS
    bool isBSame = true;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (!doubleEquals(HBHT[i][j], RHS[i][j])) isBSame = false;
        }
    }

    printf("3. (b): %s\n", isBSame ? "true" : "false");

    // 3. (c)
    BYTE* term1 = (BYTE*)malloc(BYTES_PER_PIXEL * sizeof(BYTE) * imgSize);
    
    for (int i = 0; i < imgHeight; i++)
        for (int j = 0; j < imgWidth; j++)
            for (int k = 0; k < BYTES_PER_PIXEL; k++)
                term1[(i * imgWidth + j) * BYTES_PER_PIXEL + k] = (BYTE)HlTHlAHlTHl[i][j];

    writeBitmapFile(BYTES_PER_PIXEL, outputHeader, term1, imgSize, "problem3/term1.bmp");


    BYTE* term2 = (BYTE*)malloc(BYTES_PER_PIXEL * sizeof(BYTE) * imgSize);

    for (int i = 0; i < imgHeight; i++)
        for (int j = 0; j < imgWidth; j++)
            for (int k = 0; k < BYTES_PER_PIXEL; k++)
                term2[(i * imgWidth + j) * BYTES_PER_PIXEL + k] = (BYTE)HlTHlAHhTHh[i][j];

    writeBitmapFile(BYTES_PER_PIXEL, outputHeader, term2, imgSize, "problem3/term2.bmp");


    BYTE* term3 = (BYTE*)malloc(BYTES_PER_PIXEL * sizeof(BYTE) * imgSize);

    for (int i = 0; i < imgHeight; i++)
        for (int j = 0; j < imgWidth; j++)
            for (int k = 0; k < BYTES_PER_PIXEL; k++)
                term3[(i * imgWidth + j) * BYTES_PER_PIXEL + k] = (BYTE)HhTHhAHlTHl[i][j];

    writeBitmapFile(BYTES_PER_PIXEL, outputHeader, term3, imgSize, "problem3/term3.bmp");


    BYTE* term4 = (BYTE*)malloc(BYTES_PER_PIXEL * sizeof(BYTE) * imgSize);

    for (int i = 0; i < imgHeight; i++)
        for (int j = 0; j < imgWidth; j++)
            for (int k = 0; k < BYTES_PER_PIXEL; k++)
                term4[(i * imgWidth + j) * BYTES_PER_PIXEL + k] = (BYTE)HhTHhAHhTHh[i][j];

    writeBitmapFile(BYTES_PER_PIXEL, outputHeader, term4, imgSize, "problem3/term4.bmp");

    
    // 3. (d)

    double** Hll = allocateMemory(n / 4, n);
    double** Hlh = allocateMemory(n / 4, n);

    for (int i = 0; i < n / 2; i++) {
        for (int j = 0; j < n; j++) {
            if (i < n / 4) Hll[i][j] = Hl[i][j];
            else Hlh[i - n / 4][j] = Hl[i][j];
        }
    }

    double** HllT = transposeMatrix(Hll, n / 4, n);
    double** HlhT = transposeMatrix(Hlh, n / 4, n);

    // 3. (d) RHS
    double** HllA = multiplyTwoMatrices(Hll, n / 4, n, A, n, n);
    double** HlhA = multiplyTwoMatrices(Hlh, n / 4, n, A, n, n);

    double** HllAHllT = multiplyTwoMatrices(HllA, n / 4, n, HllT, n, n / 4);
    double** HllAHlhT = multiplyTwoMatrices(HllA, n / 4, n, HlhT, n, n / 4);
    double** HlhAHllT = multiplyTwoMatrices(HlhA, n / 4, n, HllT, n, n / 4);
    double** HlhAHlhT = multiplyTwoMatrices(HlhA, n / 4, n, HlhT, n, n / 4);
    
    double** HllTHllAHllT = multiplyTwoMatrices(HllT, n, n / 4, HllAHllT, n / 4, n / 4);
    double** HllTHllAHllTHll = multiplyTwoMatrices(HllTHllAHllT, n, n / 4, Hll, n / 4, n);

    double** HllTHllAHlhT = multiplyTwoMatrices(HllT, n, n / 4, HllAHlhT, n / 4, n / 4);
    double** HllTHllAHlhTHlh = multiplyTwoMatrices(HllTHllAHlhT, n, n / 4, Hlh, n / 4, n);

    double** HlhTHlhAHllT = multiplyTwoMatrices(HlhT, n, n / 4, HlhAHllT, n / 4, n / 4);
    double** HlhTHlhAHllTHll = multiplyTwoMatrices(HlhTHlhAHllT, n, n / 4, Hll, n / 4, n);

    double** HlhTHlhAHlhT = multiplyTwoMatrices(HlhT, n, n / 4, HlhAHlhT, n / 4, n / 4);
    double** HlhTHlhAHlhTHlh = multiplyTwoMatrices(HlhTHlhAHlhT, n, n / 4, Hlh, n / 4, n);

    double** dLURU = addTwoMatrices(HllTHllAHllTHll, n, n, HllTHllAHlhTHlh, n, n);
    double** dLURULL = addTwoMatrices(dLURU, n, n, HlhTHlhAHllTHll, n, n);
    double** dRHS = addTwoMatrices(dLURULL, n, n, HlhTHlhAHlhTHlh, n, n);

    // 3. (d) Check LHS == RHS
    bool isDSame = true;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (!doubleEquals(HlTHlAHlTHl[i][j], dRHS[i][j])) isDSame = false;
        }
    }

    printf("3. (d): %s\n", isDSame ? "true" : "false");

    // 3. (d) Save Image
    BYTE* dTerm1 = (BYTE*)malloc(BYTES_PER_PIXEL * sizeof(BYTE) * imgSize);

    for (int i = 0; i < imgHeight; i++)
        for (int j = 0; j < imgWidth; j++)
            for (int k = 0; k < BYTES_PER_PIXEL; k++)
                dTerm1[(i * imgWidth + j) * BYTES_PER_PIXEL + k] = (BYTE)HllTHllAHllTHll[i][j];

    writeBitmapFile(BYTES_PER_PIXEL, outputHeader, dTerm1, imgSize, "problem3/dTerm1.bmp");


    BYTE* dTerm2 = (BYTE*)malloc(BYTES_PER_PIXEL * sizeof(BYTE) * imgSize);

    for (int i = 0; i < imgHeight; i++)
        for (int j = 0; j < imgWidth; j++)
            for (int k = 0; k < BYTES_PER_PIXEL; k++)
                dTerm2[(i * imgWidth + j) * BYTES_PER_PIXEL + k] = (BYTE)HllTHllAHlhTHlh[i][j];

    writeBitmapFile(BYTES_PER_PIXEL, outputHeader, dTerm2, imgSize, "problem3/dTerm2.bmp");


    BYTE* dTerm3 = (BYTE*)malloc(BYTES_PER_PIXEL * sizeof(BYTE) * imgSize);

    for (int i = 0; i < imgHeight; i++)
        for (int j = 0; j < imgWidth; j++)
            for (int k = 0; k < BYTES_PER_PIXEL; k++)
                dTerm3[(i * imgWidth + j) * BYTES_PER_PIXEL + k] = (BYTE)HlhTHlhAHllTHll[i][j];

    writeBitmapFile(BYTES_PER_PIXEL, outputHeader, dTerm3, imgSize, "problem3/dTerm3.bmp");


    BYTE* dTerm4 = (BYTE*)malloc(BYTES_PER_PIXEL * sizeof(BYTE) * imgSize);

    for (int i = 0; i < imgHeight; i++)
        for (int j = 0; j < imgWidth; j++)
            for (int k = 0; k < BYTES_PER_PIXEL; k++)
                dTerm4[(i * imgWidth + j) * BYTES_PER_PIXEL + k] = (BYTE)HlhTHlhAHlhTHlh[i][j];

    writeBitmapFile(BYTES_PER_PIXEL, outputHeader, dTerm4, imgSize, "problem3/dTerm4.bmp");

    
    // Release Allocated Memory
    free(dTerm4);
    free(dTerm3);
    free(dTerm2);
    free(dTerm1);
    releaseMemory(HllA, n / 4);
    releaseMemory(HllAHllT, n / 4);
    releaseMemory(HllAHlhT, n / 4);
    releaseMemory(HlhAHllT, n / 4);
    releaseMemory(HlhAHlhT, n / 4);
    releaseMemory(HllTHllAHllT, n);
    releaseMemory(HllTHllAHllTHll, n);
    releaseMemory(HllTHllAHlhT, n);
    releaseMemory(HllTHllAHlhTHlh, n);
    releaseMemory(HlhTHlhAHllT, n);
    releaseMemory(HlhTHlhAHllTHll, n);
    releaseMemory(HlhTHlhAHlhT, n);
    releaseMemory(HlhTHlhAHlhTHlh, n);
    releaseMemory(dLURU, n);
    releaseMemory(dLURULL, n);
    releaseMemory(dRHS, n);
    free(term4);
    free(term3);
    free(term2);
    free(term1);
    releaseMemory(RHS, n);
    releaseMemory(LURULL, n);
    releaseMemory(LURU, n);
    releaseMemory(HhTHhAHhTHh, n);
    releaseMemory(HhTHhAHhT, n);
    releaseMemory(HhTHhAHlTHl, n);
    releaseMemory(HhTHhAHlT, n);
    releaseMemory(HlTHlAHhTHh, n);
    releaseMemory(HlTHlAHhT, n);
    releaseMemory(HlTHlAHlTHl, n);
    releaseMemory(HlTHlAHlT, n);
    releaseMemory(HBHT, n);
    releaseMemory(HB, n);
    releaseMemory(HhAHhT, n / 2);
    releaseMemory(HhAHlT, n / 2);
    releaseMemory(HlAHhT, n / 2);
    releaseMemory(HlAHlT, n / 2);
    releaseMemory(HhA, n / 2);
    releaseMemory(HlA, n / 2);
    releaseMemory(B, n);
    releaseMemory(HTA, n);
    releaseMemory(Hh, n / 2);
    releaseMemory(Hl, n / 2);
    releaseMemory(transposedNormalisedH, n);
    releaseMemory(normalisedH, n);
    releaseMemory(H, n);
    
}