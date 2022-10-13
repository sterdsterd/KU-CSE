package ywrhee.midtest.ex;

public class YwrheeTalentDonation extends YwrheeVolunteer {
    private String talentName;

    public YwrheeTalentDonation (String volunteerName, int admitNum, String talentName) {
        super(volunteerName, admitNum);
        this.talentName = talentName;
    }

    @Override
    public void join(YwrheeMember member) {
        boolean isDuplicated = false;
        for (int i = 0; i < count; i++) {
            if (participants[i] == member) {
                isDuplicated = true;
                break;
            }
        }
        if (isDuplicated) {
            System.out.println(member.getName() + "님 동일한 봉사활동에는 한번만 신청하실 수 있습니다.");
            return;
        }

        System.out.print(member.getName() + "기부할 재능을 입력해 주세요 : ");
        String talent = sc.next();
        if (talent.equals(talentName)) {
            System.out.println(member.getName() + "님 신청이 완료되었습니다. 감사합니다.");
            member.addParticipateNum();
            participants[count++] = member;
            participantNum++;
        } else {
            System.out.println("해당 봉사활동에서 필요로 하는 재능과 일치하지 않습니다. 다른 기부활동에 동참해 주세요.");
        }
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += "봉사할 재능 : " + talentName + "\n";
        str += "참여자 명단\n";
        str += "----------------------------------------\n";

        if (participantNum == 0) str += "신청자가 없습니다.";
        else
            for (int i = 0; i < count; i++)
                str += participants[i].toString() + "\n";

        return str;
    }
}
