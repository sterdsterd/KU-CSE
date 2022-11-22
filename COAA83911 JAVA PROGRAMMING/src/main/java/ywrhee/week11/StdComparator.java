package ywrhee.week11;

import java.util.Comparator;

public class StdComparator implements Comparator<Student> {

    enum STUDENT_COMPARE { SCORE_ASC, SCORE_DESC, NAME, SID }

    STUDENT_COMPARE flag = STUDENT_COMPARE.SID;

    @Override
    public int compare(Student o1, Student o2) {
        switch (flag) {
            case SCORE_ASC:
                return -(o1.score - o2.score);
            case SCORE_DESC:
                return o1.score - o2.score;
            case NAME:
                return o1.sname.compareTo(o2.sname);
            case SID:
            default:
                return o1.sid.compareTo(o2.sid);
        }
    }

    public StdComparator(STUDENT_COMPARE flag) {
        this.flag = flag;
    }
}
