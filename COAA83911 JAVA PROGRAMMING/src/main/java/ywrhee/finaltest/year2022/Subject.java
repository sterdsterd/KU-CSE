package ywrhee.finaltest;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Subject {
	String subID; //���� ��ȣ
	String subName; //���� �̸�
	HashMap<String, Student> stdmap = new HashMap<>(); // ������ ���屸�� (�й�, Student)
	
	public Subject(String subID) {
		this(subID, null);		
	}

	public Subject(String subID, String subName) {
		super();
		this.subID = subID;
		this.subName = subName;
	}
	
	public void register(Student std) {
		if (stdmap.containsKey(std.stdID)) {
			System.out.println("�̹� ���� ��ϵǾ� �ֽ��ϴ�.");
		} else {
			stdmap.put(std.stdID, std);
			System.out.println("���� ����� �� �Ǿ����ϴ�.");
		}
	}	

	@Override
	public String toString() {		
		String str = "�����ȣ : "+this.subID+"\n";
		str += "�����̸� : "+this.subName+"\n";
		str += "��� �л� ���\n";
		str += "------------------------\n";
		
		if (stdmap.size() == 0) {
			str += "��ϵ� �л��� �������� �ʽ��ϴ�.\n\n";
		} else {
			str += stdmap.entrySet().stream()
				.map(it->it.getValue())
				.map(it -> it.toString())
				.collect(Collectors.joining());
		}
		
		return str;
	}
	
	public String getSubID() {
		return subID;
	}
	
	public int getStdMapSize() {
		return stdmap.size();
	}
	
}
