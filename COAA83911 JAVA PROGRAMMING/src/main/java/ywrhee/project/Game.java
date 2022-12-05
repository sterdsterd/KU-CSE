package ywrhee.project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

public class Game {
    static final String[] RESULT_TEXT = {"승리", "패배", "무승부"};
    static final int VICTORY = 0;
    static final int DEFEAT = 1;
    static final int DRAW = 2;
    static final int KEEP_GOING = 3;

    static final String[] DIFFICULTY_TEXT = {"쉬움", "보통", "어려움"};
    static final int EASY = 0;
    static final int NORMAL = 1;
    static final int HARD = 2;


    private int winLoseInfo;
    private int N;
    private int difficulty;
    private String playDateTime;

    public Game(int N, int difficulty) {
        this.N = N;
        this.difficulty = difficulty;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        this.playDateTime = LocalDateTime.now().format(formatter);
    }

    public Game(int winLoseInfo, int N, int difficulty, String playDateTime) {
        this.winLoseInfo = winLoseInfo;
        this.N = N;
        this.difficulty = difficulty;
        this.playDateTime = playDateTime;
    }

    // 승패 정보, 빙고판 크기, AI 수준, 플레이 시간 순으로 CSV 만들어 반환
    public String getCsvInfo() {
        return winLoseInfo + ", "
                + N + ", "
                + difficulty + ", "
                + playDateTime + "\n";
    }

    public Object[] getTableRow() {
        return new Object[] {RESULT_TEXT[winLoseInfo], N, DIFFICULTY_TEXT[difficulty], playDateTime};
    }


    public void setWinLoseInfo(int winLoseInfo) {
        this.winLoseInfo = winLoseInfo;
    }

    public int getWinLoseInfo() {
        return winLoseInfo;
    }

    public static Game parseGameInfo(String gameInfoAsCsv) {
        StringTokenizer stringTokenizer = new StringTokenizer(gameInfoAsCsv, ",");
        int winLoseInfo = Integer.parseInt(stringTokenizer.nextToken().trim());
        int N = Integer.parseInt(stringTokenizer.nextToken().trim());
        int difficulty = Integer.parseInt(stringTokenizer.nextToken().trim());
        String playDateTime = stringTokenizer.nextToken();

        return new Game(winLoseInfo, N, difficulty, playDateTime);
    }
}
