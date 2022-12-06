package com.metalbird.anyscopeweb.util;

import javax.el.MethodNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;

public class AnyUtils {
    /**
     * Comparator 생성. list의 sort 에 사용.
     * ex# list.sort(sortComparator("getRank", SortDirection.DESC, Target.class).thenComparing(sortComparator("getName", SortDirection.ASC, Target.class))
     * @param methodName
     * @param direction
     * @param clazz
     * @return
     * @param <T>
     */
    public static <T extends Object> Comparator sortComparator(String methodName, SortDirection direction, Class<T> clazz) {
        Method declareMethod = null;
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().equals(methodName)) {
                declareMethod = method;
                break;
            }
        }
        if (declareMethod == null) {
            throw new MethodNotFoundException("sortComparator has error. cause method not found.");
        }
        Method finalDeclareMethod = declareMethod;
        return (Comparator<T>) (o1, o2) -> {
            try {
                Object o1Val = finalDeclareMethod.invoke(o1);
                Object o2Val = finalDeclareMethod.invoke(o2);
                if (o1Val instanceof String) {
                    String o1Str = (String) o1Val;
                    String o2Str = (String) o2Val;
                    return SortDirection.ASC.equals(direction) ? o1Str.compareTo(o2Str) : o2Str.compareTo(o1Str);
                } else if (o1Val instanceof Integer) {
                    Integer o1Num = (Integer) o1Val;
                    Integer o2Num = (Integer) o2Val;
                    return SortDirection.ASC.equals(direction) ? o1Num.compareTo(o2Num) : o2Num.compareTo(o1Num);
                } else if (o1Val instanceof Long) {
                    Long o1Num = (Long) o1Val;
                    Long o2Num = (Long) o2Val;
                    return SortDirection.ASC.equals(direction) ? o1Num.compareTo(o2Num) : o2Num.compareTo(o1Num);
                } else if (o1Val instanceof BigDecimal) {
                    BigDecimal o1Num = (BigDecimal) o1Val;
                    BigDecimal o2Num = (BigDecimal) o2Val;
                    return SortDirection.ASC.equals(direction) ? o1Num.compareTo(o2Num) : o2Num.compareTo(o1Num);
                } else if (o1Val instanceof LocalDateTime) {
                    LocalDateTime o1Date = (LocalDateTime) o1Val;
                    LocalDateTime o2Date = (LocalDateTime) o2Val;
                    return SortDirection.ASC.equals(direction) ? o1Date.compareTo(o2Date) : o2Date.compareTo(o1Date);
                } else {
                    throw new RuntimeException("unmatched sort case. ");
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public enum SortDirection {
        ASC, DESC
    }
}
