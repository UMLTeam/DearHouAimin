package utils;

import java.util.List;

//分页工具类
public class PageQuery<T> {
    /* 每页显示数据条数 */
    private static final int DEFAULT_PAGE_SIZE = 5;
    /* 当前页的第一个数据位置 */
    private Integer currentfirst;
    /* 所有记录数 */
    private int totalRows;
    /* 总页数 */
    private Integer totalPage;
    /* 查询所得数据集 */
    private List<T> items;
    /*查询的当前页*/
    private Integer currentPage;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public final int getTotalRows() {
        return totalRows;
    }
    public final void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
        int totalPage = totalRows % DEFAULT_PAGE_SIZE == 0 ? totalRows / DEFAULT_PAGE_SIZE : totalRows / DEFAULT_PAGE_SIZE+ 1;
        setTotalPage(totalPage);
    }

    public static int getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getCurrentfirst() {
        return currentfirst;
    }

    public void setCurrentfirst(Integer currentfirst) {
        this.currentfirst = currentfirst;
    }

    public final Integer getTotalPage() {
        return totalPage == null || totalPage == 0 ? 1 : totalPage;
    }

    public final void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }


    @Override
    public String toString() {
        return "PageQuery{" +
                "currentfirst=" + currentfirst +
                ", totalRows=" + totalRows +
                ", totalPage=" + totalPage +
                ", items=" + items +
                ", currentPage=" + currentPage +
                '}';
    }
}
