package ywrhee.finaltest.year2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Volunteer {
	String volName; // 봉사활동 이름
	int donationTime; // 봉사활동 인정 시간
	final int Number; // 모집인원	
	List<Member> member; // 자원봉사 참여자		
		
	public Volunteer(String volName, int donationTime, int number) {
		this.volName = volName;
		this.donationTime = donationTime;
		Number = number;
		member = new ArrayList<>(Number);
	}	
	
	// 봉사활동 참여하기
	public String join(Member m) {
		for(Member p : this.member) {
			if(p==null) break;
			if(p.name.equals(m.name)){		
				System.out.println(m.name+"님 "+this.volName+" 봉사활동에 이미 참여하셨습니다.");
				return m.name+"님 "+this.volName+" 봉사활동에 이미 참여하셨습니다.";
			}
		}
		if(this.member.size() < this.Number) {	
				m.addDonation(donationTime);
				member.add(m);
				System.out.println(m.name+"님 "+this.volName+" 봉사활동에 참여하셨습니다.");
				return m.name+"님 "+this.volName+" 봉사활동에 참여하셨습니다.";
		}else {
			System.out.println(m.name+"님 "+this.volName+" 봉사활동은 마감되었습니다.");
			return m.name+"님 "+this.volName+" 봉사활동은 마감되었습니다.";
		}
	}
	
	//구현할 기능 : 봉사활동 시간이 많은 순서로 정렬해서 참여자 정보 문자열에 추가하기 ==> 반환값 : 봉사활동 정보를 담고 있는 문자열
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "봉사활동명 : "+this.volName+"\n";
		str += "봉사 시간 : " + this.donationTime+"시간\n";
		str += "참여가능 인원 : " + this.Number+"명\n";
		str += "현재 참여인원 : " + this.member.size()+"명\n";				
		str += "참여자 명단 (봉사활동 시간이 많은 순서로 출력)\n";
		str += "-------------------------------------\n";		
		if(this.member.size()==0) {
			str += "신청자가 없습니다.\n";
			return str;
		}
		
		//구현해야 하는 부분 : 봉사활동 시간이 많은 순서로 정렬해서 문자열로 반환하기
		List<Member> sortedList = member.stream().sorted(Comparator.comparingInt(Member::getTotalDonationTime).reversed()).toList();
		for (Member member : sortedList) {
			str += member + "\n";
		}

		return str;
	}
		
}
