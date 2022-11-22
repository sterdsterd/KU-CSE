package ywrhee.week13;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {

    Container frame = this.getContentPane();
    JPanel panel1, panel2;
    String[] data = {"사과", "배", "포도"};
    JCheckBox[] checkBox = new JCheckBox[3];
    JLabel[] label = new JLabel[3];
    MyFrame(String title) {
        super(title);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        init();
        this.setVisible(true);
    }

    private void init() {
        initPanel1();
        initPanel2();
    }

    private void initPanel1() {
        this.panel1 = new JPanel();
        for (int i = 0; i < data.length; i++) {
            checkBox[i] = new JCheckBox(data[i]);
            this.panel1.add(checkBox[i]);
        }
        frame.add(this.panel1, BorderLayout.NORTH);
    }

    private void initPanel2() {
        this.panel2 = new JPanel();
        for (int i = 0; i < data.length; i++) {
            label[i] = new JLabel(data[i]);
            this.panel2.add(label[i]);
        }
        frame.add(this.panel2, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new MyFrame("202211342 이율원");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (e.getSource() == checkBox[i]) {
                index = i;
                break;
            }
        }
        if (index >= 0) {

        }
    }
}
