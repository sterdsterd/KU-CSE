package ywrhee.project;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BingoGame {

    public static void main(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("apple.awt.application.name", "202211342 이율원");
        System.setProperty("apple.awt.application.appearance", "system");
        FlatDarkLaf.setup();

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            UIManager.getLookAndFeelDefaults().put("defaultFont", new Font("Pretendard", Font.PLAIN, 14));
        } catch (Exception e) {
            e.printStackTrace();
        }

        StatisticUtil.init();

        while (true) {
            StartFrame startFrame = new StartFrame("BINGO GAME", StatisticUtil.getStatisticList());

            ArrayList<Word> wordList = Word.getWordList(startFrame.getSelectedFile());
            int N = startFrame.getN();
            int difficulty = startFrame.getDifficulty();

            User user = new User(wordList, N);
            User computer = new User(wordList, N);

            Game game = new Game(N, difficulty);
            GameFrame gameFrame = new GameFrame("BINGO GAME", user, computer, N, difficulty);
            game.setWinLoseInfo(gameFrame.getWinLoseInfo());

            StatisticUtil.addToStatisticList(game);
            StatisticUtil.writeStatistic(game);

        }

    }

}
