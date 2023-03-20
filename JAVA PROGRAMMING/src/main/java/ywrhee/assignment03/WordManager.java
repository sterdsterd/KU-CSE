package ywrhee.assignment03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class WordManager {

    final int NUMBER_OF_QUIZ = 10;
    final int NUMBER_OF_CHOICE = 4;
    private String userName;
    private HashMap<String, ArrayList<Word>> words = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public WordManager(String userName, String filePath) {
        this.userName = userName;

        try (Scanner fileScanner = new Scanner(new File(filePath))){
            while(fileScanner.hasNextLine()) {
                String str = fileScanner.nextLine();
                String[] wordInfo = str.split("\t");
                String korean = wordInfo[1].trim();
                String english = wordInfo[0].trim();

                if (!words.containsKey(korean)) {
                    words.put(korean, new ArrayList<>());
                }
                words.get(korean).add(new Word(english, korean));
            }
            System.out.println(userName + "의 단어장이 생성되었습니다.");
            this.menu();

        } catch (FileNotFoundException e) {
            System.out.println(userName + "의 단어장이 생성되지 않았습니다. \n파일명을 확인하세요.");
        }
    }

    private void menu() {
        for (int selection = -1; selection != 5;) {
            System.out.println("------ " + userName + "의 영단어 퀴즈 ------");
            System.out.println("1) 주관식 퀴즈  2) 객관식 퀴즈  3) 오답노트  4) 단어 검색  5) 종료");
            System.out.print("메뉴를 선택하세요: ");

            try {
                selection = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("메뉴를 숫자로 입력해주시기 바랍니다.");
                continue;
            }

            System.out.println();

            switch (selection) {
                case 1:
                    shortAnswerQuiz();
                    break;
                case 2:
                    multipleChoiceQuiz();
                    break;
                case 3:
                    correctionList();
                    break;
                case 4:
                    searchWord();
                    break;
                case 5:
                    System.out.println(userName + "의 단어장 프로그램을 종료합니다.");
                    break;
            }
        }
    }

    private void shortAnswerQuiz() {
        List<String> quizList = new ArrayList<>(words.keySet());
        Collections.shuffle(quizList);
        int correctCount = 0;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NUMBER_OF_QUIZ; i++) {
            String korean = quizList.get(i);
            List<Word> sameMeaningList = words.get(korean);
            sameMeaningList.forEach(Word::increasePresentCount);

            System.out.println("------ 주관식 퀴즈 " + (i + 1) + "번 ------");
            System.out.println("\"" + korean + "\"의 뜻을 가진 영어 단어는 무엇일까요?");
            System.out.print("답을 입력하세요: ");
            String answer = sc.nextLine().trim();

            if (sameMeaningList.stream().map(Word::getEnglish).toList().contains(answer)) {
                correctCount++;
                System.out.println("정답입니다.");
            } else {
                sameMeaningList.forEach(Word::increaseWrongCount);
                System.out.println("틀렸습니다. 정답은 "
                        + sameMeaningList.stream()
                            .map(Word::getEnglish)
                            .collect(Collectors.joining(" 또는 "))
                        + "입니다.");
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println(userName
                + "님 "
                + NUMBER_OF_QUIZ
                + "문제 중 "
                + correctCount
                + "개 맞추셨고, 총 "
                + (endTime - startTime) / 1000
                + "초 소요되었습니다."
        );
    }

    private void multipleChoiceQuiz() {
        List<String> quizList = new ArrayList<>(words.keySet());

        int correctCount = 0;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NUMBER_OF_QUIZ; i++) {
            Collections.shuffle(quizList);

            int answer = random.nextInt(NUMBER_OF_CHOICE);
            String korean = quizList.get(answer);
            Word quiz = words.get(korean).get(random.nextInt(words.get(korean).size()));
            quiz.increasePresentCount();
            quizList.stream()
                    .limit(4)
                    .filter(it -> !quiz.getKorean().equals(it))
                    .forEach(it ->
                        words.get(it)
                            .forEach(Word::increasePresentCount)
                    );

            System.out.println("------ 객관식 퀴즈 " + (i + 1) + "번 ------");
            System.out.println(quiz.getEnglish() + "의 뜻은 무엇일까요?");
            for (int j = 0; j < NUMBER_OF_CHOICE; j++) {
                System.out.println((j + 1) + ") " + quizList.get(j));
            }

            int choice = -1;
            for (;;) {
                try {
                    System.out.print("답을 입력하세요: ");
                    choice = sc.nextInt();
                    sc.nextLine();
                    if (choice < 1 || choice > NUMBER_OF_CHOICE) {
                        System.out.println("1에서 " + NUMBER_OF_CHOICE + "사이의 선택지를 입력해주세요");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("선택지를 정수로 압력해주세요.");
                    sc.nextLine();
                }
            }
            if (choice == answer + 1) {
                System.out.println("정답입니다.");
                correctCount++;
            } else {
                System.out.println("틀렸습니다. 정답은 " + (answer + 1) + "번입니다.");
                quiz.increaseWrongCount();
            }

            quizList.remove(korean);
        }

        long endTime = System.currentTimeMillis();
        System.out.println(userName
                + "님 "
                + NUMBER_OF_QUIZ
                + "문제 중 "
                + correctCount
                + "개 맞추셨고, 총 "
                + (endTime - startTime) / 1000
                + "초 소요되었습니다."
        );
    }

    private void correctionList() {
        List<Word> correctionWordList = new ArrayList<>();
        words.values().forEach(correctionWordList::addAll);

        correctionWordList = correctionWordList.stream()
                .filter(it -> it.getWrongCount() > 0)
                .sorted(Comparator.comparingInt(Word::getWrongCount).reversed())
                .toList();

        if (correctionWordList.size() == 0)
            System.out.println("오답노트에 단어가 없습니다.");
        else correctionWordList.forEach(System.out::println);

    }

    private void searchWord() {
        ArrayList<Word> wordList = new ArrayList<>();
        words.values().forEach(wordList::addAll);

        System.out.println("------ 단어 검색 ------");
        System.out.print("검색할 단어를 입력하세요: ");
        String query = sc.nextLine().trim();

        Word searchResult = wordList.stream()
                                    .filter(it -> it.getEnglish().equals(query))
                                    .findFirst()
                                    .orElse(null);

        System.out.println(searchResult != null ? searchResult : "단어장에 등록된 단어가 아닙니다");
    }

}
