/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Programming Practice #1
 * 작성일: 2022년 3월 14일
 */

#include <stdio.h>
int main(void) {
	int pages = 931;

	printf("*%d*\n", pages);
	printf("*%2d*\n", pages);
	printf("*%10d*\n", pages);
	printf("*%-10d*\n", pages);
	printf("*%+d*\n", pages);

	return 0;
}
