/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Programming Practice #1
 * 작성일: 2022년 4월 4일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
	int x, y;
	printf("2개의 정수를 입력하시오: ");
	scanf("%d %d", &x, &y);
	if (x == 0)
		if (y == 0)
			printf("두 수 모두 0입니다.\n");
		else printf("둘 중에서 하나는 0입니다.\n");
	return 0;
}
