package ywrhee.finaltest;

public class Student {
	String stdID; //�й�
	String stdName; //�̸�	
	
	public Student(String stdID, String stdName) {
		super();
		this.stdID = stdID;
		this.stdName = stdName;
	}

	@Override
	public String toString() {
		String str = "�й� : "+this.stdID+" / ";
		str += "�̸� : "+this.stdName+"\n";		
		str += "------------------------\n";
		return str;
	}
	
	public String getStdID() {
		return stdID;
	}
	
}
