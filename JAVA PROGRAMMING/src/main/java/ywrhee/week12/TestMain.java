package ywrhee.week12;

import javax.swing.*;
import java.awt.*;

public class TestMain extends JFrame {
    TestMain() {
        //getRootPane().putClientProperty( "apple.awt.fullWindowContent", true );
        //getRootPane().putClientProperty( "apple.awt.transparentTitleBar", true );
        //getRootPane().putClientProperty( "apple.awt.windowTitleVisible", false );
        setTitle("ContentPane과 JFrame 예제"); // 프레임의 타이틀 달기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane(); // 컨텐트패인 알아내기
        //contentPane.setBackground(Color.ORANGE); // 오렌지색 배경 설정
        contentPane.setLayout(new FlowLayout()); // 컨텐트패인에 FlowLayout
// 배치관리자 달기
        contentPane.add(new JButton("OK")); // OK 버튼 달기
        contentPane.add(new JButton("Cancel")); // Cancel 버튼 달기
        contentPane.add(new JButton("Ignore")); // Ignore 버튼 달기
        setSize(300, 150); // 프레임 크기 300x150 설정
        setVisible(true); // 화면에 프레임 출력
    }

    public static void main(String[] args) {
        try {
            System.setProperty( "apple.laf.useScreenMenuBar", "true" );
            System.setProperty( "apple.awt.application.name", "ContentPane과 JFrame 예제" );
            System.setProperty( "apple.awt.application.appearance", "system" );

        }  catch (Exception e) {
            System.out.println("?");
        }
        TestMain testMain = new TestMain();
    }
}
