/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Programming Practice #1
 * 작성일: 2022년 5월 9일
 */

#include <stdio.h>

void up_and_down(int n);

int main(void) {
	up_and_down(1);
	return 0;
}

void up_and_down(int n) {
	printf("Level %d before a recursion\n", n);
	if (n < 4) up_and_down(n + 1);
	printf("Level %d after a recursion\n", n);
}
