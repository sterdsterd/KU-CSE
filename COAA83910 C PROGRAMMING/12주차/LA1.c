/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #1
 * 작성일: 2022년 5월 23일
 */

#include <stdio.h>

void get_int_real(double num, int* integer, double* frac) {
    *frac = num - (*integer = (int) num);
}

int main() {
    double num;
    int integer;
    double frac;
    
    printf("실수를 입력하시오 : ");
    scanf("%lf", &num);
    
    get_int_real(num, &integer, &frac);
    
    printf("정수 부분은 %d이고 소수점 이하 부분은 %.6lf 입니다.\n", integer, frac);
    
    return 0;
}
