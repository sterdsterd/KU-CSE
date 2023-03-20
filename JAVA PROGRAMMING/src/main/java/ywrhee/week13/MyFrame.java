package ywrhee.week13;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ItemListener {

    Container frame = this.getContentPane();
    JPanel panel1, panel2;
    String[] data = {"사과", "배", "포도"};
    JCheckBox[] checkBox = new JCheckBox[3];
    JLabel[] label = new JLabel[3];

    JTextField tf = new JTextField(10);
    JTextArea ta = new JTextArea(10, 10);
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
            checkBox[i].addItemListener(this);
            this.panel1.add(checkBox[i]);
        }
        this.panel1.add(tf);
        tf.addActionListener(e -> ta.append(tf.getText() + "\n"));
        frame.add(this.panel1, BorderLayout.NORTH);
    }

    private void initPanel2() {
        this.panel2 = new JPanel();
        for (int i = 0; i < data.length; i++) {
            label[i] = new JLabel(data[i]);
            //this.panel2.add(label[i]);
        }
        this.panel2.add(new JScrollPane(ta));
        frame.add(this.panel2, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        try {
            System.setProperty( "apple.laf.useScreenMenuBar", "true" );
            System.setProperty( "apple.awt.application.name", "202211342 이율원" );
            System.setProperty( "apple.awt.application.appearance", "system" );
            FlatDarkLaf.setup();
            UIManager.setLookAndFeel( new FlatDarkLaf() );

        }  catch (Exception e) {
            e.printStackTrace();
        }
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
            if (e.getStateChange() == ItemEvent.SELECTED) {
                this.panel2.add(label[index]);
            } else {
                this.panel2.remove(label[index]);
            }

            this.panel2.revalidate();
            this.panel2.repaint();
        }
    }
}
