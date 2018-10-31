package com.moon.util.compute.core;

import com.moon.lang.BooleanUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author benshaoye
 */
abstract class DataConst<T> implements AsConst {

    protected final static Map<Object, AsConst> CACHE = new HashMap<>();

    final T value;

    protected DataConst(T value) {
        this.value = value;
    }

    @Override
    public Object use(Object data) {
        return value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean isNumber() {
        return value instanceof Number;
    }

    @Override
    public boolean isString() {
        return value instanceof CharSequence;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static final AsConst get(Object data) {
        if (data == null) {
            return DataConstNull.NULL;
        }
        if (data instanceof CharSequence) {
            return DataConstString.valueOf(data.toString());
        }
        if (data instanceof Number) {
            return DataConstNumber.valueOf((Number) data);
        }
        if (Boolean.TRUE.equals(data)) {
            return DataConstBoolean.TRUE;
        }
        if (Boolean.FALSE.equals(data)) {
            return DataConstBoolean.FALSE;
        }
        if (data instanceof AsConst) {
            return (AsConst) data;
        }
        return DataConstObj.valueOf(data);
    }

    public static final AsConst getOpposite(DataConst data) {
        BooleanUtil.requireTrue(data instanceof DataConstNumber);
        Number num = (Number) data.use(), value;
        if (num instanceof Double || num instanceof Float) {
            value = -num.doubleValue();
        } else if (num instanceof Long) {
            value = -num.longValue();
        } else {
            value = -num.intValue();
        }
        return DataConstNumber.valueOf(value);
    }
}