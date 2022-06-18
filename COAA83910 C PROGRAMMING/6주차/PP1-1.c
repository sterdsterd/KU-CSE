/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Programming Practice #2 - 1
 * 작성일: 2022년 4월 11일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
	char ch;
	scanf("%c", &ch);
	while (ch != 'g') {
		printf("%c", ch);
		scanf("%c", &ch);
	}

	return 0;
}
