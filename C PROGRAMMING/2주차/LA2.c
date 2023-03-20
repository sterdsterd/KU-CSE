/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #1
 * 작성일: 2022년 3월 14일
 */

#include <stdio.h>
int main(void) {
	float celsius, fahrenheit;
	printf("이름: 이율원\n학번: 202211342\n수행일자: 2022. 3. 14\n\n화씨 온도를 입력하세요: ");
	scanf("%f", &fahrenheit);
	celsius = 5.0 / 9.0 * (fahrenheit - 32);
	printf("섭씨 온도는 %0.2f도 입니다.", celsius);

	return 0;
}
