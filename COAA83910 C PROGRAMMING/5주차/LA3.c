/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #3
 * 작성일: 2022년 4월 4일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define WAGE 8350
#define OVERTIME 30
#define OVERTIME_RATE 1.2
#define TAX_RATE_BELOW_100K 0.03
#define TAX_RATE_OVER_100K 0.05
#define OVER 100000

int main(void) {
	int time, weekly;
	double tax;

	printf("근무 시간을 입력하시오(시간단위): ");
	scanf("%d", &time);

	if (time > OVERTIME) {
		printf("기본 주급: %d\n", WAGE * OVERTIME);
		double overtime = OVERTIME_RATE * WAGE * (time - OVERTIME);
		printf("초과 수당: %d시간, %0.0f원\n", time - OVERTIME, overtime);
		weekly = WAGE * OVERTIME + overtime;
	}
	else weekly = time * WAGE;


	printf("주당 총 임금: %d원\n\n", weekly);

	if (weekly > OVER) {
		tax = TAX_RATE_OVER_100K * weekly;
		printf("주급이 10만원 초과로 5세율 적용, 세액: %0.0f원", tax);
	}
	else {
		tax = TAX_RATE_BELOW_100K * weekly;
		printf("주급이 10만원 이하로 3세율 적용, 세액: %0.0f원", tax);
	}

	printf("\n\n실 수령액: %0.0f원", weekly - tax);

	return 0;
}
