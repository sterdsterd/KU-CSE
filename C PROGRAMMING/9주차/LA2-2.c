/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #2 - 2
 * 작성일: 2022년 5월 2일
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// 0: 가위
// 1: 바위
// 2: 보
int set_random() {
    srand((unsigned)time(NULL));
    return rand() % 3;
}

int decision(int computer, int user) {
    if ((computer == 0 && user == 1) || (computer == 1 && user == 2) || (computer == 2 && user == 0)) {
        return 1;
    }
    else if ((computer == 0 && user == 2) || (computer == 1 && user == 0) || (computer == 2 && user == 1)) {
        return 2;
    }
    else if ((computer == 0 && user == 0) || (computer == 1 && user == 1) || (computer == 2 && user == 2)) {
        return 0;
    }
    else return -1;
}

void print_result(int code) {
    switch (code) {
    case -1:
        printf("잘못된 값이 입력되었습니다.");
        break;
    case 0:
        printf("무승부.");
        break;
    case 1:
        printf("승리.");
        break;
    case 2:
        printf("패배.");
        break;

    }
}

int get_input() {
    int tmp;
    scanf("%d", &tmp);

    return tmp;
}

int main(void) {
    int computer, user, result;
    char sel;
    while (1) {
        computer = set_random();
        user = get_input();
        printf("\ncomputer: %d, user: %d \n", computer, user);
        result = decision(computer, user);
        print_result(result);
        printf("\n\n게임 계속 진행하려면 아무키나 누르시오, 단, q를 누르면 끝납니다");
        while ((sel = getchar()) == '\n');
        if (sel == 'q') break;
    }
}
