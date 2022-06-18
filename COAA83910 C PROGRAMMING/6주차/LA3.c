/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #3
 * 작성일: 2022년 4월 11일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
	int n;
	printf("양의 정수를 입력하세요: ");
	
	for (scanf("%d", &n); n > 0; n /= 10) printf("%d", n % 10);

	return 0;
}
