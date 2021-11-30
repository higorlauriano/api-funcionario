package com.higor.funcionario.utils;

import java.util.Collection;

public class ListUtil {

    public static boolean isNotNullOrEmpty(Collection collection) {
        return collection != null && !collection.isEmpty();
    }

    public synchronized static <T> boolean addIfNotNull(Collection<T> collection, T value) {
        if (value != null) {
            return collection.add(value);
        }

        return false;
    }

}
