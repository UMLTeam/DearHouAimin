package domain;

public class Online_Evalator {
    private String evalator_id;
    private String course_teacher_name;
    private String course_time;
    private String course_name;
    private String course_property;
    private Double course_grade;
    private String course_level;

    @Override
    public String toString() {
        return "Online_Evalator{" +
                "evalator_id='" + evalator_id + '\'' +
                ", course_teacher_name='" + course_teacher_name + '\'' +
                ", course_time='" + course_time + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_property='" + course_property + '\'' +
                ", course_grade=" + course_grade +
                ", course_level='" + course_level + '\'' +
                '}';
    }

    public String getEvalator_id() {
        return evalator_id;
    }

    public void setEvalator_id(String evalator_id) {
        this.evalator_id = evalator_id;
    }

    public String getCourse_teacher_name() {
        return course_teacher_name;
    }

    public void setCourse_teacher_name(String course_teacher_name) {
        this.course_teacher_name = course_teacher_name;
    }

    public String getCourse_time() {
        return course_time;
    }

    public void setCourse_time(String course_time) {
        this.course_time = course_time;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_property() {
        return course_property;
    }

    public void setCourse_property(String course_property) {
        this.course_property = course_property;
    }

    public Double getCourse_grade() {
        return course_grade;
    }

    public void setCourse_grade(Double course_grade) {
        this.course_grade = course_grade;
    }

    public String getCourse_level() {
        return course_level;
    }

    public void setCourse_level(String course_level) {
        this.course_level = course_level;
    }
}
