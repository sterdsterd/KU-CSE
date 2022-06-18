/**
 * 학번: 202211342
 * 이름: 이율원
 * 교과목명 및 분반: C프로그래밍(0441)
 * 과제명: Programming Practice #1
 * 작성일: 2022년 5월 23일
 */

#include <stdio.h>
int main(void) {
    int urn[5] = {100, 200, 300, 400, 500};
    int *ptr1, *ptr2, *ptr3;
    ptr1 = urn;
    ptr2 = &urn[2];
    printf("ptr1 = %p, *ptr1 =%d, &ptr1 = %p\n", ptr1, *ptr1, &ptr1);
    printf("ptr2 = %p, *ptr2 =%d, &ptr2 = %p\n", ptr2, *ptr2, &ptr2);
    ptr3 = ptr1 + 4;
    printf("ptr1 + 4 = %p, *(ptr3) = %d\n", ptr1 + 4, *(ptr3));
    ptr1++;
    printf("ptr1++ = %p, *ptr1 =%d\n", ptr1, *ptr1);
    ptr2--;
    printf("ptr2-- = %p, *ptr2 = %d\n", ptr2, *ptr2);
    printf("ptr2 = %p, ptr1 = %p, ptr2 - ptr1 = %d\n", ptr2, ptr1, ptr2 - ptr1);
    printf("*ptr3 = %d, *(ptr3 - 2) = %d\n",*ptr3, *(ptr3 - 2));
    return 0;
}
