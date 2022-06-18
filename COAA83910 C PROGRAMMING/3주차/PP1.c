/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Programming Practice #1
 * 작성일: 2022년 3월 21일
 */

#include <stdio.h>

int main(void) {
	float salary;
    
	printf("\aEnter your desired monthly salary:");
	printf(" $----------\b\b\b\b\b\b\b");
	scanf("%f", &salary);
	printf("\n\t$%.2f a month is $%.2f a year.", salary, salary * 12.0);
	printf("\rGee!\n");

	return 0;
}
