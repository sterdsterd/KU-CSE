/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #1
 * 작성일: 2022년 5월 30일
 */

#include <stdio.h>
#include <math.h>

struct vector {
    double x;
    double y;
};

int main() {
    struct vector a, b;
    int k;
    
    printf("Vector A = ");
    scanf("%lf %lf", &a.x, &a.y);
    printf("Vector B = ");
    scanf("%lf %lf", &b.x, &b.y);
    printf("k = ");
    scanf("%d", &k);
    printf("A + B = (%.2lf , %.2lf)\n", a.x + b.x, a.y + b.y);
    printf("A - B = (%.2lf , %.2lf)\n", a.x - b.x, a.y - b.y);
    printf("A • B = %.2lf\n", a.x * b.x + a.y * b.y);
    printf("kA = (%.2lf , %.2lf)\n", k * a.x, k * a.y);
    printf("kB = (%.2lf , %.2lf)\n", k * b.x, k * b.y);
    printf("|A| = %.2lf\n", sqrt(a.x * a.x + a.y * a.y));
    printf("|B| = %.2lf\n", sqrt(b.x * b.x + b.y * b.y));
    
    return 0;
}
