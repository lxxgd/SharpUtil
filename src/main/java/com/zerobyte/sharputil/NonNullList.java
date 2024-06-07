package com.zerobyte.sharputil;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class NonNullList<E> extends AbstractList<E> {
    public List<E> list;
    public E defaultValue;

    public NonNullList(int size,E defaultValue)
    {
//        ValidateUtil.RequireNonNull(defaultValue);
        Object[] e = new Object[size];
        Arrays.fill(e, defaultValue);
        this.list = Arrays.asList((E[])e);
        this.defaultValue = defaultValue;
    }

    public NonNullList(E pDefaultValue, E... pElements) {
        this.list = Arrays.asList(pElements);
        this.defaultValue = pDefaultValue;
    }

    @Override
    public E get(int pIndex) {
        return this.list.get(pIndex);
    }

    @Override
    public E set(int pIndex, E pValue) {
        //Validate.notNull(pValue);
        return this.list.set(pIndex, pValue);
    }

    @Override
    public void add(int pIndex, E pValue) {
        //Validate.notNull(pValue);
        this.list.add(pIndex, pValue);
    }

    @Override
    public E remove(int pIndex) {
        return this.list.remove(pIndex);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public void clear() {
        if (this.defaultValue == null) {
            super.clear();
        } else {
            for(int i = 0; i < this.size(); ++i) {
                this.set(i, this.defaultValue);
            }
        }
    }
}
