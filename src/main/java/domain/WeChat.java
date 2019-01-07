package domain;

import java.util.Date;

public class WeChat {
    private int id;
    private String src;
    private Date publish_time;

    public WeChat() {
        super();
    }

    public WeChat(int id, String src, Date publish_time) {
        this.id = id;
        this.src = src;
        this.publish_time = publish_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Date getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }
}
