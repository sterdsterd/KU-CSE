/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Programming Practice #2
 * 작성일: 2022년 3월 14일
 */

#include <stdio.h>
int main(void) {
	float rent = 3852.99;

	printf("*%f*\n", rent);
	printf("*%e*\n", rent);
	printf("*%4.2f*\n", rent);
	printf("*%13.1f*\n", rent);
	printf("*%10.3e*\n", rent);
	printf("*%+4.2f*\n", rent);
	printf("*%019.2f*\n", rent);
	
	return 0;
}
