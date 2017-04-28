package cc.happyfish.utility.java.utility;

/**
 * 作者:汪阳
 * 部门:计算机应用开发室
 * 联系:0553-8399022
 * 时间:2016-03-30
 * 说明:为Sql Server 2008准备的辅助类
 */
public class MsSqlUtility {

    /**
     * 获取分页SQL
     *
     * @param sql
     * @param pageIndex
     * @param pageSize
     * @param sortColumn 排序列 默认为 Id,可为空
     * @param sortType   排序类型 默认为降序,可为空
     * @return
     */
    public static String getPageableSql(String sql, long pageIndex, long pageSize, String sortColumn, String sortType) {
        String select = "SELECT";
        String rowIndexTemplate = " ROW_NUMBER() OVER(ORDER BY %%SORT%% %%TYPE%%) as rowIndex, ";
        String sqlTemplate = "SELECT * FROM ( %%SQL%% ) T WHERE rowIndex BETWEEN %%START%% AND %%END%%";
        int position = sql.toUpperCase().indexOf(select);
        sql = sql.substring(0, select.length()) + rowIndexTemplate + sql.substring(select.length(), sql.length() - position);
        sql = sql.replaceAll("%%SORT%%", StringUtility.isEmpty(sortColumn) ? "id" : sortColumn)
                .replaceAll("%%TYPE%%", StringUtility.isEmpty(sortType) ? "DESC" : sortType);
        return sqlTemplate.replaceAll("%%SQL%%", sql)
                .replaceAll("%%START%%", String.valueOf((pageIndex - 1) * pageSize + 1))
                .replaceAll("%%END%%", String.valueOf(pageIndex * pageSize));
    }

    public static String getTotalSql(String sql) {
        String sqlTemplate = "SELECT COUNT(*) FROM ( %%SQL%% ) T";
        return sqlTemplate.replaceAll("%%SQL%%", sql);
    }
}
