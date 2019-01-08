package domain;


public class educationReformDetail2Bean {
	private String address;	//下载链接
	private String title;	//文件名称
	private String time;	//发布时间
	private String id;//编号
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		 return "{address: \""+address+"\", id: \""+id+"\", time: \""+time+"\", title: \""+title+"\"}";
	}
}
