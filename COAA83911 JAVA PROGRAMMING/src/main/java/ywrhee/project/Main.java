package ywrhee.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Word> wordList = new ArrayList<>();
        Word[][] bingoBoard = new Word[N][N];

        try (Scanner fileScanner = new Scanner(new File("/Users/dex.rhee/Desktop/KU-CSE/KU-CSE/COAA83911 JAVA PROGRAMMING/src/ywrhee/project/wordList.txt"))){
            while(fileScanner.hasNextLine()) {
                String str = fileScanner.nextLine();
                String[] wordInfo = str.split("\t");
                String english = wordInfo[0].trim();
                String korean = wordInfo[1].trim();
                wordList.add(new Word(english, korean));
            }
            System.out.println("단어장 로딩이 완료되었습니다.");
            //this.menu();

        } catch (FileNotFoundException e) {
            System.out.println("단어장을 로딩할 수 없습니다. \n파일명을 확인하세요.");
        }


    }
}
