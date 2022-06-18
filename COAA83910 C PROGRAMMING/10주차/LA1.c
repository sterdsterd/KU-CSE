/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #1
 * 작성일: 2022년 5월 9일
 */

#include <stdio.h>
#include <stdlib.h>

void get_dice_face() {
	static int n1 = 0, n2 = 0, n3 = 0, n4 = 0, n5 = 0, n6 = 0;
	int roll = rand() % 6 + 1;

	if (roll == 1) n1++;
	else if (roll == 2) n2++;
	else if (roll == 3) n3++;
	else if (roll == 4) n4++;
	else if (roll == 5) n5++;
	else if (roll == 6) n6++;

	printf("현재 주사위 면: %d\n", roll);
	printf("면 별 나온 횟수:\n1: %d, 2: %d, 3: %d, 4: %d, 5: %d, 6: %d\n\n", n1, n2, n3, n4, n5, n6);
}

int main(void) {
	int i;
	printf("주사위 던지기를 시작합니다. \n");
	for (i = 0; i < 50; i++)
		get_dice_face();

	return 0;
}
