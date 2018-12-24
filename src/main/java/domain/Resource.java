package domain;

import java.sql.Timestamp;

public class Resource {

    private int id;
    private String resName;
    private Timestamp resTime;
    private String resPath;
    private String resType;
    private String resTag;
    private String isCheck;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public Timestamp getResTime() {
        return resTime;
    }

    public void setResTime(Timestamp resTime) {
        this.resTime = resTime;
    }

    public String getResPath() {
        return resPath;
    }

    public void setResPath(String resPath) {
        this.resPath = resPath;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public String getResTag() {
        return resTag;
    }

    public void setResTag(String resTag) {
        this.resTag = resTag;
    }

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck;
    }
}
