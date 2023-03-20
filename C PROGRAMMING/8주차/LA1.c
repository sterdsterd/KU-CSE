/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #1
 * 작성일: 2022년 4월 25일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
    char opt;
    int a, b;

    do {
        printf("*******************\n");
        printf("A-Add\n");
        printf("S-Subtract\n");
        printf("M-Multiply\n");
        printf("D-Divide\n");
        printf("Q-Quit\n");
        printf("*******************\n");
        printf("연산을 선택하시오: ");
        while ((opt = getchar()) == '\n');
        
        if (opt == 'Q') break;
 
        switch (opt) {
        case 'A':
            printf("두 수를 입력하시오: ");
            scanf("%d %d", &a, &b);
            printf("%d + %d = %d\n", a, b, a + b);
            break;

        case 'S':
            printf("두 수를 입력하시오: ");
            scanf("%d %d", &a, &b);
            printf("%d - %d = %d\n", a, b, a - b);
            break;

        case 'M':
            printf("두 수를 입력하시오: ");
            scanf("%d %d", &a, &b);
            printf("%d * %d = %d\n", a, b, a * b);
            break;

        case 'D':
            printf("두 수를 입력하시오: ");
            scanf("%d %d", &a, &b);
            printf("%0.2lf / %0.2lf = %0.2lf\n", (double)a, (double)b, (double)a / b);
            break;

        default:
            printf("잘못 입력하였습니다.\n");
            break;
        }
    } while (1);

    return 0;
}
