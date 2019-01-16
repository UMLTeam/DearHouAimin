package domain;

/*
    学期实体类
 */
public class Term {
    private int value;
    private String name;

    public Term(int value) {
        this.setValue(value);
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setValue(int value) {
        this.value = value;
        this.name = "" + value/100000;
        this.name = this.name+ "-" + value%100000/10 + "年度 第";
        if(value%10 == 1) this.name += "一学期";
        else this.name += "二学期";
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Term{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
