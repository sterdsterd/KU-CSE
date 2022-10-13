package ywrhee.midtest.ex;

public class YwrheeTestMain {
    public static void main(String[] args) {
        System.out.println("202211342 이율원");

        System.out.println("2) Member 객체 생성 및 출력하기");
        YwrheeMember gdhong = new YwrheeMember("홍길동");
        System.out.println(gdhong);
        YwrheeMember gdKim = new YwrheeMember("김길동");
        YwrheeMember gdLee = new YwrheeMember("이길동");
        YwrheeMember gdChoi = new YwrheeMember("최길동");
        YwrheeMember gdPark = new YwrheeMember("박길동");

        System.out.println("3) Volunteer 추상 클래스 만들기");
        //YwrheeVolunteer volunteer1 = new YwrheeVolunteer("김길동 어린이 돕기", 5);

        System.out.println("4) Donation (물적기부) 객체 만들기");
        YwrheeVolunteer volunteer1 = new YwrheeDonation("김길동 어린이 돕기", 5);
        System.out.println(volunteer1);

        System.out.println("5) TalentDonation (재능기부) 객체 만들기");
        YwrheeVolunteer volunteer2 = new YwrheeTalentDonation("농촌 미용 봉사활동", 2, "미술시간");
        System.out.println(volunteer2);

        System.out.println("6) VolunteerManager 객체 만들기");
        YwrheeVolunteerManager greenjoa = new YwrheeVolunteerManager("그린세상만들기");
        System.out.println(greenjoa);

        System.out.println("7) 봉사활동 추가하기");
        greenjoa.addVolunteer(new YwrheeTalentDonation("농촌 미용 봉사활동", 2, "미용기술"));
        greenjoa.addVolunteer(new YwrheeDonation("김길동 어린이 돕기", 3));
        greenjoa.addVolunteer(new YwrheeDonation("김길동 어린이 돕기", 2));
        greenjoa.addVolunteer(new YwrheeTalentDonation("독거노인 도배 봉사활동", 3, "도배기술"));
        greenjoa.addVolunteer(new YwrheeTalentDonation("섬마을 미용 봉사활동", 1, "미용기술"));

        System.out.println("8-1) 봉사활동 검색 및 참여하기 - 물적봉사의 경우");
        YwrheeVolunteer v1 = greenjoa.findVolunteer("김길동 어린이 돕기");
        v1.join(gdhong);
        v1.join(gdhong);
        v1.join(gdKim);
        v1.join(gdLee);
        v1.join(gdChoi);
        System.out.println();
        System.out.println(v1);

        System.out.println("8-2) 봉사활동 검색 및 참여하기 - 재능봉사의 경우");
        YwrheeVolunteer v2 = greenjoa.findVolunteer("농촌 미용 봉사활동");
        v2.join(gdhong);
        v2.join(gdhong);
        v2.join(gdKim);
        v2.join(gdPark);
        System.out.println();
        System.out.println(v2);

        System.out.println("9) VolunteerManager 출력하기");
        System.out.println(greenjoa);

    }
}
