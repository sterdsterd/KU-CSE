/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #4
 * 작성일: 2022년 4월 4일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
	char c;
	printf("Enter a single character: ");
	scanf("%c", &c);

	if ('a' <= c && c <= 'z')
		printf("%c -> Capital Letter: %c", c, c - 'a' + 'A');
	else if ('A' <= c && c <= 'Z')
		printf("%c -> Ascii Code: %d", c, c);
	else
		printf("%c -> 알파벳이 아닙니다.", c);

	return 0;
}
