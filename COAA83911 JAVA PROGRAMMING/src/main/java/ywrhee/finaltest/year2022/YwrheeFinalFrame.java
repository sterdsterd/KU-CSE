package ywrhee.finaltest;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class YwrheeFinalFrame extends JFrame implements ActionListener {
	Container frame = this.getContentPane();
	SubjectManager manager;	
	DefaultTableModel tableModel;
	JRadioButton ascRadioButton, descRadioButton;
	JComboBox comboBox;
	
	String[] tableCol = {"학번", "이름"};
	String[] tableColSearch = {"과목번호", "과목명", "신청인원"};
	
	public YwrheeFinalFrame(String title, SubjectManager manager){
		super(title);
		this.manager = manager;		
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
	}

	public void init() {
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		
		comboBox = new JComboBox(manager.sublist.stream().map(it->it.subID).toArray());
		comboBox.addActionListener(this);
		topPanel.add(comboBox);
		
		ButtonGroup sortGroup = new  ButtonGroup();
		ascRadioButton = new JRadioButton("ASC");
		ascRadioButton.addActionListener(this);
		ascRadioButton.setSelected(true);
		descRadioButton = new JRadioButton("DESC");
		descRadioButton.addActionListener(this);
		
		sortGroup.add(ascRadioButton);
		sortGroup.add(descRadioButton);
		topPanel.add(ascRadioButton);
		topPanel.add(descRadioButton);
		
		topPanel.add(new JLabel("검색할 학번"));
		
		JTextField searchField = new JTextField(10);
		searchField.addActionListener(e -> {
			List<Subject> result = manager.findStudent(searchField.getText());
			if (result.size() == 0) {
				JOptionPane.showMessageDialog(this, "학번을 확인해주세요", "학번 확인", JOptionPane.ERROR_MESSAGE);
			} else {
				tableModel.setRowCount(0);
				tableModel.setColumnIdentifiers(tableColSearch);
				result.stream().forEach(it -> {
					tableModel.addRow(new Object[] {it.subID, it.subName, it.stdmap.size()});
				});
			}
		});
		topPanel.add(searchField);
		
		frame.add(topPanel, BorderLayout.NORTH);
		
		tableModel = new DefaultTableModel(tableCol, 0);
		JTable table = new JTable(tableModel);
		comboBox.setSelectedItem(comboBox.getSelectedItem());
		
		frame.add(new JScrollPane(table), BorderLayout.SOUTH);

		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Subject selected = manager.findSubject((String) comboBox.getSelectedItem());
		tableModel.setRowCount(0);
		tableModel.setColumnIdentifiers(tableCol);
		
		if (ascRadioButton.isSelected()) {
			selected.stdmap.entrySet().stream()
			.map(it->it.getValue())
			.sorted(Comparator.comparing(Student::getStdID))
			.forEach(it -> {
				tableModel.addRow(new Object[] {it.stdID, it.stdName});
			});
		} else {
			selected.stdmap.entrySet().stream()
			.map(it->it.getValue())
			.sorted(Comparator.comparing(Student::getStdID).reversed())
			.forEach(it -> {
				tableModel.addRow(new Object[] {it.stdID, it.stdName});
			});
		}
		
	}		
}
