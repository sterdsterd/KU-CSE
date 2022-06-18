/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #2 - 구현 2
 * 작성일: 2022년 4월 4일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
	char c;
	printf("문자를 입력하세요: ");
	scanf("%c", &c);
	
	if ('a' <= c && c <= 'z')
		switch (c) {
		case 'a' :
		case 'e' :
		case 'i' :
		case 'o' :
		case 'u' :
			printf("%c는 모음입니다.", c);
			break;

		default:
			printf("%c는 자음입니다.", c);
			break;
		}
	else printf("알파벳 소문자가 아닙니다.");

	return 0;
}