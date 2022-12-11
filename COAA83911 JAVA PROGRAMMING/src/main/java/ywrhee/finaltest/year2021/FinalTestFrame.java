package jhchi0409.finaltest;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FinalTestFrame extends JFrame {
	
	VolunteerManager jhchi = new VolunteerManager("좋은세상만들기"); // 본인이름 이니셜 객체
	
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
	
	}
	
}




















