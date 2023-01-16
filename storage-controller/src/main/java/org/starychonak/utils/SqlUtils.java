package org.starychonak.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SqlUtils {

    public static boolean appendStringCondition(StringBuilder sb, String field, String value, boolean first) {
        if (first) {
            first = true;
            sb.append(" where lower(" + field)
                    .append(") = lower('" + value + "')\n");
        } else {
            sb.append(" and lower(" + field)
                    .append(") = lower('" + value + "')\n");
        }
        return first;
    }

    public static boolean appendLikeCondition(StringBuilder sb, String field, String value, boolean first) {
        if (first) {
            first = true;
            sb.append(" where lower(" + field)
                    .append(") like lower('%" + value + "%')\n");
        } else {
            sb.append(" and lower(" + field)
                    .append(") like lower('%" + value + "%')\n");
        }
        return first;
    }

    public static boolean appendCondition(StringBuilder sb, String field, Object value, boolean first) {
        if (first) {
            first = true;
            sb.append(" where " + field)
                    .append(" = " + value + "\n");
        } else {
            sb.append(" and " + field)
                    .append(" = " + value + "\n");
        }
        return first;
    }
}
