package ua.mibal.adapter.out.util;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class CollectionUtils {

    public static <T> List<T> union(List<? extends T> list1, List<? extends T> list2) {
        List<T> union = new ArrayList<>(list1);
        union.addAll(list2);
        return unmodifiableList(union);
    }
}
