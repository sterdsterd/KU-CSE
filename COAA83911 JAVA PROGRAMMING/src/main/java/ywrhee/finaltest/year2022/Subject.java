package ywrhee.finaltest.year2022;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Subject {
	String subID; //과목 번호
	String subName; //과목 이름
	HashMap<String, Student> stdmap = new HashMap<>(); // 수강생 저장구조 (학번, Student)

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
			System.out.println("이미 수강 등록되어 있습니다.");
		} else {
			stdmap.put(std.stdID, std);
			System.out.println("수강 등록이 잘 되었습니다.");
		}
	}

	@Override
	public String toString() {
		String str = "과목번호 : "+this.subID+"\n";
		str += "과목이름 : "+this.subName+"\n";
		str += "등록 학생 명단\n";
		str += "------------------------\n";

		if (stdmap.size() == 0) {
			str += "등록된 학생이 존재하지 않습니다.\n\n";
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
