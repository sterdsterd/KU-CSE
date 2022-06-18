/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #1
 * 작성일: 2022년 6월 7일
 */

#include <stdio.h>
#define HEIGHT 10
#define WIDTH 10

void array_copy(int (*dest)[WIDTH], int (*arr)[WIDTH]) {
    int* destp = &dest[0][0];
    int* p = &arr[0][0];
    
    while (destp <= &dest[HEIGHT - 1][WIDTH - 1])
        *destp++ = *p++;
    
}

void array_print(int (*arr)[WIDTH]) {
    int* p = &arr[0][0];
    int j = 1;
    while (p <= &arr[HEIGHT - 1][WIDTH - 1]) {
        printf("%3d ", *p++);
        if (!(j++ % WIDTH)) printf("\n");
    }
}

int main(void) {
    int score[HEIGHT][WIDTH] = {{100, 30, 67},
        {89, 50, 12},
        {19, 60, 90}};
    int tmp[HEIGHT][WIDTH];
    array_copy(tmp, score);
    array_print(tmp);
    
    return 0;
}
