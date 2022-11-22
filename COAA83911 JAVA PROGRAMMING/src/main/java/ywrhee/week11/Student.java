package ywrhee.week11;

import org.jetbrains.annotations.NotNull;

public class Student implements Comparable<Student> {
    String sname;
    String sid;
    int score;

    public Student(String sname, String sid, int score) {
        this.sname = sname;
        this.sid = sid;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sname='" + sname + '\'' +
                ", sid='" + sid + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
//        return -(this.score - o.score);
        return this.sid.compareTo(o.sid);
    }
}
