package ywrhee.finaltest.year2021;

public class TestMain {

	public static void main(String[] args) {

		System.out.println("202211342 이율원");
		System.out.println("---------- 봉사활동 생성 --------");
		Volunteer volunteer = new Volunteer("도서관 책 정리", 3, 2);	
		System.out.println(volunteer);
		
		System.out.println("----------- 봉사활동 단체 생성 ----------");		
		VolunteerManager greenjoa = new VolunteerManager("좋은세상만들기");
		System.out.println(greenjoa);
		
		System.out.println("----------- 봉사활동 등록 ----------");
		System.out.println(greenjoa.addVolunteer(new Volunteer("도서관 책 정리", 3, 2)));
		System.out.println(greenjoa.addVolunteer(new Volunteer("마을 환경정리", 2, 3)));
		System.out.println(greenjoa.addVolunteer(new Volunteer("마을 환경정리", 2, 3)));
		System.out.println(greenjoa.addVolunteer(new Volunteer("문화 바로알기", 1, 2)));
		
		System.out.println("---------- 봉사활동 참여 1 ---------");
		Volunteer v1 = greenjoa.findVolunteer("도서관 책 정리");
		Member user1 = greenjoa.getMember("홍길동");
		if(user1!=null) v1.join(user1);
		if(user1!=null) v1.join(user1);
		Member user2 = greenjoa.getMember("아이유");
		if(user2!=null) v1.join(user2);
		System.out.println("---------- 봉사활동 출력 ---------");
		System.out.println(v1);
		
		System.out.println("---------- 봉사활동 참여 2 ---------");
		Volunteer v2 = greenjoa.findVolunteer("마을 환경정리");			
		Member user3 = greenjoa.getMember("김태희");
		if(user3!=null) v2.join(user3);		
		Member user4 = greenjoa.getMember("아이유");
		if(user4!=null) v2.join(user4);				
		Member user5 = greenjoa.getMember("정우성");
		if(user5!=null) v2.join(user5);
		System.out.println("---------- 봉사활동 출력 ---------");
		System.out.println(v2);					
		
		System.out.println("---------봉사활동 단체 정보 출력하기-----------");				
		System.out.println(greenjoa);
		
		FinalTestFrame frame = new FinalTestFrame("200000 홍길동"); // 본인 학번 이름으로 바꾸기
	}
}
