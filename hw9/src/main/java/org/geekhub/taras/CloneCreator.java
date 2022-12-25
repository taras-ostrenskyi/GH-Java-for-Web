package org.geekhub.taras;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CloneCreator {
    Object object;

    public CloneCreator(Object object){
        this.object = object;
    }

    public <T> T copy () {
        Class<?> clazz = object.getClass();
        T newObject = null;
        try {
            newObject = (T) object.getClass().newInstance();
        } catch (InstantiationException e) {
            System.err.println("Caught InstantiationException: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.err.println("Caught IllegalAccessException: " + e.getMessage());
        }

        while (clazz != null) {
            copyFields(object, newObject, clazz);
            clazz = clazz.getSuperclass();
        }
        return newObject;
    }

    private <T> T copyFields (T object, T newObject, Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            fields.add(field);
        }
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                field.set(newObject, field.get(object));
            } catch (IllegalAccessException e) {
                System.err.println("Caught IllegalAccessException: " + e.getMessage());
            }
        }
        return newObject;
    }
}
