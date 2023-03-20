package ywrhee.finaltest.year2022;

public class Student {
	String stdID; //학번
	String stdName; //이름

	public Student(String stdID, String stdName) {
		super();
		this.stdID = stdID;
		this.stdName = stdName;
	}

	@Override
	public String toString() {
		String str = "학번 : "+this.stdID+" / ";
		str += "이름 : "+this.stdName+"\n";
		str += "------------------------\n";
		return str;
	}

	public String getStdID() {
		return stdID;
	}

}
