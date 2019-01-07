package domain;

/**
 * @authoor linzerong
 * @create 2018-12-23 12:14
 */
public class TeachingPlan {
    private int planId;
    private String planName;
    private String planURL;
    private String enable;
    private String time;

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanURL() {
        return planURL;
    }

    public void setPlanURL(String planURL) {
        this.planURL = planURL;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
