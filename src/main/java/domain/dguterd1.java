package domain;

import java.sql.Date;

public class dguterd1 {
    private int dguterd1_id;
    private String dguterd1_title;
    private String dguterd1_type;
    private Date dguterd1_date;
    private String dguterd1_origin;
    private String dguterd1_content;
    private int dguterd1_state;

    public int getDguterd1_state() {
        return dguterd1_state;
    }

    public void setDguterd1_state(int dguterd1_state) {
        this.dguterd1_state = dguterd1_state;
    }

    public int getDguterd1_id() {
        return dguterd1_id;
    }

    public void setDguterd1_id(int dguterd1_id) {
        this.dguterd1_id = dguterd1_id;
    }

    public String getDguterd1_title() {
        return dguterd1_title;
    }

    public void setDguterd1_title(String dguterd1_title) {
        this.dguterd1_title = dguterd1_title;
    }

    public String getDguterd1_type() {
        return dguterd1_type;
    }

    public void setDguterd1_type(String dguterd1_type) {
        this.dguterd1_type = dguterd1_type;
    }

    public Date getDguterd1_date() {
        return dguterd1_date;
    }

    public void setDguterd1_date(Date dguterd1_date) {
        this.dguterd1_date = dguterd1_date;
    }

    public String getDguterd1_origin() {
        return dguterd1_origin;
    }

    public void setDguterd1_origin(String dguterd1_origin) {
        this.dguterd1_origin = dguterd1_origin;
    }

    public String getDguterd1_content() {
        return dguterd1_content;
    }

    public void setDguterd1_content(String dguterd1_content) {
        this.dguterd1_content = dguterd1_content;
    }

    @Override
    public String toString() {
        return "dguterd1{" +
                "dguterd1_id=" + dguterd1_id +
                ", dguterd1_title='" + dguterd1_title + '\'' +
                ", dguterd1_type='" + dguterd1_type + '\'' +
                ", dguterd1_date=" + dguterd1_date +
                ", dguterd1_origin='" + dguterd1_origin + '\'' +
                ", dguterd1_content='" + dguterd1_content + '\'' +
                '}';
    }
}
