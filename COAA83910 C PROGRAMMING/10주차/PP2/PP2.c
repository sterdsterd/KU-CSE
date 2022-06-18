/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Programming Practice #2
 * 작성일: 2022년 5월 9일
 */

#define _CRT_SECURE_NO_WARNINGS
#include "my.h"

int main(void) {
	int n;
	time_t t1, t2;
	printf("정수 입력하세요: ");
	scanf("%d", &n);
	
	t1 = time(NULL);
	printf("피보나치 수: %d\n", fib_iter(n));
	t2 = time(NULL);
	printf("반복문 시간: %d\n", t2 - t1);

	t1 = time(NULL);
	printf("피보나치 수: %d\n", fib(n));
	t2 = time(NULL);
	printf("재귀 호출 시간: %d\n", t2 - t1);

	return 0;
}

int fib(int n) {
	if (n == 0) return 0;
	if (n == 1) return 1;
	return (fib(n - 1) + fib(n - 2));
}

int fib_iter(int n) {
	if (n < 2) return n;
	else {
		int i, tmp, f1 = 1, f0 = 0;
		for (i = 2; i <= n; i++) {
			tmp = f1;
			f1 += f0;
			f0 = tmp;
		}
		return f1;
	}
}
