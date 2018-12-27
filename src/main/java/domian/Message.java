package domian;

public class Message {
    private Integer result;
    private String message;		//显示的提示信息
    private String redirectUrl; //跳转的网址
    private String redirectTime;//跳转的间隔时间，单位秒(已在web.properties初始化 )

    public Integer getResult() {
        return result;
    }
    public void setResult(Integer result) {
        this.result = result;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getRedirectUrl() {
        return redirectUrl;
    }
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
    public String getRedirectTime() {
        return redirectTime;
    }
    public void setRedirectTime(String redirectTime) {
        this.redirectTime = redirectTime;
    }



}