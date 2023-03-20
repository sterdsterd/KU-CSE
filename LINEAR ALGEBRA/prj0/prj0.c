#include <stdio.h>
#include <stdlib.h>
#include <math.h>


//functions for convenience
double** allocateMemory(int m, int n);
void releaseMemory(double** A, int m);
void printMatrix(double** A, int m, int n, char name[]);

//functions to implement in prj0
double** transposeMatrix(double** A, int m, int n);
double** normalizeVector(double** v, int n);
double** normalizeMatrix(double** v, int m, int n);
double calculateLength(double** v, int n);
double** scaleMatrix(double** A, int m, int n, double c);
double** multiplyTwoMatrices(double** A, int m, int n, double** B, int l, int k);
double** addTwoMatrices(double** A, int m, int n, double** B, int l, int k);

void problem2b() {
    double a[2][2] = {
        {1, 2},
        {3, 4}
    };
    
    double tildeH[2][2] = {
        {1, 1},
        {1, -1}
    };
    
    double** A = allocateMemory(2, 2);
    for (int i = 0; i < 2; i++)
        for (int j = 0; j < 2; j++)
            A[i][j] = (double) a[i][j];
    printMatrix(A,2,2,"A");
    
    double** TildeH = allocateMemory(2, 2);
    for (int i = 0; i < 2; i++)
        for (int j = 0; j < 2; j++)
            TildeH[i][j] = (double) tildeH[i][j];
    printMatrix(TildeH,2,2,"Tilde H");
    
    double** H = normalizeMatrix(TildeH, 2, 2);
    printMatrix(H, 2, 2, "H");
    
    double** HT = transposeMatrix(H, 2, 2);
    
    double** B = multiplyTwoMatrices(HT, 2, 2, A, 2, 2);
    B = multiplyTwoMatrices(B, 2, 2, H, 2, 2);
    printMatrix(B, 2, 2, "B");
    
    double** C = multiplyTwoMatrices(H, 2, 2, B, 2, 2);
    C = multiplyTwoMatrices(C, 2, 2, HT, 2, 2);
    printMatrix(C, 2, 2, "C");
    
    releaseMemory(A, 2);
    releaseMemory(TildeH, 2);
    releaseMemory(H, 2);
    releaseMemory(HT, 2);
    releaseMemory(B, 2);
    releaseMemory(C, 2);
}

int main() {
    for (;;) {
        printf("(a) Transpose Matrix\n");
        printf("(b) Normalise Vector\n");
        printf("(c) Calculate Length\n");
        printf("(d) Scale Matrix \n");
        printf("(e) Multiply 2 Matrices\n");
        printf("(f) Add 2 Matrices\n");
        printf("------------------------------\n");
        printf("(x) Solve Problem 2(b)\n");
        printf("Select Menu : ");
        char c;
        scanf("%c", &c);
        
        if (c == 'a') {
            printf("\n#### Transpose Matrix ####\n");
            int row, col;
            printf("Enter the number of row : ");
            scanf("%d", &row);
            
            printf("Enter the number of column : ");
            scanf("%d", &col);
            
            double** A = allocateMemory(row, col);
            
            printf("Enter the element of matrix :\n");
            
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    scanf("%lf", &A[i][j]);
                }
            }
            
            printMatrix(A, row, col, "A");
            
            double** AT = transposeMatrix(A, row, col);
            
            printMatrix(AT, col, row, "A^T");
            
            releaseMemory(A, row);
            releaseMemory(AT, col);
        } else if (c == 'b') {
            printf("\n#### Normalise Vector ####\n");
            int row;
            printf("Enter the number of row : ");
            scanf("%d", &row);
            
            double** V = allocateMemory(row, 1);
            printf("Enter the element of matrix :\n");
            
            
            for (int i = 0; i < row; i++) {
                scanf("%lf", &V[i][0]);
            }
            
            printMatrix(V, row, 1, "v");
            
            double** nV = normalizeVector(V, row);
            printMatrix(nV, row, 1, "Normalised v");
            
            releaseMemory(V, row);
            releaseMemory(nV, row);
        } else if (c == 'c') {
            printf("\n#### Calculate Length ####\n");
            int row;
            printf("Enter the number of row : ");
            scanf("%d", &row);
            
            double** V = allocateMemory(row, 1);
            printf("Enter the element of matrix :\n");
            
            
            for (int i = 0; i < row; i++) {
                scanf("%lf", &V[i][0]);
            }
            
            printMatrix(V, row, 1, "v");
            
            printf("Length of V = %lf", calculateLength(V, row));
            
            releaseMemory(V, row);
        } else if (c == 'd') {
            printf("\n#### Scale Matrix ####\n");
            
            int row, col;
            printf("Enter the number of row : ");
            scanf("%d", &row);
            
            printf("Enter the number of column : ");
            scanf("%d", &col);
            
            double** A = allocateMemory(row, col);
            
            printf("Enter the element of matrix :\n");
            
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    scanf("%lf", &A[i][j]);
                }
            }
            
            double c;
            printf("Enter the value of scalar c : ");
            scanf("%lf", &c);
            
            printMatrix(A, row, col, "A");
            
            double** cA = scaleMatrix(A, row, col, c);
            printMatrix(cA, row, col, "cA");
            
            releaseMemory(A, row);
            releaseMemory(cA, row);
        } else if (c == 'e') {
            printf("\n#### Multiply 2 Matrices ####\n");
            int rowA, colA;
            printf("Enter the number of row of matrix A : ");
            scanf("%d", &rowA);
            
            printf("Enter the number of column of matrix A : ");
            scanf("%d", &colA);
            
            double** A = allocateMemory(rowA, colA);
            
            printf("Enter the element of matrix A :\n");
            
            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < colA; j++) {
                    scanf("%lf", &A[i][j]);
                }
            }
            
            int rowB, colB;
            printf("Enter the number of row of matrix B : ");
            scanf("%d", &rowB);
            
            printf("Enter the number of column of matrix B : ");
            scanf("%d", &colB);
            
            double** B = allocateMemory(rowB, colB);
            
            printf("Enter the element of matrix B :\n");
            
            for (int i = 0; i < rowB; i++) {
                for (int j = 0; j < colB; j++) {
                    scanf("%lf", &B[i][j]);
                }
            }
            double** AB = multiplyTwoMatrices(A, rowA, colA, B, rowB, colB);
            
            if (AB == NULL)
                printf("Multiplication is impossible.\n");
            else {
                printMatrix(A, rowA, colA, "A");
                printMatrix(B, rowB, colB, "B");
                printMatrix(AB, rowA, colB, "AB");
                
                releaseMemory(AB, rowA);
            }
            releaseMemory(A, rowA);
            releaseMemory(B, rowB);
        } else if (c == 'f') {
            printf("\n#### Add 2 Matrices ####\n");
            int rowA, colA;
            printf("Enter the number of row of matrix A : ");
            scanf("%d", &rowA);
            
            printf("Enter the number of column of matrix A : ");
            scanf("%d", &colA);
            
            double** A = allocateMemory(rowA, colA);
            
            printf("Enter the element of matrix A :\n");
            
            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < colA; j++) {
                    scanf("%lf", &A[i][j]);
                }
            }
            
            int rowB, colB;
            printf("Enter the number of row of matrix B : ");
            scanf("%d", &rowB);
            
            printf("Enter the number of column of matrix B : ");
            scanf("%d", &colB);
            
            double** B = allocateMemory(rowB, colB);
            
            printf("Enter the element of matrix B :\n");
            
            for (int i = 0; i < rowB; i++) {
                for (int j = 0; j < colB; j++) {
                    scanf("%lf", &B[i][j]);
                }
            }
            double** AplusB = addTwoMatrices(A, rowA, colA, B, rowB, colB);
            if (AplusB == NULL)
                printf("Addition is impossible.\n");
            else {
                printMatrix(A, rowA, colA, "A");
                printMatrix(B, rowB, colB, "B");
                printMatrix(AplusB, rowA, colB, "A+B");
                
                releaseMemory(AplusB, rowA);
            }
            releaseMemory(A, rowA);
            releaseMemory(B, rowB);
        } else if (c == 'x') {
            problem2b();
        }
        
        printf("\n");
        getchar();
    }
    
    return 0;
}

//functions for convenience
double** allocateMemory(int m, int n) {
    double** A;
    A = (double**) malloc(sizeof(double*) * m);
    for (int i = 0; i < m; i++) {
        A[i] = (double*) malloc(sizeof(double) * n);
    }
    return A;
}


void releaseMemory(double** A, int m) {
    for (int i = 0; i < m; i++)
        free(A[i]);
}

void printMatrix(double** A, int m, int n, char name[]) {
    printf("\n%s = \n", name);
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++)
            printf("%lf ", A[i][j]);
        printf("\n");
    }
}

//functions to implement in prj0
double** transposeMatrix(double **A, int m, int n) {
    double** B = allocateMemory(n, m);

    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++)
            B[j][i] = A[i][j];
    
    return B;
}

double** normalizeVector(double** v, int n) {
    double** w;
    double len = calculateLength(v, n);

    w = allocateMemory(n, 1);
    for (int i = 0; i < n; i++)
        w[i][0] = v[i][0] / len;

    return w;
}

double** normalizeMatrix(double** v, int m, int n) {
    double** w = allocateMemory(m, n);
    for (int i = 0; i < m; i++) {
        double len = 0;
        for (int j = 0; j < n; j++) {
            len += v[i][j] * v[i][j];
        }
        len = sqrt(len);
        for (int j = 0; j < n; j++) {
            w[i][j] = v[i][j] / len;
        }
    }
    
    return w;
}

double calculateLength(double** v, int n) {
    double len = 0.0;
    
    for (int i = 0; i < n; i++) {
        len += v[i][0] * v[i][0];
    }
    len = sqrt(len);
    
    return len;
}

double** scaleMatrix(double** A, int m, int n, double c) {
    double** cA = allocateMemory(m, n);
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            cA[i][j] = c * A[i][j];
        }
    }
    
    return cA;
}

double** multiplyTwoMatrices(double** A, int m, int n, double** B, int p, int q) {
    if (n != p) return NULL;
    
    double** AB = allocateMemory(m, q);

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < q; j++) {
            AB[i][j] = 0;
            for (int k = 0; k < p; k++) {
                AB[i][j] += A[i][k] * B[k][j];
            }
        }
    }
    
    return AB;
}

double** addTwoMatrices(double** A, int m, int n, double** B, int l, int k) {
    if (m != l || n != k) return NULL;
    
    double** C = allocateMemory(m, n);
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            C[i][j] = A[i][j] + B[i][j];
        }
    }
    
    return C;
}
