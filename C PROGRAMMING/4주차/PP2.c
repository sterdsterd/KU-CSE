/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Programming Practice #2
 * 작성일: 2022년 3월 28일
 */

#include <stdio.h>
#include <math.h>

int main(void) {
	double a = 2;
	double b = 16;
	int c = -3;

	printf("square root of a is %.2lf.\n", sqrt(a));
	printf("b^a is %.0lf.\n", pow(b, a));
	printf("absolute value of c is %d.\n", abs(c));
	printf("log(b) is %.2lf.\n", log(b));

	return 0;
}
