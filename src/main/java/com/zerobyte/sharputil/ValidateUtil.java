package com.zerobyte.sharputil;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class ValidateUtil {
    public static <T> boolean noNullElements(T[] array)
    {
        Objects.requireNonNull(array);

        for (T t : array) {
            if (t == null)
                return false;
        }

        return true;
    }

    public static <T> T[] noNullElementsWithException(T[] array)
    {
        Objects.requireNonNull(array);

        for (int i =0;i<array.length;i++){
            if(array[i] == null)
                throw new IllegalArgumentException("The array contains null elements at index: "+i);
        }

        return array;
    }

    public static <T> boolean noNullElements(Iterable<T> iterable)
    {
        Objects.requireNonNull(iterable);

        for (T t : iterable){
            if(t == null)
                return false;
        }

        return true;
    }

    public static <T> Iterable<T> noNullElementsWithException(Iterable<T> iterable)
    {
        Objects.requireNonNull(iterable);

        int index = 0;

        for (T t : iterable){
            if(t == null)
                throw new IllegalArgumentException("The validated collection contains null element at index: "+index);
            index++;
        }

        return iterable;
    }

    public static <T> boolean noNullElements(Iterator<T> iterator)
    {
        Objects.requireNonNull(iterator);

        while (iterator.hasNext()){
            T t = iterator.next();
            if(t == null)
                return false;
        }

        return true;
    }

    public static <T> Iterator<T> noNullElementsWithException(Iterator<T> iterator)
    {
        Objects.requireNonNull(iterator);

        int index = 0;

        while (iterator.hasNext()){
            T t = iterator.next();
            if(t == null)
                throw new IllegalArgumentException("The validated collection contains null element at index: "+index);
            index++;
        }

        return iterator;
    }

    public static <T> boolean validIndex(T[] array, int index)
    {
        Objects.requireNonNull(array);

        return index >= 0 && index < array.length;
    }

    public static <T> T[] validIndexWithException(T[] array, int index)
    {
        Objects.requireNonNull(array);

        if (index >= 0 && index < array.length)
            return array;
        else
            throw new IllegalArgumentException("The validated array index is invalid: "+index);
    }

    public static <T> boolean validIndex(Collection<T> collection, int index)
    {
        Objects.requireNonNull(collection);

        return index >= 0 && index < (long) collection.size();
    }

    public static <T> Collection<T> validIndexWithException(Collection<T> collection, int index)
    {
        Objects.requireNonNull(collection);

        if (index >= 0 && index < collection.size())
            return collection;
        else
            throw new IllegalArgumentException("The validated collection index is invalid: "+index);
    }

    public static boolean isValid(float x)
    {
        if (Float.isNaN(x))
        {
            // NaN.
            return false;
        }

        return !Float.isInfinite(x);
    }

    public static boolean isValid(double x)
    {
        if (Double.isNaN(x))
        {
            // NaN.
            return false;
        }

        return !Double.isInfinite(x);
    }
}
