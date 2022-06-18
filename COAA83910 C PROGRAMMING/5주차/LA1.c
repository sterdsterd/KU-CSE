/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #1
 * 작성일: 2022년 4월 4일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
	int x, y;
	printf("2개의 정수를 입력하시오: ");
	scanf("%d %d", &x, &y);

	if (x == 0) {
		if (y == 0) printf("두 수 모두 0입니다.");
		else printf("x는 0이고, y는 0이 아닙니다.");
	} else {
		if (y == 0) printf("x는 0이 아니고, y는 0입니다.");
		else printf("x, y는 모두 0이 아닙니다.");
	}
	return 0;
}
