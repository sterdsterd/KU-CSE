/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Lab Assignment #2
 * 작성일: 2022년 5월 30일
 */

#include <stdio.h>
#include <string.h>
#define STU_SIZE 10
#define MAX 50

struct student {
    char name[MAX];
    char id[MAX];
    char cp[MAX];
    char major[MAX];
};

void show_menu() {
    printf("=====메뉴=====\n");
    printf("1. 학생 등록\n");
    printf("2. 학생 검색\n");
    printf("3. 학생 출력\n");
    printf("4. 종료\n");
    printf("=============\n");
    printf("메뉴를 입력하세요: ");
}

void insert_student(struct student* stu, int* cnt) {
    if (*cnt >= 10) {
        printf("더 이상 입력할 수 없습니다.\n");
    } else {
        printf("이름을 입력하세요: ");
        gets(stu[*cnt].name);
        printf("학번을 입력하세요: ");
        gets(stu[*cnt].id);
        printf("전화번호를 입력하세요: ");
        gets(stu[*cnt].cp);
        printf("전공을 입력하세요: ");
        gets(stu[*cnt].major);
        (*cnt)++;
    }
}

void search_student(struct student* stu, int cnt) {
    char name[MAX];
    int n = 0;
    printf("검색할 이름을 입력하세요: ");
    gets(name);
    for (int i = 0; i < cnt; i++) {
        if (!strcmp(stu[i].name, name)) {
            printf("----------\n");
            printf("%s (%s)\n", stu[i].name, stu[i].id);
            printf("CP: %s\n", stu[i].cp);
            printf("Major: %s\n", stu[i].major);
            printf("----------\n");
            n++;
        }
    }
    
    if (n == 0) printf("해당 학생이 없습니다.\n");
}

void show_list(struct student* stu, int cnt) {
    for (int i = 0; i < cnt; i++) {
        printf("----------\n");
        printf("%s (%s)\n", stu[i].name, stu[i].id);
        printf("CP: %s\n", stu[i].cp);
        printf("Major: %s\n", stu[i].major);
    }
    printf("----------\n");
}

int main() {
    struct student st[STU_SIZE];
    int count = 0, sel;
    while (1) {
        show_menu();
        scanf("%d", &sel);
        getchar();
        if (sel == 4) break;
        if (sel < 1 || sel > 4) continue;
        switch (sel) {
            case 1:
                insert_student(st, &count);
                break;
            case 2:
                search_student(st, count);
                break;
            case 3:
                show_list(st, count);
                break;
        }
    }
    
    return 0;    
}
