package ywrhee.midtest.ex;

public class YwrheeVolunteerManager {

    private String name;
    private int registeredNum;
    private YwrheeVolunteer[] volunteers = new YwrheeVolunteer[3];
    private int count = 0;

    public YwrheeVolunteerManager(String name) {
        this.name = name;
    }

    public void addVolunteer(YwrheeVolunteer volunteer) {
        if (count > 2)
            System.out.println("더이상 추가할 수 없습니다.");
        else {
            for (int i = 0; i < count; i++) {
                if (volunteers[i].volunteerName.equals(volunteer.volunteerName)) {
                    System.out.println("같은 봉사활동은 중복저장할 수 없습니다.");
                    return;
                }
            }
            volunteers[count++] = volunteer;
            System.out.println("등록이 잘 되었습니다.");
        }
    }

    public YwrheeVolunteer findVolunteer(String name) {
        for (int i = 0; i < count; i++) {
            if (volunteers[i].volunteerName.equals(name))
                return volunteers[i];
        }
        return null;
    }

    @Override
    public String toString() {
        String str = "봉사단체명 : " + name + "\n";
        str += "등록된 봉사활동 : " + registeredNum + "\n";
        str += "------ 봉사활동 현황 리스트 ------\n";

        for (int i = 0; i < count; i++) {
            str += volunteers[i].toString() + "\n";
        }
        return str;
    }
}
