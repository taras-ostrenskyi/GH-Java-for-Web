package org.geekhub.taras;

import java.lang.reflect.Field;

public class Printer {
    Class<?> clazz;
    Field[] fields;
    Object object;

    public Printer(Class<?> clazz, Field[] fields, Object object){
        this.clazz = clazz;
        this.fields = fields;
        this.object = object;
    }

    public void printView() {
        System.out.println();
        System.out.println(" " + clazz.getSimpleName());
        for (Field field : fields) {
            System.out.print(field.getName() + "                ");
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
