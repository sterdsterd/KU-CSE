/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #2 - 1
 * 작성일: 2022년 5월 2일
 */


#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <windows.h>
#include <conio.h>

void gotoxy(int x, int y) {
    COORD Cur = { x, y };
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), Cur);
}

int main() {
    int x = 40, y = 12, ch;

    while (1) {
        gotoxy(x, y);
        printf("*\b");
        ch = _getch();
        if (ch == 224) {
            printf(" ");

            ch = _getch();

            switch (ch) {
            case 72:
                y--;
                break;

            case 80:
                y++;
                break;

            case 75:
                x--;
                break;

            case 77:
                x++;
                break;

            }
        }
    }

    return 0;
}