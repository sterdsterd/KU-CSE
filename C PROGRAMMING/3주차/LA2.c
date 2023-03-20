/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #2
 * 작성일: 2022년 3월 21일
 */

#include <stdio.h>

int main(void) {
	int age;
	const double year = 3.156e7;

	printf("Enter your age: ");
	scanf("%d", &age);

	double val = age * year;

	printf("%d years old is %0.0f in seconds\nor %e in seconds", age, val, val);

	return 0;
}
