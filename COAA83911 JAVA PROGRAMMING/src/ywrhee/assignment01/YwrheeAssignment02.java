package ywrhee.assignment01;

import java.util.Scanner;

public class YwrheeAssignment02 {

    public static Scanner scanner = new Scanner(System.in);

    static final int ROW = 4;
    static final int COL = 3;

    public static void main(String[] args) {
        //System.out.println("202211342 이율원");
        String[][] parkingSpace = new String[ROW][COL];
        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COL; j++)
                parkingSpace[i][j] = "";

        for (;;) {
            printParkStatus(parkingSpace);

            System.out.println("1) 주차하기 2) 차량검색 3) 출차하기 4) 종료");
            System.out.print("메뉴를 선택하세요 : ");
            int choice = scanner.nextInt();

            if (choice == 1) parkCar(parkingSpace);
            else if (choice == 2) searchCar(parkingSpace);
            else if (choice == 3) removeCar(parkingSpace);
            else if (choice == 4) {
                System.out.println("시스템을 종료합니다.");
                break;
            }
            else System.out.println("\n메뉴 번호를 확인 후 다시 입력해 주세요.\n");
        }

    }

    public static void printParkStatus(String[][] parkingSpace) {
        System.out.println("202211342 이율원");
        System.out.println("**** 주차 현황 ****");
        System.out.print("  ");
        for (int i = 0; i < COL; i++) System.out.print(i + 1 + " ");
        System.out.println();
        for (int i = 0; i < ROW; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < COL; j++) {
                System.out.print(parkingSpace[i][j].isEmpty() ? "♡ " : "♥ ");
            }
            System.out.println();
        }
    }

    public static void parkCar(String[][] parkingSpace) {
        System.out.println("**** 주차하기 ****");
        int parkRow, parkCol;
        for (;;) {
            System.out.print("주차할 위치를 선택해 주세요(입력예 : 2 1) : ");
            parkRow = scanner.nextInt() - 1;
            parkCol = scanner.nextInt() - 1;

            if (0 > parkRow || parkRow > ROW || 0 > parkCol || parkCol > COL) {
                System.out.println("위치 번호를 확인해 주세요. 처음부터 다시 시작해 주세요.");
                return;
            } else if (parkingSpace[parkRow][parkCol].isEmpty())
                break;
            else {
                System.out.println("다른 차량이 주차되어 있습니다. 처음부터 다시 시작해 주세요.");
                return;
            }
        }

        String carNum;

        System.out.print("차량 번호를 입력해 주세요(입력예 : 20가1234) : ");
        carNum = scanner.next();
        System.out.print("차량 번호 " + carNum + " 맞습니까(y/n)? ");
        if (!scanner.next().equals("y")) {
            System.out.println("처음부터 다시 진행해 주세요.");
            return;
        }

        parkingSpace[parkRow][parkCol] = carNum;
        System.out.println(carNum + "차량의 주차를 완료하였습니다.");
    }

    public static void searchCar(String[][] parkingSpace) {
        System.out.println("**** 차량 검색 ****");
        System.out.print("차량 번호를 입력해 주세요 : ");
        String carNum = scanner.next();

        boolean isFound = false;
        outer_loop:
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (parkingSpace[i][j].equals(carNum)) {
                    System.out.println(carNum + "는 (" + (i + 1) + ", " + (j + 1) + ")에 위치합니다.");
                    isFound = true;
                    break outer_loop;
                }
            }
        }

        if (!isFound) System.out.println("차량이 존재하지 않습니다. 차량번호 확인후 처음부터 다시 진행해 주세요.");
    }

    public static void removeCar(String[][] parkingSpace) {
        System.out.println("**** 출차하기 ****");
        System.out.print("차량 번호를 입력해 주세요 : ");
        String carNum = scanner.next();

        boolean isFound = false;
        outer_loop:
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (parkingSpace[i][j].equals(carNum)) {
                    parkingSpace[i][j] = "";
                    System.out.println(carNum + " 차량이 출차되었습니다. 안녕히 가세요.");
                    isFound = true;
                    break outer_loop;
                }
            }
        }

        if (!isFound) System.out.println("차량번호 확인후 처음부터 다시 진행해 주세요.");
    }
}
