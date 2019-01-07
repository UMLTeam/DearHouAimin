package domain;

public class TeachingGeneral {
    private int generalId;
    private String generalName;
    private String generalURL;
    private String enable;
    private String time;

    public int getGeneralId() {
        return generalId;
    }

    public void setGeneralId(int generalId) {
        this.generalId = generalId;
    }

    public void setGeneralURL(String generalURL) {
        this.generalURL = generalURL;
    }
    public String getGeneralURL() {
        return generalURL;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getEnable() {
        return enable;
    }

    public String getGeneralName() {
        return generalName;
    }

    public void setGeneralName(String generalName) {
        this.generalName = generalName;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

}
