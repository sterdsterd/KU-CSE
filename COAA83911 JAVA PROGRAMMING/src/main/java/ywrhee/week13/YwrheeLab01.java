package ywrhee.week13;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class YwrheeLab01 extends JFrame implements ItemListener {

    Container frame = this.getContentPane();
    JPanel panel1, panel2;
    String[] data = {"사과", "배", "포도"};
    JRadioButton[] radioButton = new JRadioButton[3];
    ButtonGroup buttonGroup = new ButtonGroup();
    JLabel[] label = new JLabel[3];

    YwrheeLab01(String title) {
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
            radioButton[i] = new JRadioButton(data[i]);
            radioButton[i].addItemListener(this);
            buttonGroup.add(radioButton[i]);
            this.panel1.add(radioButton[i]);
        }
        frame.add(this.panel1, BorderLayout.NORTH);
    }

    private void initPanel2() {
        this.panel2 = new JPanel();
        for (int i = 0; i < data.length; i++) {
            label[i] = new JLabel(data[i]);
            //this.panel2.add(label[i]);
        }
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
        new YwrheeLab01("202211342 이율원");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int index = -1;
        System.out.println(e.getItem());
        for (int i = 0; i < data.length; i++) {
            if (e.getSource() == radioButton[i]) {
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
