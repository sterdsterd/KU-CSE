// 202211342 이율원
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define INT_MIN -2147483647

int main() {
    int num, max = INT_MIN, cnt = 0;
    
    printf("정수를 입력하세요: ");
    while (scanf("%d", &num) == 1) {
        if (num > max) max = num;
        printf("정수를 입력하세요: ");
        cnt++;
    }
    
    // 처음 입력 값이 정수가 아닌 경우 바로 종료
    if (cnt) printf("최대 정수 값은: %d", max);
    
    return 0;
}
