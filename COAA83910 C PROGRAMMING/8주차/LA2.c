/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #2
 * 작성일: 2022년 4월 25일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
    const int ROWS = 6;
    const int CHARS = 6;
    int row;
    char ch;
    for (row = ROWS - 1; row >= 0; row--) {
        for (ch = 'F'; ch >= ('A' + row); ch--)
            printf("%c", ch);
        printf("\n");
    }

    return 0;
}
