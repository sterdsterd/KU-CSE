/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #2
 * 작성일: 2022년 3월 28일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define HR 3600
#define MIN 60

int main(void) {
	double speed, distance;
	printf("Enter the speed (km/h): ");
	scanf("%lf", &speed);
	printf("Enter the driving distance (km): ");
	scanf("%lf", &distance);
	int time = distance / speed * HR;

	int hr = time / HR;
	int min = (time % HR) / MIN;
	int sec = (time % MIN);
	
	printf("The total driving time is %d hours %d minutes %d seconds", hr, min, sec);
	
	return 0;
}
