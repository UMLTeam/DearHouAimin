package domain;

public class Expert_Evaluation {
    private String evaluation_id;
    private String title;
    private String type;
    private String content;
    private String time;

    public String getEvaluation_id() {
        return evaluation_id;
    }

    public void setEvaluation_id(String evaluation_id) {
        this.evaluation_id = evaluation_id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
