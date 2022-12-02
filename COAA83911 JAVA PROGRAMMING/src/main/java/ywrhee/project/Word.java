package ywrhee.project;

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
}
