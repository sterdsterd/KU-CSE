/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #2
 * 작성일: 2022년 5월 17일
 */

#include <stdio.h>
#define SIZE 101

int main() {
    int count[26] = { 0 }, i;
    char string[SIZE];
    printf("Enter string\n");
    gets_s(string, SIZE);
    for (i = 0; i < SIZE; i++) {
        if ('a' <= string[i] && string[i] <= 'z') {
            count[string[i] - 'a']++;
        }
    }

    for (i = 0; i < 26; i++) {
        printf("%c: %d ", i + 'A', count[i]);
        if (i == 12) printf("\n");
    }
}
