package domain;

public class Student_Score {
    private String StudentNo;
    private String StudentName;
    private String major;
    private String ClassName;
    private String course;
    private double score;



    @Override
    public String toString() {
        return "Student_Score{" +
                "StudentNo='" + StudentNo + '\'' +
                ", StudentName='" + StudentName + '\'' +
                ", major='" + major + '\'' +
                ", ClassName='" + ClassName + '\'' +
                ", course='" + course + '\'' +
                ", score=" + score +
                '}';
    }

    public String getStudentNo() {
        return StudentNo;
    }

    public void setStudentNo(String studentNo) {
        StudentNo = studentNo;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
