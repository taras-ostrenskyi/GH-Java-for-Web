package org.geekhub.taras;

import java.lang.reflect.Field;

public class BeanComparator {
    private final Object object;
    private final Object objectToCompare;

    public BeanComparator(Object object, Object objectToCompare){
        this.object = object;
        this.objectToCompare = objectToCompare;
    }

    public void compareObjectFields() {
        Class<?> clazz = object.getClass();
        Class<?> clazzToCompare = objectToCompare.getClass();
        Field[] objectFields = clazz.getDeclaredFields();
        Field[] objectToCompareFields = clazzToCompare.getDeclaredFields();

        System.out.println();
        if (!object.getClass().equals(objectToCompare.getClass()) || !(objectFields.length == objectToCompareFields.length)) {
            System.out.println("Objects from different classes or the number of object fields is different");
        }
        else {
            System.out.println(" Comparison of objects of class " + object.getClass().getSimpleName());
            System.out.println("Field" + "  |  " + object.getClass().getSimpleName() + "A" + "  |  " + objectToCompare.getClass().getSimpleName() + "B" + "  |  " + "Match" + "  |  ");
            for (int i = 0; i < objectFields.length; i++){
                System.out.print(objectFields[i].getName() + "  |  ");

                objectFields[i].setAccessible(true);
                Object valueObject = null;
                try {
                    valueObject = objectFields[i].get(object);
                } catch (IllegalAccessException e) {
                    System.err.println("Caught IllegalAccessException: " + e.getMessage());
                }
                System.out.print(valueObject + "  |  ");

                objectToCompareFields[i].setAccessible(true);
                Object valueObjectToCompare = null;
                try {
                    valueObjectToCompare = objectToCompareFields[i].get(objectToCompare);
                } catch (IllegalAccessException e) {
                    System.err.println("Caught IllegalAccessException: " + e.getMessage());
                }
                System.out.print(valueObjectToCompare + "  |  ");

                try {
                    System.out.println(objectFields[i].get(object).equals(objectToCompareFields[i].get(objectToCompare)));
                } catch (IllegalAccessException e) {
                    System.err.println("Caught IllegalAccessException: " + e.getMessage());
                }
            }
        }
    }
}
