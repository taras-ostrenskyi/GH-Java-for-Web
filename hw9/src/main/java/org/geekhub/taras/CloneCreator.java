package org.geekhub.taras;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CloneCreator {

    Object object;

    public CloneCreator(Object object){
        this.object = object;
    }

    public <T> T copy () throws IllegalAccessException, InstantiationException {
        Class<?> clazz = object.getClass();
        T newObject = (T) object.getClass().newInstance();

        while (clazz != null) {
            copyFields(object, newObject, clazz);
            clazz = clazz.getSuperclass();
        }

        return newObject;
    }

    private <T> T copyFields (T object, T newObject, Class<?> clazz) throws IllegalAccessException {
        List<Field> fields = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            fields.add(field);
        }
        for (Field field : fields) {
            field.setAccessible(true);
            field.set(newObject, field.get(object));
        }
        return newObject;
    }

}
