package ywrhee.finaltest.year2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class SubjectManager {
	String deptName; // 학과명
	List<Subject> sublist = new ArrayList<>(); // 과목 저장하기 위한 리스트

	SubjectManager(String deptName){
		this.deptName = deptName;
	}

	void addSubject(Subject sub) {
		if (sublist.stream().anyMatch(it->it.subID.equals(sub.subID))) {
			System.out.println("이미 등록된 과목입니다.");
		} else {
			sublist.add(sub);
			System.out.println("과목 등록이 완료 되었습니다.");
		}
	}

	Subject findSubject(String subID) {
		ArrayList<Subject> nArrayList = new ArrayList<>(sublist);

		nArrayList.sort(Comparator.comparing(Subject::getSubID));
		int k = Collections.binarySearch(nArrayList, new Subject(subID), Comparator.comparing(Subject::getSubID));

		return nArrayList.get(k);

	}

	List<Subject> findStudent(String stdID) {
		ArrayList<Subject> resultArrayList = new ArrayList<>();
		for (Subject subject : sublist) {
			if (subject.stdmap.entrySet().stream().anyMatch(it->it.getValue().stdID.equals(stdID))) {
				resultArrayList.add(subject);
			}
		}
		if (resultArrayList.size() == 0) return null;
		return resultArrayList;
	}

	@Override
	public String toString() {

		String str = "학과명 : "+this.deptName+"\n";
		str += "개설 과목 현황\n";
		str += "=========================\n";

		str += sublist.stream().map(it -> it.toString()).collect(Collectors.joining());

		return str;
	}

	public Subject getSubjectMaxStd() {
		return (Subject) sublist.stream().sorted(Comparator.comparingInt(Subject::getStdMapSize).reversed()).toArray()[0];
	}

}
