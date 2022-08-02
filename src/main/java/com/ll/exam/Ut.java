package com.ll.exam;

import java.lang.reflect.InvocationTargetException;

public class Ut {

    public static class cls {

        public static Object newObj(Class cls, Object defaultValue) {
            try {
                return cls.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                return defaultValue;
            }
        }
    }
}
