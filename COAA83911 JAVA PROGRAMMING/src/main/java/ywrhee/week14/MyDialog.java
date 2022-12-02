package ywrhee.week14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Arrays;

@SuppressWarnings("serial")
public class MyDialog extends JDialog {
    Container dialog = this.getContentPane();
    MyFrame parent;
    boolean modal;
    MyDialog(MyFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        parent = owner;
        this.modal = modal;
        this.setSize(300, 300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        init();
        initWinListener();
        this.setVisible(true);
    }

    private void init() {
        dialog.setLayout(new GridLayout(4, 2));

        JLabel id = new JLabel("아이디");
        JLabel pw = new JLabel("비밀번호");
        JLabel name = new JLabel("이름");

        JTextField idField = new JTextField();
        JPasswordField pwField = new JPasswordField();
        JTextField nameField = new JTextField();

        JButton ok = new JButton("입력");
        ok.addActionListener(e -> {
            String idstr = idField.getText();
            if (idstr.length() > 0) {
                String[] row = {idstr, new String(pwField.getPassword()), nameField.getText()};
                parent.model.addRow(row);
            }
        });
        JButton cancel = new JButton("취소");

        dialog.add(id);
        dialog.add(idField);
        dialog.add(pw);
        dialog.add(pwField);
        dialog.add(name);
        dialog.add(nameField);
        dialog.add(ok);
        dialog.add(cancel);
    }

    private void initWinListener() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);

                if (!modal) {
                    parent.dlg = null;
                }
                dispose();
            }
        });
    }
}
