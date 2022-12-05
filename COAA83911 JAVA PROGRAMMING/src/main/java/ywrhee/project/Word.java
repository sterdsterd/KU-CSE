package ywrhee.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Word {
    private boolean isChecked = false;
    private String english;
    private String korean;

    private int weight;

    public Word(String english, String korean) {
        this.english = english;
        this.korean = korean;
    }

    public String getEnglish() {
        return english;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return english + "(" + korean + ")";
    }

    public static ArrayList<Word> getWordList(File file) {
        ArrayList<Word> wordList = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(file)){
            while(fileScanner.hasNextLine()) {
                String str = fileScanner.nextLine();
                String[] wordInfo = str.split("\t");
                String english = wordInfo[0].trim();
                String korean = wordInfo[1].trim();
                wordList.add(new Word(english, korean));
            }
            //System.out.println(startFrame.getSelectedFile().getAbsolutePath() + " 로딩 완료");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return wordList;
    }
}
