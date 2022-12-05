package ywrhee.project;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class User {
    private Word[][] bingoBoard;
    private int bingoCount = 0;
    private ArrayList<Word> wordList;
    private JLabel[][] labels;
    private JPanel bingoPanel;
    private int N;

    public User(ArrayList<Word> fullWordList, int N) {
        this.N = N;
        bingoBoard = new Word[N][N];
        labels = new JLabel[N][N];

        Collections.shuffle(fullWordList);
        wordList = new ArrayList<>(fullWordList.stream().limit(N * N).toList());

        for (int i = 0, k = 0; i < N; i++) {
            for (int j = 0; j < N; j++, k++) {
                bingoBoard[i][j] = wordList.get(k);
            }
        }

    }

    public void constructBingoPanel() {
        bingoPanel = new JPanel();
        bingoPanel.setLayout(new GridLayout(N, N, -1, -1));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                labels[i][j] = new JLabel(bingoBoard[i][j].getEnglish(), SwingConstants.CENTER);
                labels[i][j].setBorder(BorderFactory.createLineBorder(Color.decode("#777777")));
                labels[i][j].setPreferredSize(new Dimension(120, 120));

                if (bingoBoard[i][j].isChecked()) {
                    labels[i][j].setOpaque(true);
                    labels[i][j].setBackground(Color.decode("#3a4d43")); //#036b3f 1f5540
                    labels[i][j].setForeground(Color.decode("#dddddd"));
                }

                bingoPanel.add(labels[i][j]);
            }
        }
    }

    public JPanel getBingoPanel() {
        return bingoPanel;
    }

    public ArrayList<Word> getWordList() {
        return wordList;
    }

    public boolean isSelectable() {
        return getWordList().stream().filter(it -> !it.isChecked()).findAny().orElse(null) != null;
    }

    public void updateBingoCount() {
        bingoCount = 0;

        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < N; i++) {
            int sumV = 0, sumH = 0;
            for (int j = 0; j < N; j++) {
                sumV += bingoBoard[i][j].isChecked() ? 1 : 0;
                sumH += bingoBoard[j][i].isChecked() ? 1 : 0;
            }
            if (sumV == N) bingoCount++;
            if (sumH == N) bingoCount++;
            sum1 += bingoBoard[i][i].isChecked() ? 1 : 0;
            sum2 += bingoBoard[N - i - 1][i].isChecked() ? 1 : 0;
        }

        if (sum1 == N) bingoCount++;
        if (sum2 == N) bingoCount++;
    }

    public int getBingoCount() {
        return bingoCount;
    }

    public Word selectWordToWin(int difficulty, ArrayList<Word> comparableList) {
        // Returns Random Word in wordList which is not checked when Difficulty == Easy
        if (difficulty == Game.EASY) {
            Collections.shuffle(wordList);
            return wordList.stream().filter(it -> !it.isChecked()).toList().get(0);
        }

        if (difficulty == Game.HARD && N % 2 == 1 && wordList.stream().filter(Word::isChecked).toList().isEmpty()) {
            return bingoBoard[N / 2][N / 2];
        }

        int[] hWeights = new int[N];
        Arrays.fill(hWeights, 0);
        int[] vWeights = new int[N];
        Arrays.fill(vWeights, 0);
        int d1Weights = 0, d2Weights = 0;
        Arrays.stream(bingoBoard).forEach(it -> Arrays.stream(it).forEach(it2 -> it2.setWeight(0)));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                hWeights[i] += bingoBoard[i][j].isChecked() ? 1 : 0;
                vWeights[j] += bingoBoard[j][i].isChecked() ? 1 : 0;
            }
            d1Weights += bingoBoard[i][i].isChecked() ? 1 : 0;
            d2Weights += bingoBoard[N - i - 1][i].isChecked() ? 1 : 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bingoBoard[i][j].setWeight(Integer.max(bingoBoard[i][j].getWeight(), hWeights[i]));
                bingoBoard[j][i].setWeight(Integer.max(bingoBoard[j][i].getWeight(), vWeights[j]));
            }
            bingoBoard[i][i].setWeight(Integer.max(bingoBoard[i][i].getWeight(), d1Weights));
            bingoBoard[N - i - 1][i].setWeight(Integer.max(bingoBoard[N - i - 1][i].getWeight(), d2Weights));
        }

        List<Word> bestSelections = wordList.stream()
                                            .filter(it -> !it.isChecked())
                                            .sorted(Comparator.comparingInt(Word::getWeight).reversed())
                                            .toList();

        // Returns first item in bestSelection when Difficulty == Normal
        if (difficulty == Game.NORMAL)
            return bestSelections.get(0);

        System.out.println("====================");
        bestSelections.forEach(System.out::println);

        // Returns first item in bestSelection which is not in comparableList when Difficulty == Hard
        if (bestSelections.stream().anyMatch(it -> it.getWeight() == N - 1))
            return bestSelections.stream().filter(it -> it.getWeight() == N - 1).toList().get(0);

        if (Math.random() < 0.5)
            return bestSelections.get(0);
        return bestSelections.stream().filter(it -> !comparableList.contains(it)).findFirst().orElse(bestSelections.get(0));
    }

}
