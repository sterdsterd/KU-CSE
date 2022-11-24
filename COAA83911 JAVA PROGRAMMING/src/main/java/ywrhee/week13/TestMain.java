package ywrhee.week13;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class TestMain extends JFrame implements ItemListener {
    Container frame = this.getContentPane();
    JPanel panel1, panel2;
    JCheckBox[] checkbox = new JCheckBox[3];
    ButtonGroup group = new ButtonGroup();
    JLabel[] label = new JLabel[3];
    String[] data = {"사과", "배", "포도"};

    int lastSelected = 0;





    TestMain(String title){
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
        // 패널1 생성/체크박스 만들어 붙이기/체크박스 이벤트 넣기
        this.panel1 = new JPanel();
        for(int i = 0; i<data.length; i++) {
            //checkbox[i] = new JCheckBox(data[i]);
            //checkbox[i].addItemListener(this);

            JRadioButton a = new JRadioButton(data[i]);
            group.add(a);
            a.addItemListener(this);
            this.panel1.add(a);
        }
        frame.add(panel1, BorderLayout.NORTH);

    }
    private void initPanel2() {
        // 패널2 생성/레이블 만들어서 붙이기
        this.panel2 = new JPanel();
        for(int i = 0; i<data.length; i++) {
            label[i] = new JLabel(data[i]);
            //label[i].setVisible(false);
            //this.panel2.add(label[i]);
        }
        frame.add(panel2, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new TestMain("20000 홍길동");

    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        int index = 0;
        for(int i = 0; i<data.length; i++) {
            if(e.getSource() == e.getItem()) {
                index = i;
                break;
            }
        }
        if(index >=0) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                //label[index].setVisible(true);
                this.panel2.add(label[index]);
                lastSelected = index;
            }else {
                //this.panel2.remove(label[index]);
                this.panel2.remove(label[lastSelected]);
            }

            this.panel2.revalidate();
            this.panel2.repaint();
        }
    }


}
