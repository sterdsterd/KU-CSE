/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Programming Practice #2 - 1
 * 작성일: 2022년 4월 25일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
    int evil1, evil2;
    char ch;

    do {
        printf("Enter a pair of integers:\n");
        scanf("%d %d", &evil1, &evil2);
        printf("The lesser of %d and %d is %d.\n", evil1, evil2, (evil1 < evil2) ? evil1 : evil2);
        printf("Press 'y' to continue, or 'q' to quit.");
        ch = getchar();
    } while (ch == 'y');

    printf("Bye.\n");

    return 0;
}
