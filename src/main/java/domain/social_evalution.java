package domain;

public class social_evalution {

    private int evalutionId;
    private String evalutionTitle;
    private String content;
    private String evalutionTime;
    private int status;

    public int getEvalutionId() {
        return evalutionId;
    }

    public void setEvalutionId(int evalutionId) {
        this.evalutionId = evalutionId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEvalutionTitle() {
        return evalutionTitle;
    }

    public void setEvalutionTitle(String evalutionTitle) {
        this.evalutionTitle = evalutionTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEvalutionTime() {
        return evalutionTime;
    }

    public void setEvalutionTime(String evalutionTime) {
        this.evalutionTime = evalutionTime;
    }
}
