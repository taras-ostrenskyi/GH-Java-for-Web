package org.geekhub.taras;

import java.lang.reflect.Field;

public class BeanRepresenter {
    Object object;

    public BeanRepresenter(Object object){
        this.object = object;
    }

    public void printView() {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        System.out.println();
        System.out.println(" " + clazz.getSimpleName());
        for (Field field : fields) {
            System.out.print(field.getName() + "  |  ");
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(object);
            } catch (IllegalAccessException e) {
                System.err.println("Caught RuntimeException: " + e.getMessage());
            }
            System.out.println(value);
        }
    }
}
