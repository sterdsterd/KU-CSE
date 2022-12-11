package ywrhee.project;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class StartFrame extends JFrame implements ActionListener {

    private Container frame = this.getContentPane();
    private JPanel upperPanel;
    private JLabel title, name, nLabel;
    private JTextField nTextField, filePathTextField;
    private JButton goButton;
    private JRadioButton[] difficultyRadio = new JRadioButton[3];
    private ButtonGroup difficultyGroup = new ButtonGroup();
    private File selectedFile = new File("src/main/java/ywrhee/project/wordList.txt");
    private ArrayList<Game> statisticList;

    private int N = 0;

    public StartFrame(String title, ArrayList<Game> statisticList) {
        super(title);
        this.statisticList = statisticList;

        this.setSize(400, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        initUI();

        this.setVisible(true);

        synchronized(this){
            try {
                this.wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void initUI() {
        upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 0));

        title = new JLabel("빙고 게임", SwingConstants.CENTER);
        title.setFont(new Font("GangwonEduPower", Font.BOLD, 38));
        upperPanel.add(title, BorderLayout.NORTH);

        name = new JLabel("컴퓨터공학부 202211342 이율원", SwingConstants.CENTER);
        name.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));
        upperPanel.add(name, BorderLayout.SOUTH);

        frame.add(upperPanel, BorderLayout.NORTH);

        int gamePlayCount = statisticList.size();
        int victoryCount = (int) statisticList.stream().filter(it -> it.getWinLoseInfo() == Game.VICTORY).count();
        int drawCount = (int) statisticList.stream().filter(it -> it.getWinLoseInfo() == Game.DRAW).count();
        int defeatCount = (int) statisticList.stream().filter(it -> it.getWinLoseInfo() == Game.DEFEAT).count();
        double winRatio = (double) victoryCount / (victoryCount + defeatCount) * 100;
        winRatio = (double) Math.round(winRatio * 100) / 100;

        String winningInfoStr = gamePlayCount + "전 " + victoryCount + "승 " + drawCount + "무 " + defeatCount + "패 | 승률 " + winRatio + "%";

        JLabel winningInfo = new JLabel(winningInfoStr, SwingConstants.CENTER);
        winningInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        winningInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new StatisticDialog(StartFrame.this, "통계", statisticList, winningInfoStr);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                winningInfo.setText("<html><u>" + winningInfoStr + "</u></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                winningInfo.setText(winningInfoStr);
            }
        });
        frame.add(winningInfo, BorderLayout.CENTER);

        JPanel optionPanel = new JPanel();
        optionPanel.setBorder(BorderFactory.createEmptyBorder(0, 65, 50, 65));
        optionPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;

        JLabel filePathLabel = new JLabel("단어장 파일");
        filePathLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 0));
        optionPanel.add(filePathLabel, gridBagConstraints);

        filePathTextField = new JTextField(selectedFile.getName());
        filePathTextField.setEditable(false);
        filePathTextField.setMargin(new Insets(10, 10, 10, 10));
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridy++;
        optionPanel.add(filePathTextField, gridBagConstraints);

        JButton browseButton = new JButton("...");
        browseButton.setMargin(new Insets(10, 10, 10, 10));
        browseButton.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("텍스트 파일", "txt");
            jFileChooser.setFileFilter(filter);
            if (jFileChooser.showOpenDialog(null) == 0) {
                filePathTextField.setText(jFileChooser.getSelectedFile().getName());
                selectedFile = jFileChooser.getSelectedFile();
            }
        });
        gridBagConstraints.gridx++;
        gridBagConstraints.weightx = 0;
        optionPanel.add(browseButton, gridBagConstraints);
        gridBagConstraints.gridx--;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 1;

        // Difficulty Label
        JLabel difficultyLabel = new JLabel("AI 수준");
        difficultyLabel.setBorder(BorderFactory.createEmptyBorder(16, 0, 8, 0));
        gridBagConstraints.gridy++;
        optionPanel.add(difficultyLabel, gridBagConstraints);

        // Difficulty Radio Buttons
        JPanel difficultyPanel = new JPanel();
        difficultyPanel.setLayout(new GridLayout(1, 3));
        for (int i = 0; i < 3; i++) {
            difficultyRadio[i] = new JRadioButton(Game.DIFFICULTY_TEXT[i]);
            difficultyGroup.add(difficultyRadio[i]);
            difficultyPanel.add(difficultyRadio[i]);
        }
        difficultyRadio[Game.EASY].setSelected(true);
        gridBagConstraints.gridy++;
        optionPanel.add(difficultyPanel, gridBagConstraints);

        // N Label
        nLabel = new JLabel("빙고판 크기");
        nLabel.setBorder(BorderFactory.createEmptyBorder(16, 0, 8, 0));
        gridBagConstraints.gridy++;
        optionPanel.add(nLabel, gridBagConstraints);

        // N Input Text Field
        nTextField = new JTextField();
        nTextField.setMargin(new Insets(10, 10, 10, 10));
        nTextField.addActionListener(this);
        gridBagConstraints.gridy++;
        optionPanel.add(nTextField, gridBagConstraints);

        // Space Between Text Field and Button
        gridBagConstraints.insets = new Insets(35, 0, 0, 0);

        // Start Button
        goButton = new JButton("시작하기 →");
        goButton.setMargin(new Insets(10, 10, 10, 10));
        goButton.setFont(goButton.getFont());
        goButton.addActionListener(this);
        gridBagConstraints.gridy++;
        optionPanel.add(goButton, gridBagConstraints);

        frame.add(optionPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goButton || e.getSource() == nTextField) {
            try {
                if (!selectedFile.exists()) throw new FileNotFoundException();

                N = Integer.parseInt(nTextField.getText());
                nTextField.setText("");
                if (N < 3 || N > 10) {
                    N = 0;
                    throw new NumberFormatException();
                }

                int numberOfWords = countLine(selectedFile);
                if (N * N > numberOfWords) {
                    String dialogMessage = "단어의 수가 N²보다 작습니다.\n단어가 " + (N * N) + "개 이상인 단어장을 사용하거나, N을 " + (int) Math.sqrt(numberOfWords) + "이하의 값으로 입력해주세요.";
                    JOptionPane.showMessageDialog(this, dialogMessage, "오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                synchronized(this){
                    this.notify();
                }

                this.setVisible(false);
                this.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "N을 3과 10 사이의 정수 값으로 입력해주세요", "경고", JOptionPane.WARNING_MESSAGE);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "파일을 찾을 수 없습니다. 다른 파일을 선택해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private int countLine(File file) {
        int lines = 0;
        try {
            lines = (int) Files.lines(file.toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public int getN() {
        return N;
    }

    public File getSelectedFile() {
        return selectedFile;
    }

    public int getDifficulty() {
        for (int i = 0; i < 3; i++) {
            if (difficultyRadio[i].isSelected()) return i;
        }

        return -1;
    }
}
