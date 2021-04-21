package com.twq.collection.function;

public interface CheckPerson { // 函数式接口：只有一个抽象方法的接口
    /**
     *  检查指定人是否符合指定的条件
     * @param person    需要检查的人
     * @return  true 说明符合条件，否则不符合条件
     */
    public boolean test(Person person);
}
