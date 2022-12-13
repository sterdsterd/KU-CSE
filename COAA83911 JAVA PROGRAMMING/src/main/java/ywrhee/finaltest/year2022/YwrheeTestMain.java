package ywrhee.finaltest;

import java.util.List;

public class YwrheeTestMain {

	public static void main(String[] args) {

		System.out.println("1)�й��̸� ����ϱ� (�ܼ�â)");		
		
		System.out.println("202211342 ������");
		
		System.out.println("2)Subject Ŭ������ ������û �� ����ϱ�");
		Subject subject1 = new Subject("ES0406", "���̽�");		
		subject1.register(new Student("20011", "ȫ�浿"));
		subject1.register(new Student("20011", "ȫ�浿"));
		subject1.register(new Student("20022", "��浿"));
		System.out.println(subject1);
		
		System.out.println("3) SubjectManager Ŭ������ ������ �� ����ϱ�");
		SubjectManager csManager = new SubjectManager("��ǻ�Ͱ��а�");
		csManager.addSubject(new Subject("ES0406", "���̽�"));
		csManager.addSubject(new Subject("CA0407", "C���"));
		csManager.addSubject(new Subject("DC0408", "�׷���"));
		csManager.addSubject(new Subject("ES0406", "���̽�"));		
		System.out.println(csManager);
		
		System.out.println("4) �����ȣ�� Subject ã�� �� ���� ����ϱ�");
		Subject sub1 =csManager.findSubject("CA0407");
		if(sub1!=null) {
			sub1.register(new Student("20011", "ȫ�浿"));
			sub1.register(new Student("20011", "ȫ�浿"));
			sub1.register(new Student("20022", "��浿"));
			sub1.register(new Student("20017", "�̱浿"));
			sub1.register(new Student("20006", "�ڱ浿"));
		}else {
			System.out.println("�����ȣ�� Ȯ���� �ּ���.");
		}
		
		Subject sub2 =csManager.findSubject("ES0406");		
		sub2.register(new Student("20011", "ȫ�浿"));		
		sub2.register(new Student("20006", "�ڱ浿"));
		
		Subject sub3 =csManager.findSubject("DC0408");		
		sub3.register(new Student("20011", "ȫ�浿"));
		sub3.register(new Student("20022", "��浿"));
		sub3.register(new Student("20017", "�̱浿"));		
		
		System.out.println(csManager);

		System.out.println("5) �й����� �л��� �����ϰ� �ִ� Subject ����Ʈ ã��");		
		List<Subject> list = csManager.findStudent("20022");
		if(list!=null) {
			for(Subject sub : list) {
				System.out.println(sub);
			}
		}
		
		System.out.println("6) �������� ���� ���� ���� ����ϱ�");
		Subject maxSub = csManager.getSubjectMaxStd();
		System.out.println(maxSub);
				
		// �����̸��̴ϼȷ� �ٲٱ�		
		System.out.println("7) ������ ȭ�� ������ �� ��� ����");
		YwrheeFinalFrame frame = new YwrheeFinalFrame("202211342 ������", csManager);
		
	}

}
