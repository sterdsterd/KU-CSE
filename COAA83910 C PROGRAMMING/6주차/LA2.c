/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #2
 * 작성일: 2022년 4월 11일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
	int n, a = 0, b = 1;
	printf("2보다 큰 정수를 입력하세요: ");
	scanf("%d", &n);

	printf("피보나치 수열 f(%d):\nf(0)=0, f(1)=1, ", n);

	for (int i = 2; i <= n; i++) {
		int temp = b;
		b = a + b;
		a = temp;
		printf("f(%d)=%d", i, b);
		if (i != n) printf(", ");
		if (i % 5 == 0) printf("\n");
	}

	return 0;
}
