package domain;

public class ClassInfo {
    String class_name;
    String specialty;
    String course_name;

    public ClassInfo() {
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "class_name='" + class_name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", course_name='" + course_name + '\'' +
                '}';
    }
}
