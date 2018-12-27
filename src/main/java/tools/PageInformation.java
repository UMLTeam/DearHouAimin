package tools;

public class PageInformation {
	private String type;			//操作类型
	private String tableName;		//表名
	private Integer page;			//第几页  页码
	private Integer pageSize;		//每页最大记录数
	private Integer totalPageCount;	//总页数
	private Integer allRecordCount;	//总记录数
	private String orderField;		//排序字段
	private String order;			//升序还是降序
	private String ids;				//主键id，逗号隔开，如：3,5,9  用于删除操作
	private String searchSql;		//查询条件
	private Integer result;			//更新操作是否成功

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public Integer getAllRecordCount() {
		return allRecordCount;
	}

	public void setAllRecordCount(Integer allRecordCount) {
		this.allRecordCount = allRecordCount;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getSearchSql() {
		return searchSql;
	}

	public void setSearchSql(String searchSql) {
		this.searchSql = searchSql;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}
}
