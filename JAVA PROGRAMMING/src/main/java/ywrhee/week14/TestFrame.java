package ywrhee.week14;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TestFrame extends JFrame implements ActionListener {

    Container frame = this.getContentPane();
    JLabel label = new JLabel("테스트 Test");
    TestFrame(String title) {
        super(title);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        init();
        this.setVisible(true);
    }

    private void init() {
        frame.add(label, BorderLayout.CENTER);
        initMenu();
    }

    private void initMenu() {
        label.setOpaque(true);

        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("선택");
        JMenuItem item1 = new JMenuItem("색상");
        item1.setActionCommand("colour");
        JMenuItem item2 = new JMenuItem("파일");
        item2.setActionCommand("file");

        item1.addActionListener(this);
        item2.addActionListener(this);

        menu.add(item1);
        menu.add(item2);
        mb.add(menu);
        this.setJMenuBar(mb);
    }

    public static void main(String[] args) {
        try {
            System.setProperty( "apple.laf.useScreenMenuBar", "true" );
            System.setProperty( "apple.awt.application.name", "202211342 이율원" );
            System.setProperty( "apple.awt.application.appearance", "light" );
            FlatLightLaf.setup();
            UIManager.setLookAndFeel( new FlatLightLaf() );

        }  catch (Exception e) {
            e.printStackTrace();
        }
        new TestFrame("202211342 이율원");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("colour")) {
            Color color = JColorChooser.showDialog(null, "색상 선택", Color.green);
            if (color != null) {
                label.setBackground(color);
            }
        } else if (e.getActionCommand().equals("file")) {
            JFileChooser jfc = new JFileChooser();
            FileNameExtensionFilter jFileExtensionFilter = new FileNameExtensionFilter("이미지 파일", "png", "jpg", "jpeg");
            jfc.setFileFilter(jFileExtensionFilter);
            jfc.showOpenDialog(null);

            File result = jfc.getSelectedFile();
            label.setIcon(new ImageIcon(result.getPath()));
            pack();
        }
    }
}
