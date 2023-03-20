package ywrhee.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StatisticUtil {

    private static ArrayList<Game> statisticList;
    private static FileWriter statisticWriter;

    /**
     * Get saved statistic information from statistics.txt and save it to statisticList
     */
    public static void init() {
        statisticList = new ArrayList<>();
        File statisticFile;
        try {
            statisticFile = new File(System.getProperty("user.dir") + "/statistics.txt");

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
    }

    public static ArrayList<Game> getStatisticList() {
        return statisticList;
    }

    public static void addToStatisticList(Game game) {
        statisticList.add(game);
    }

    /**
     * Save Game information into the file as CSV formatted string
     * @param game Game object to save in the file
     */
    public static void writeStatistic(Game game) {
        try {
            statisticWriter.write(game.getCsvInfo());
            statisticWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatisticWriterStream() {
        try {
            statisticWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
