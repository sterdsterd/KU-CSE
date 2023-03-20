/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #2
 * 작성일: 2022년 5월 23일
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h>
#include <conio.h>
#include <string.h>
#define SIZE 6
#define TIME_LIMIT 5

void show_string(char*);

int main() {
    char word[SIZE], input[SIZE];
    srand((unsigned int)time(NULL));
    long stime = time(0) - TIME_LIMIT;
    int j = 0;
    while (1) {

        if (time(0) >= stime + TIME_LIMIT) {
            system("cls");
            j = 0;
            show_string(word);
            stime = time(0);
        }

        if (_kbhit()) {
            char k = _getch();
            if (k == 27) break;
            if (k == '\b' && j > 0) {
                input[j] = '\0';
                j--;
                printf("\b \b");
            }
            if ('a' <= k && k <= 'z' || 'A' <= k && k <= 'Z') {
                input[j] = k;
                j++;
                printf("%c", k);
            }
            if (j == SIZE - 1) {
                input[j] = '\0';
                if (!strcmp(word, input)) {
                    printf("\n축하합니다.");
                    Sleep(1000);
                } else {
                    system("cls");
                    j = 0;
                    show_string(word);
                    stime = time(0);
                }
            }
        }

    }

}

void show_string(char* w) {

    int i;
    for (i = 0; i < 5; i++)
        *(w + i) = 'a' + (rand() % 26) - ('a' - 'A') * (rand() % 2);
    *(w + i) = '\0';

    printf("%s\n", w);
}
