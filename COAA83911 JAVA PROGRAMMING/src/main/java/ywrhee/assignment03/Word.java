package ywrhee.assignment03;

public class Word {
    private String english;
    private String korean;
    private int wrongCount = 0;
    private int presentCount = 0;

    public Word(String english, String korean) {
        this.english = english;
        this.korean = korean;
    }

    public String getEnglish() {
        return english;
    }

    public String getKorean() {
        return korean;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    public void increaseWrongCount() {
        wrongCount++;
    }

    public void increasePresentCount() {
        presentCount++;
    }

    @Override
    public String toString() {
        return english + " 뜻: " + korean + "\n"
                + "출제횟수: " + presentCount + "\t오답횟수: " + wrongCount + "\n"
                + "------------------------------";
    }
}
