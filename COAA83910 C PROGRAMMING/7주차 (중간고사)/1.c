// 202211342 이율원
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>
#define AREA_MAX 1000000000
#define RATIO_MAX 100

int main(void) {
    double area, ratio;
    int width, height;

    printf("넓이를 입력하세요: ");
    scanf("%lf", &area);
    printf("가로 세로 비율을 입력하세요: ");
    scanf("%d %d", &width, &height);

    if (area <= 0 || area >= AREA_MAX) {
        printf("넓이가 조건에 맞지 않습니다.");
    } else if (width <= 0 || width >= RATIO_MAX || height <= 0 || height >= RATIO_MAX) {
        printf("비율이 조건에 맞지 않습니다.");
    } else {
        // area = (width * ratio) * (height * ratio) 이므로
        ratio = sqrt(area / (width * height));
        printf("가로 길이: %0.2lf, 세로 길이: %0.2lf", ratio * width, ratio * height);
    }

    return 0;
}
