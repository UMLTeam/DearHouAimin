package domain;

public class TeachingMeasure {
	private int measureId;
    private String measureName;
    private String measureURL;
    private String enable;
    private String time;
    
    public int getMeasureId() {
        return measureId;
    }

    public void setMeasureId(int measureId) {
        this.measureId = measureId;
    }

    public String getMeasureName() {
        return measureName;
    }

    public void setMeasureName(String measureName) {
        this.measureName = measureName;
    }

    public String getMeasureURL() {
        return measureURL;
    }

    public void setMeasureURL(String measureURL) {
        this.measureURL = measureURL;
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
