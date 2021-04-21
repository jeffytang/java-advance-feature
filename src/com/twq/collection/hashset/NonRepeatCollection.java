package com.twq.collection.hashset;

import java.util.HashMap;
import java.util.Iterator;

/**
 *  不允许有重复元素的集合
 * @param <E>
 */
public class NonRepeatCollection<E> implements Iterable<E>{
    private HashMap<E, Object> map;

    private static final Object DUMMY_OBJECT = new Object();

    public NonRepeatCollection() {
        map = new HashMap<>();
    }

    public void add(E element) {
        // map中的 key 是不允许重复
        map.put(element, DUMMY_OBJECT);
    }


    @Override
    public Iterator<E> iterator() {
        // 拿到 map 所有的 key，然后返回迭代器
        return map.keySet().iterator();
    }

    public static void main(String[] args) {

    }
}
