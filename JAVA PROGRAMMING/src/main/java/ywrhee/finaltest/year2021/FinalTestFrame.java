package ywrhee.finaltest.year2021;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("serial")
public class FinalTestFrame extends JFrame {

	Container frame = this.getContentPane();
	
	VolunteerManager jhchi = new VolunteerManager("좋은세상만들기"); // 본인이름 이니셜 객체
	JLabel timeLabel;
	JButton threadStopBtn;

	String[] tableCol = {"이름", "성별", "나이", "봉사시간"};

	JComboBox volNameComboBox;
	DefaultTableModel tableModel;

	public FinalTestFrame() {
		this("200000 홍길동"); // 본인 학번 이름
	}
	
	public FinalTestFrame(String title) {
		super(title);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
	}	
	
	public void init() {
		JPanel top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));

		JPanel first = new JPanel();
		first.setLayout(new FlowLayout());
		timeLabel = new JLabel("2022년 12월 10일 22시 10분 00초");
		timeLabel.setFont(new Font("Serif", Font.PLAIN, 28));
		first.add(timeLabel);
		threadStopBtn = new JButton("STOP");
		first.add(threadStopBtn);

		JPanel second = new JPanel();
		second.setLayout(new FlowLayout());
		JTextField volNameTextField = new JTextField(15);
		second.add(volNameTextField);
		JTextField donationTimeTextField = new JTextField(5);
		second.add(donationTimeTextField);
		JTextField numberTextField = new JTextField(5);
		second.add(numberTextField);
		JButton addBtn = new JButton("추가");
		addBtn.addActionListener(e -> {

			String stat = jhchi.addVolunteer(new Volunteer(volNameTextField.getText(),
					Integer.parseInt(donationTimeTextField.getText()),
					Integer.parseInt(numberTextField.getText())));


			JOptionPane.showMessageDialog(null, stat, "Message", JOptionPane.INFORMATION_MESSAGE);

			volNameComboBox.removeAllItems();
			volNameComboBox.addItem("선택하세요");
			jhchi.volunteer.stream().map(it -> it.volName).forEach(it -> {
				volNameComboBox.addItem(it);
			});

		});
		second.add(addBtn);

		JPanel third = new JPanel();
		third.setLayout(new FlowLayout());
		volNameComboBox = new JComboBox(new String[]{"선택하세요"});
		volNameComboBox.addActionListener(e -> {
			String selectedVolunteer = (String) volNameComboBox.getSelectedItem();

			tableModel.setRowCount(0);
			if (selectedVolunteer != null && jhchi.findVolunteer(selectedVolunteer) != null)
				jhchi.findVolunteer(selectedVolunteer).member.stream()
						.sorted(Comparator.comparingInt(Member::getTotalDonationTime).reversed())
						.forEach(it -> {
							tableModel.addRow(new Object[] {
									it.name,
									it.gender == 1 ? "남자" : "여자",
									it.age,
									it.totalDonationTime
							});
						});
		});
		third.add(volNameComboBox);
		JTextField memberNameTextField = new JTextField(10);
		memberNameTextField.addActionListener(e -> {
			if (!jhchi.member.containsKey(memberNameTextField.getText()))
				JOptionPane.showMessageDialog(null, "회원가입 먼저 하세요", "Message", JOptionPane.INFORMATION_MESSAGE);
			else {
				Member member = jhchi.getMember(memberNameTextField.getText());
				String str = jhchi.findVolunteer((String) volNameComboBox.getSelectedItem()).join(member);
				JOptionPane.showMessageDialog(null, str, "Message", JOptionPane.INFORMATION_MESSAGE);
				volNameComboBox.setSelectedIndex(volNameComboBox.getSelectedIndex());
			}
		});
		third.add(memberNameTextField);

		tableModel = new DefaultTableModel(tableCol, 0);
		JTable table = new JTable(tableModel);

		JButton saveBtn = new JButton("저장하기");
		saveBtn.addActionListener(e -> {
			try {
				File file = new File(volNameComboBox.getSelectedItem() + ".txt");
				file.createNewFile();

				FileWriter writer = new FileWriter(file);
				jhchi.findVolunteer((String) volNameComboBox.getSelectedItem()).member.stream()
						.sorted(Comparator.comparingInt(Member::getTotalDonationTime).reversed())
						.forEach(it -> {
							try {
								writer.write(""
										+ it.name + ","
										+ it.gender + ","
										+ it.age + ","
										+ it.totalDonationTime + "\n"
								);
							} catch (IOException ex) {
								ex.printStackTrace();
							}
						});

				writer.flush();
				writer.close();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}

		});

		top.add(first);
		top.add(second);
		top.add(third);
		frame.add(top, BorderLayout.NORTH);
		frame.add(new JScrollPane(table), BorderLayout.CENTER);
		frame.add(saveBtn, BorderLayout.SOUTH);
	}
	
}




















