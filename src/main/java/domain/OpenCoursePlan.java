package domain;

/*
    开课计划实体类
 */
public class OpenCoursePlan {
    private int id;
    private int term;
    private String filePath;
    private String termName;

    public int getId() {
        return id;
    }

    public int getTerm() {
        return term;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getTermName() {
        String termName = "" + term/100000;
        termName = termName + "-" + term%100000/10 + "年度 第";
        if(term%10 == 1) termName += "一学期";
        else termName += "二学期";
        return termName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "id=" + id + " term=" + term + " filePath=" + filePath;
    }
}
