package domain;

import java.util.Date;

public class Calendar {
    private Integer cid;
    private String cname;
    private String pdfUrl;
    private Date createtime;
    private Integer used;

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", pdfUrl='" + pdfUrl + '\'' +
                ", createtime=" + createtime +
                ", used=" + used +
                '}';
    }
}
