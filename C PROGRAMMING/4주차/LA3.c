/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #3
 * 작성일: 2022년 3월 28일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>

int main(void) {
	int a, b, c;
	printf("Enter a, b and c for a quadratic equation ax^2 + bx + c = 0: \n");
	scanf("%d %d %d", &a, &b, &c);
	
	double ans1 = (-1.0 * b + sqrt(b * b - 4.0 * a * c)) / (2.0 * a);
	double ans2 = (-1.0 * b - sqrt(b * b - 4.0 * a * c)) / (2.0 * a);

	printf("The answer is <%0.2lf, %0.2lf>", ans1, ans2);

	return 0;
}
