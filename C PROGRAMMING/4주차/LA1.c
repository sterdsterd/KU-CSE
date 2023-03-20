/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #1
 * 작성일: 2022년 3월 28일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define GRAVITY 9.8

int main(void) {
	double m, v, h;
	printf("물체의 질량 m (kg), 속도 v (m/s) 및 높이 h (m)를 입력하시오: ");
	scanf("%lf %lf %lf", &m, &v, &h);

	double kinetic = 1 / 2.0 * m * v * v;
	double potential = m * GRAVITY * h;
	double mechanical = kinetic + potential;

	printf("운동에너지:%10.2lf [J],\n", kinetic);
	printf("위치에너지:%10.2lf [J],\n", potential);
	printf("역학에너지:%10.2lf [J],", mechanical);

	return 0;
}
