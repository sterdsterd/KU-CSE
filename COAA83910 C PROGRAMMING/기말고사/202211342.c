// 202211342 이율원
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define ASIZE 10

void show_menu() {
	printf("1. a의 b승 구하기\n");
	printf("2. 배열 합병\n");
	printf("3. 더하기야 놀자\n");
	printf("4. 끝내기\n");
	printf("메뉴를 선택하세요: ");
}

double rpow(double a, double b) {
	if (b == 1) return a;
	else return a * rpow(a, b - 1);
}

void cal_pow() {
	double a, b;
	printf("양의 실수 두 개를 입력하시오: ");
	scanf("%lf %lf", &a, &b);
	printf("%.2f의 %.2f승은 %.2f입니다. \n", a, b, rpow(a, b));
}

void print_array_list(int* arr, int size) {
	int* p = &arr[0];
	while (p <= &arr[size - 1])
		printf("%d ", *p++);
}

void merge(int* m, int* a1, int* a2) {
	int* mp = &m[0];
	int* a1p = &a1[0];
	int* a2p = &a2[0];

	while (a1p <= &a1[ASIZE - 1] && a2p <= &a2[ASIZE - 1]) {
		if (*a1p < *a2p) *m++ = *a1p++;
		else *m++ = *a2p++;
	}
	
	while (a1p <= &a1[ASIZE - 1])
		*m++ = *a1p++;

	while (a2p <= &a2[ASIZE - 1])
		*m++ = *a2p++;
}

void merge_array() {
	int a1[ASIZE] = { 13, 27, 29, 54, 100, 231, 244, 350, 351, 459 };
	int a2[ASIZE] = { 2, 3, 10, 13, 27, 141, 142, 190, 245, 400 };
	int* m = (int*) calloc(2 * ASIZE, sizeof(int));

	printf("\n배열 합병 문제입니다. \n");
	printf("첫 번째 배열 리스트: ");
	print_array_list(a1, ASIZE);
	printf("\n");
	printf("두 번째 배열 리스트: ");
	print_array_list(a2, ASIZE);
	printf("\n");
	merge(m, a1, a2);
	printf("합병된 배열 리스트: ");
	print_array_list(m, ASIZE * 2);
}

int set_rand(int min, int max) {
	return rand() % (max - min + 1) + min;
}

void play_add(int* total_score) {
	int min, max, i, score = 0;
	unsigned int start = time(NULL), end;
	printf("더하기야 놀자 게임을 시작합니다.\n");
	printf("게임에 사용할 숫자 범위의 최소값과 최대값을 입력하세요: ");
	scanf("%d %d", &min, &max);

	for (i = 0; i < 5; i++) {
		int a = set_rand(min, max);
		int b = set_rand(min, max);
		int answer;
		printf("%d + %d = ", a, b);
		scanf("%d", &answer);

		if (answer != (a + b)) printf("정답은 %d 입니다.\n", a + b);
		else score += 10;
	}
	end = time(NULL);
	printf("총 수행 시간: %d초, 문제당 평균 시간: %.2f초\n", end - start, (end - start) / 5.0);
	printf("이번 게임에서 %d 점을 획득하여서, 현재까지 총 점수는 %d점 입니다.\n\n", score, *total_score += score);
}

int main() {
	int total_score = 0;

	for (;;) {
		int input = 0;
		show_menu();
		scanf("%d", &input);

		switch (input) {

		case 1:
			cal_pow();
			break;

		case 2:
			merge_array();
			printf("\n");
			break;

		case 3:
			play_add(&total_score);
			break;

		case 4:
			return 0;
			break;

		default:
			continue;
		}
	}

	return 0;
}