package ywrhee.midtest.year2021;

import java.util.InputMismatchException;

public class YwrheeDonation extends YwrheeVolunteer {
    private int donationAmount;

    public YwrheeDonation(String volunteerName, int admitNum) {
        super(volunteerName, admitNum);
    }

    @Override
    public void join(YwrheeMember member) {
        int donationAmount;
        for (;;) {
            System.out.print(member.getName() + "님 기부할 금액을 입력해 주세요: ");
            try {
                donationAmount = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("다시 입력해 주세요.");
                sc.nextLine();
                continue;
            }

            if (donationAmount < 100) {
                System.out.println(member.getName() + "님, 최소 기부금은 100원 이상이 되어야 합니다.");
                break;
            }

            member.addDonationAmount(donationAmount);
            member.addParticipateNum();
            this.donationAmount += donationAmount;

            boolean isDuplicated = false;
            for (int i = 0; i < count; i++) {
                if (participants[i] == member) {
                    isDuplicated = true;
                    break;
                }
            }
            if (!isDuplicated) {
                participants[count++] = member;
                participantNum++;
            }

            System.out.println(member.getName() + "님 기부가 완료되었습니다. 감사합니다.");
            break;
        }
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += "기부금 총액 : " + donationAmount + "원\n";
        str += "참여자 명단 (기부금액이 큰 순서)\n";
        str += "----------------------------------------\n";

        if (participantNum == 0) str += "신청자가 없습니다.";
        else
            for (int i = 0; i < count; i++)
                str += participants[i].toString() + "\n";

        return str;
    }
}
