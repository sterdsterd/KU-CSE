/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: 문제 1 - 맥주 소비
 * 작성일: 2022년 3월 28일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define KG_PER_YEAR 6.80389 // 1년동안 매일 맥주 350ml 1캔 섭취 시 증가하는 몸무게
#define YEAR 365 // 1년의 일 수
#define BEER_KCAL 150 // 맥주 350ml 한 캔당 칼로리

int main(void) {

    // 변수 선언 및 데이터 입력 받기
    double daily; // 1일 평균 맥주 소비 캔 수
    int price; // 평균 맥주 가격

    printf("1일 평균 맥주 소비 캔 수: ");
    scanf("%lf", &daily);

    printf("평균 맥주 가격: ");
    scanf("%d", &price);

    double total; //총 맥주 소비 캔 수

    // 값 계산 및 출력
    printf("총 맥주 소비 캔: %0.2lf\n", total = daily * YEAR);
    printf("총 맥주 칼로리량: %0.2lfcals\n", total * BEER_KCAL);
    printf("몸무게 증가량: %0.2lfkg\n", KG_PER_YEAR * daily);
    printf("총 맥주 소비 지출 액: %0.0lf원", total * price);

    return 0;

}