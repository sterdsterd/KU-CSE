package ywrhee.project;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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

        ArrayList<Game> statisticList = new ArrayList<>();
        File statisticFile;
        FileWriter statisticWriter = null;
        try {
            statisticFile = new File("statistics.txt");

            if (!statisticFile.exists()) statisticFile.createNewFile();

            statisticWriter = new FileWriter(statisticFile, true);

            Scanner statisticScanner = new Scanner(statisticFile);
            while(statisticScanner.hasNextLine()) {
                String str = statisticScanner.nextLine();
                statisticList.add(Game.parseGameInfo(str));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        while (true) {
            ArrayList<Word> wordList = new ArrayList<>();
            StartFrame startFrame = new StartFrame("BINGO GAME", statisticList);

            try (Scanner fileScanner = new Scanner(startFrame.getSelectedFile())){
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

            int N = startFrame.getN();
            int difficulty = startFrame.getDifficulty();

            User user = new User(wordList, N);
            User computer = new User(wordList, N);

            Game game = new Game(N, difficulty);

            GameFrame gameFrame = new GameFrame("BINGO GAME", user, computer, N, difficulty);
            game.setWinLoseInfo(gameFrame.getWinLoseInfo());

            statisticList.add(game);

            try {
                statisticWriter.write(game.getCsvInfo());
                statisticWriter.flush();
                System.out.println(game.getCsvInfo());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
//        try {
//            statisticsWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
