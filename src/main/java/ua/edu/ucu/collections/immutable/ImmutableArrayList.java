package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList{
    private Object[] arr;

    public ImmutableArrayList() {
        arr = new Object[0];
    }

    public ImmutableArrayList(Object[] arr) {
        this.arr = Arrays.copyOf(arr, arr.length);
    }

    @Override
    public ImmutableList add(Object e) {
        return add(arr.length, e);
    }


    @Override
    //додає елемент до колекції за індексом, та кидає виключну ситуацію (ArrayIndexOutOfBoundsException), якщо індекс
    // виходить за межі колекції
    public ImmutableList add(int index, Object e) {
        if (index > arr.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object[] newArray = Arrays.copyOf(arr, arr.length + 1);
        System.arraycopy(arr, 0, newArray, 0, index);
        System.arraycopy(arr, index, newArray, index + 1, arr.length - index);
        newArray[index] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(arr.length, c);
    }
    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > arr.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object[] newArray = Arrays.copyOf(arr, arr.length + c.length);
        System.arraycopy(arr, 0, newArray, 0, index);
        System.arraycopy(c, 0, newArray, index, c.length);
        System.arraycopy(arr, index, newArray, index + c.length, arr.length - index);
        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        if (index > arr.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index > arr.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object[] newArray = Arrays.copyOf(arr, arr.length - 1);
        System.arraycopy(arr, 0, newArray, 0, index);
        System.arraycopy(arr, index + 1, newArray, index, arr.length - index - 1);
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index > arr.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object[] newArray = Arrays.copyOf(arr, arr.length);
        newArray[index] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return arr.length == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr, arr.length);
    }


    @Override
    public String toString() {
        String str = Arrays.toString(toArray());
        return str.substring(1, str.length() - 1);
    }
}
