/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #1
 * 작성일: 2022년 5월 17일
 */

#include <stdio.h>
#include <string.h>
#include <windows.h>
#include <stdlib.h>
#include <time.h>
#define SIZE 6

int main() {
	char ch[2];
	char word[SIZE];
	char input[SIZE];
	int i;
	while (1) {
		system("cls");
		srand(time(NULL));
		for (i = 0; i < 5; i++)
			word[i] = 'a' + (rand() % 26);
		word[i] = '\0';
		printf("%s\n", word);
		Sleep(2000);
		system("cls");
		printf("글자를 입력하세요: ");
		gets_s(input, SIZE);
		if (!strcmp(input, word))
			printf("정답입니다 ");
		else
			printf("안타깝네요~ ");
		printf("\n다시 수행하시겠습니까?");
		gets_s(ch, 2);
		if (ch[0] != 'y' && ch[0] != 'Y') break;
	}

	return 0;
}
