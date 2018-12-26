package domian;

import java.sql.Timestamp;

public class Resource {

    private int id;
    private String resName;
    private Timestamp resTime;
    private String resPath;
    private String resType; //栏目类型, 例如习题库,
//    private String resTag;  //后缀名,如ppt
    private String isCheck;

    public Resource(){}

    public Resource(int id, String resName, Timestamp resTime, String resPath, String resType, String isCheck) {
        this.id = id;
        this.resName = resName;
        this.resTime = resTime;
        this.resPath = resPath;
        this.resType = resType;
        this.isCheck = isCheck;
    }

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

//    public String getResTag() {
//        return resTag;
//    }

//    public void setResTag(String resTag) {
//        this.resTag = resTag;
//    }

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", resName='" + resName + '\'' +
                ", resTime=" + resTime +
                ", resPath='" + resPath + '\'' +
                ", resType='" + resType + '\'' +
//                ", resTag='" + resTag + '\'' +
                ", isCheck='" + isCheck + '\'' +
                '}';
    }
}
