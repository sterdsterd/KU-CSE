package ywrhee.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

public class GameFrame extends JFrame implements ActionListener {

    private JPanel containerPanel, bottomPanel;
    private JTextField userInput;
    private JTextArea logArea;
    private JButton inputButton;
    private JLabel turnLabel;
    private User user, computer;
    private HashSet<Word> wordsInBingoBoard = new HashSet<>();
    private int difficulty, winLoseInfo;

    public GameFrame(String title, User user, User computer, int N, int difficulty) {
        super(title);
        this.user = user;
        this.computer = computer;
        this.difficulty = difficulty;
        wordsInBingoBoard.addAll(user.getWordList());
        wordsInBingoBoard.addAll(computer.getWordList());

        this.setSize(N * 120 * 2 + 400, N * 120 + 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        init();

        this.add(containerPanel);
        this.setVisible(true);

        synchronized(this){
            try {
                this.wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void init() {
        containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());
        containerPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        turnLabel = new JLabel("<html><b>유저 차례</b> | 유저 빙고: " + user.getBingoCount() + "개, 컴퓨터 빙고: " + computer.getBingoCount() + "개</html>");
        turnLabel.setFont(turnLabel.getFont().deriveFont(20f));
        turnLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        containerPanel.add(turnLabel, BorderLayout.NORTH);

        user.constructBingoPanel();
        containerPanel.add(user.getBingoPanel(), BorderLayout.WEST);

        computer.constructBingoPanel();
        containerPanel.add(computer.getBingoPanel(), BorderLayout.EAST);

        logArea = new JTextArea(10, 10);
        logArea.setEnabled(false);
        logArea.setDisabledTextColor(Color.decode("#777777"));
        logArea.setAutoscrolls(false);
        logArea.setLineWrap(true);
        logArea.setWrapStyleWord(true);
        containerPanel.add(new JScrollPane(logArea), BorderLayout.CENTER);

        bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));

        userInput = new JTextField("", 12);
        userInput.setMargin(new Insets(10, 10, 10, 10));
        userInput.addActionListener(this);
        bottomPanel.add(userInput);

        inputButton = new JButton("→");
        inputButton.setMargin(new Insets(10, 10, 10, 10));
        inputButton.addActionListener(this);
        bottomPanel.add(inputButton);

        containerPanel.add(bottomPanel, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inputButton || e.getSource() == userInput) {
            ArrayList<Word> filteredList = new ArrayList<>(wordsInBingoBoard.stream().filter(it -> it.getEnglish().equals(userInput.getText())).toList());

            if (!filteredList.isEmpty()) {
                filteredList.get(0).setChecked(true);
                logArea.setText((logArea.getText() + "\n" + filteredList.get(0) + "이(가) 선택되었습니다.").trim());
            }

            updateBingoBoard();

            userInput.setText("");
            userInput.setEditable(false);
            userInput.removeActionListener(this);
            inputButton.setEnabled(false);

            computerTurn();
        }
    }

    private void computerTurn() {
        turnLabel.setText("<html><b>컴퓨터 차례</b> | 유저 빙고: " + user.getBingoCount() + "개, 컴퓨터 빙고: " + computer.getBingoCount() + "개</html>");
        Word selectedWord = null;
        if (!computer.getWordList().stream().filter(it -> !it.isChecked()).toList().isEmpty()) {
            selectedWord = computer.selectWordToWin(difficulty, user.getWordList());
            selectedWord.setChecked(true);
        }

        Word finalSelectedWord = selectedWord;
        Timer timer = new Timer(1000, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (finalSelectedWord != null)
                    logArea.setText(logArea.getText() + "\n컴퓨터가 " + finalSelectedWord + "를 선택하였습니다.");
                updateBingoBoard();

                switch (winLoseInfo = checkWinner()) {
                    case Game.VICTORY:
                        JOptionPane.showMessageDialog(GameFrame.this, "당신이 이겼습니다.", "게임 종료", JOptionPane.INFORMATION_MESSAGE);
                        closeGameFrame();
                        break;

                    case Game.DEFEAT:
                        JOptionPane.showMessageDialog(GameFrame.this, "컴퓨터가 이겼습니다.", "게임 종료", JOptionPane.ERROR_MESSAGE);
                        closeGameFrame();
                        break;

                    case Game.DRAW:
                        JOptionPane.showMessageDialog(GameFrame.this, "무승부입니다.", "게임 종료", JOptionPane.WARNING_MESSAGE);
                        closeGameFrame();
                        break;

                    default:
                        break;
                }
                turnLabel.setText("<html><b>유저 차례</b> | 유저 빙고: " + user.getBingoCount() + "개, 컴퓨터 빙고: " + computer.getBingoCount() + "개</html>");

                inputButton.setEnabled(true);
                userInput.addActionListener(GameFrame.this);
                userInput.setEditable(true);
            }
        });
        timer.setRepeats(false);
        timer.start();

    }

    private int checkWinner() {
        user.updateBingoCount();
        computer.updateBingoCount();
        turnLabel.setText("<html><b>컴퓨터 차례</b> | 유저 빙고: " + user.getBingoCount() + "개, 컴퓨터 빙고: " + computer.getBingoCount() + "개</html>");

        if (user.getBingoCount() > computer.getBingoCount()) {
            return Game.VICTORY;
        } else if (user.getBingoCount() < computer.getBingoCount()) {
            return Game.DEFEAT;
        } else if (user.isSelectable() && computer.isSelectable()) {
            return Game.KEEP_GOING;
        } else return Game.DRAW;
    }

    private void updateBingoBoard() {
        containerPanel.remove(user.getBingoPanel());
        user.constructBingoPanel();
        containerPanel.add(user.getBingoPanel(), BorderLayout.WEST);

        containerPanel.remove(computer.getBingoPanel());
        computer.constructBingoPanel();
        containerPanel.add(computer.getBingoPanel(), BorderLayout.EAST);

        GameFrame.this.revalidate();
        GameFrame.this.repaint();
    }

    private void closeGameFrame() {
        synchronized(this){
            this.notify();
        }

        this.setVisible(false);
        this.dispose();
    }

    public int getWinLoseInfo() {
        return winLoseInfo;
    }

}
