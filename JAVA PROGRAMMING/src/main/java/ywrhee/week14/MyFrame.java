package ywrhee.week14;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    Container frame = this.getContentPane();

    JTextField tf;
    JButton btn1, btn2;

    MyDialog dlg = null;

    JPanel panel;
    JButton btn;
    DefaultTableModel model;
    JTable table;

    String[] title = {"아이디", "비밀번호", "이름"};

    MyFrame(String title) {
        super(title);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        init();
        this.setVisible(true);
    }

    private void init() {
        this.panel = new JPanel();
        this.btn = new JButton("정보 입력");
        btn.addActionListener(e -> {
            if (dlg == null)
                dlg = new MyDialog(this, "정보 입력", false);
            else
                dlg.requestFocus();
        });
        this.panel.add(btn);
        frame.add(panel, BorderLayout.NORTH);

        model = new DefaultTableModel(title, 0);
        table = new JTable(model);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new MyFrame("14주차");
    }
}
