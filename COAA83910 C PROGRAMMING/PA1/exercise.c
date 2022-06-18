/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: 문제 3 - 운동을 하자
 * 작성일: 2022년 3월 28일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define KCAL_PER_MIN (150.0 / 40.0) // 1분 운동에 소모되는 칼로리
#define BEER_KCAL 150 // 맥주 한 캔당 칼로리
#define YEAR 365 // 1년의 일 수
#define HOUR_IN_SEC 3600 // 1시간 = 3600초
#define MIN_IN_SEC 60 // 1분 = 60초


int main(void) {

    // 변수 선언 및 데이터 입력
    double daily; // 1일 평균 맥주 소비 캔 수
    int time; // 1일 평균 걷는 시간 (분 단위)

    printf("1일 평균 맥주 소비 캔 수: ");
    scanf("%lf", &daily);

    printf("1일 평균 걷는 시간 (분단위): ");
    scanf("%d", &time);

    // 총 운동 시간 (초)
    int totalTime = (daily * BEER_KCAL * YEAR) / KCAL_PER_MIN * MIN_IN_SEC;
    printf("맥주 칼로리를 소모하는데 필요한 총 운동 시간: %0.2lf분 ", totalTime / (double) MIN_IN_SEC); //초 -> 분
    printf("(%d시간 % d분 % d초)\n", totalTime / HOUR_IN_SEC, (totalTime % HOUR_IN_SEC) / MIN_IN_SEC, totalTime % MIN_IN_SEC);

    // 추가 운동 시간 (초) = 총 운동 시간 (초) - 1일 평균 운동 시간(분 -> 초) * 365일
    int leftTime = totalTime - (time * MIN_IN_SEC * YEAR);
    printf("추가로 필요한 운동 시간: %0.2lf분 ", leftTime / (double) MIN_IN_SEC); //초 -> 분
    printf("(%d시간 % d분 % d초)\n", leftTime / HOUR_IN_SEC, (leftTime % HOUR_IN_SEC) / MIN_IN_SEC, leftTime % MIN_IN_SEC);

    // 필요한 1일 평균 운동 시간 (초) = 추가 운동 시간 / 365일 + 1일 평균 걷는 시간(분 -> 초)
    int avgTime = ((double)leftTime / YEAR + time * MIN_IN_SEC);
    printf("1일 평균 운동 시간: %0.2lf분 ", avgTime / (double) MIN_IN_SEC);
    printf("(%d시간 % d분 % d초)", avgTime / HOUR_IN_SEC, (avgTime % HOUR_IN_SEC) / MIN_IN_SEC, avgTime % MIN_IN_SEC);

    return 0;

}