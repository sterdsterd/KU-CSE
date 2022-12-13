package ywrhee.finaltest.year2021;

import java.util.*;

public class VolunteerManager {
	String vName; //단체 이름		
	Set<Volunteer> volunteer=new HashSet<>() ; //봉사활동 저장 구조
	Map<String, Member> member = new HashMap<>(); //회원정보 저장 구조
	
	public VolunteerManager(String vName) {
		super();
		this.vName = vName;	
		System.out.println(addMember("홍길동", 1, 15)); 
		System.out.println(addMember("송중기", 1, 19));
		System.out.println(addMember("송중기", 1, 19));
		System.out.println(addMember("정우성", 1, 17));
		System.out.println(addMember("김태희", 2, 25));
		System.out.println(addMember("아이유", 2, 16));
	}
	
	// 구현할 기능 : 회원정보 저장하기 ==> 반환값 : "회원가입 완료" 또는 "중복가입 불가"
	public String addMember(String name, int gender, int age) {
		if (member.containsKey(name))
			return "중복 가입 불가";

		member.put(name, new Member(name, gender, age));
		return "회원가입 완료";
	}
	
	
	public Member getMember(String name) {		
		return member.get(name);
	}
	
	// 구현할 기능 : 봉사활동 저장하기 ==> 반환값 : "등록완료" 또는 "중복 등록 불가"
	public String addVolunteer(Volunteer v) {
		for (Volunteer vol : volunteer) {
			if (vol.volName.equals(v.volName))
				return "중복 등록 불가";
		}

		volunteer.add(v);
		return "등록 완료";
	}
	
	// 봉사활동 검색해서 반환하기
	public Volunteer findVolunteer(String vName) {
		for(Volunteer vlr : volunteer) {
			if(vlr==null) break;
			if(vName.equals(vlr.volName)) {				
				return vlr;
			}
		}
		System.out.println("해당하는 봉사활동을 찾을 수 없습니다.");
		return null;
	}		
	
	@Override
	public String toString() {
		
		String str = "봉사단체명 : " + this.vName +"\n";
		str += "등록된 봉사활동 : " + this.volunteer.size() +"\n";
		str += "------ 봉사활동 현황 리스트 -------\n";
		if(this.volunteer.size() ==0) {
			str+="등록된 봉사활동이 없습니다.\n";
			return str;
		}			
			
		for(Volunteer vlr : volunteer) {			
			if(vlr!=null) {				
				str += vlr.toString()+"\n";
			}else
				break;
		}
		
		return str;
	}
	
}
