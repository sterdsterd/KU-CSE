/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #1
 * 작성일: 2022년 3월 21일
 */

#include <stdio.h>

int main(void) {
	double val = (3.32e-3 + 9.76e-8) / (9.12e6 + 1.87e9);

	printf("%f\n", val);
	printf("%e\n", val);
	printf("%lf\n", val);
	printf("%le\n", val);
	printf("%0.20lf\n", val);

	return 0;
}