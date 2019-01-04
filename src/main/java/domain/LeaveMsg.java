package domain;

/**
 * @authoor linzerong
 * @create 2018-12-24 14:57
 */
public class LeaveMsg {
    private int leaveMsgId;
    private String leaveMsgContent;
    private String publishedTime;
    private int userId;  // 等到有用户表时再作为外键

    public int getLeaveMsgId() {
        return leaveMsgId;
    }

    public void setLeaveMsgId(int leaveMsgId) {
        this.leaveMsgId = leaveMsgId;
    }

    public String getLeaveMsgContent() {
        return leaveMsgContent;
    }

    public void setLeaveMsgContent(String leaveMsgContent) {
        this.leaveMsgContent = leaveMsgContent;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
