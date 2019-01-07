package domain;

/**
 * @authoor yangyuze
 * @create 2018-12-24 20:24
 */
public class TeachingPoints {
    private int pointId;
    private String theoryInfo;
    private String experimentInfo;
    private String enable;
    private String time;

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    public void setTheoryInfo(String theoryInfo) {
        this.theoryInfo = theoryInfo;
    }

    public void setExperimentInfo(String experimentInfo) {
        this.experimentInfo = experimentInfo;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPointId() {
        return pointId;
    }

    public String getTheoryInfo() {
        return theoryInfo;
    }

    public String getExperimentInfo() {
        return experimentInfo;
    }

    public String getTime() {
        return time;
    }

}
