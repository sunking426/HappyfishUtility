package cc.happyfish.utility.java.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 作者:汪阳
 * 部门:计算机应用开发室
 * 联系:0553-8399022
 * 时间:2016-03-30
 * 说明:无
 */
public class CollectionUtility {
    /**
     * Iterator转List
     *
     * @param iter
     * @param <T>
     * @return
     */
    public static <T> List<T> copyIterator(Iterator<T> iter) {
        List<T> copy = new ArrayList<T>();
        while (iter.hasNext())
            copy.add(iter.next());
        return copy;
    }
}
