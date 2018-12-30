package tools;

import javax.servlet.http.HttpServletRequest;

public class Tool {

    /*从客户端获取表名，页码*/
    public static void getPageInformation(String tableName, HttpServletRequest request, PageInformation pageInformation){
        pageInformation.setTableName(tableName);

        /*当前页码*/
        String info = request.getParameter("page");
        if (info==null)
            pageInformation.setPage(null);
        else
            pageInformation.setPage(Integer.parseInt(info));

        /*每页最大记录数*/
        info = request.getParameter("pageSize");
        if (info==null)
            pageInformation.setPageSize(null);
        else
            pageInformation.setPageSize(Integer.parseInt(info));

        /*总页数*/
        info=request.getParameter("totalPageCount");
        if(info==null)
            pageInformation.setTotalPageCount(null);
        else
            pageInformation.setTotalPageCount(Integer.parseInt(info));

        /*总记录数*/
        info=request.getParameter("allRecordCount");
        if(info==null)
            pageInformation.setAllRecordCount(null);
        else
            pageInformation.setAllRecordCount(Integer.parseInt(info));

        //排序字段
        String orderField = request.getParameter("orderField");
        if(orderField!=null) pageInformation.setOrderField(orderField);
        else pageInformation.setOrderField("");

        //升序还是降序
        String order = request.getParameter("order");
        if(order!=null) pageInformation.setOrder(order);
        else  pageInformation.setOrder("id");

        //主键id，逗号隔开，如：3,5,9  用于删除操作
        pageInformation.setIds(request.getParameter("ids"));


        pageInformation.setSearchSql(request.getParameter("searchSql"));
    }

    /*返回sql语句*/
    public static String getSql(PageInformation pageInformation, String type){
        String sql="";

        //删除
        if(pageInformation.getIds()!=null &&  !pageInformation.getIds().isEmpty()){
            sql+="delete * from"+pageInformation.getTableName().toLowerCase()
                    +" where " + pageInformation.getTableName().toLowerCase()+"Id in ("
                    +" "+pageInformation.getIds()+") ";
        }
        //查询：只查符合条件的记录数目
        else if("count".equals(type)){
            sql+=""+" select count(*) as count1 from " + pageInformation.getTableName().toLowerCase()+" ";
            //查询条件
            if(pageInformation.getSearchSql()!=null && !pageInformation.getSearchSql().isEmpty()){
                sql+=" where "+pageInformation.getSearchSql()+" ";
            }
        }
        //一般查询
        else if("select".equals(type)){
            sql+=""+" select * from " + pageInformation.getTableName().toLowerCase()+" ";
            //查询条件
            if(pageInformation.getSearchSql()!=null && !pageInformation.getSearchSql().isEmpty()){
                sql+=" where "+pageInformation.getSearchSql()+" ";
            }
            //排序,默认按主键的降序排列
            if(pageInformation.getOrderField()==null || pageInformation.getOrderField().isEmpty()){
                sql+=" ORDER BY id "+" asc ";
            }else{
                sql+=" ORDER BY "+pageInformation.getOrderField()+" "+pageInformation.getOrder()+" ";
            }
            //分页
            if(pageInformation.getPage()!=null && pageInformation.getPage()>-100){
                Integer start= (pageInformation.getPage()-1) *
                        pageInformation.getPageSize();

                sql+=" limit "+start.toString()+","+pageInformation.getPageSize();
            }
        }

        return sql;
    }

    ////更新pageInformation的总记录等
    public static void setPageInformation(Integer allRecordCount, PageInformation pageInformation){
        //赋值总记录数
        pageInformation.setAllRecordCount(allRecordCount);

        //计算总页数
        Integer totalPageCount=(int) Math.ceil(1.0* allRecordCount / pageInformation.getPageSize());//总页数

        //赋值总页数
        pageInformation.setTotalPageCount(totalPageCount);

        //防止页码越界  删除时有可能页码越界
        if(pageInformation.getPage()<1)
            pageInformation.setPage(1);
        if(pageInformation.getPage()>totalPageCount)
            pageInformation.setPage(totalPageCount);
    }
}
