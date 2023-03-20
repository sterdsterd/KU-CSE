/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #1
 * 작성일: 2022년 4월 11일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
	int n, i = 1, sum = 0;
	printf("정수를 입력하세요: ");
	scanf("%d", &n);
	
	while (i <= n) {
		sum += i * i + 1;
		printf("%d + ", i * i + 1);
		i++;
	}

	printf("\b\b= %d", sum);

	return 0;
}
