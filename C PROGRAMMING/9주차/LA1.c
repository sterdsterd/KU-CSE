/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #1
 * 작성일: 2022년 5월 2일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>

double dist(int a, int b, int c, int d) {
    return sqrt(pow(a - c, 2) + pow(b - d, 2));
}

int main(void) {
    int a = 0, b = 0, c = 0, d = 0;
    char in;

    while (1) {
        printf("첫 번째 점의 좌표를 입력하시오: ");
        scanf("%d %d", &a, &b);

        printf("두 번째 점의 좌표를 입력하시오: ");
        scanf("%d %d", &c, &d);

        printf("두 점 사이의 거리는 %lf입니다.\n", dist(a, b, c, d));

        printf("다시 수행하시겠습니까? (y/n)");

        while ((in = getchar()) == '\n');
        if (in != 'y') break;
    }

    return 0;
}
