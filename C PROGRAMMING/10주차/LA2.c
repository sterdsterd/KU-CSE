/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #2
 * 작성일: 2022년 5월 9일
 */

#include <stdio.h>
void reverse();
int main(void) {
	printf("String: ");
	reverse();
	return 0;
}

void reverse() {
	char ch;
	ch = getchar();
	if (ch != '\n') reverse();
	printf("%c", ch);
}
