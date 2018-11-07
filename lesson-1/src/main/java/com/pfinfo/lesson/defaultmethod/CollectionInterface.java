package com.pfinfo.lesson.defaultmethod;
/**
 * 定义接口，并包含默认实现方法
 * @author pys1714
 */
public interface CollectionInterface {
    //增加默认实现
    default void addOneObj(Object object){
        System.out.println("default add");
    }
    //删除默认实现
    default void delOneObj(Object object){
        System.out.println("default del");
    }
    //更新默认实现
    default void updateOneObj(Object object){
        System.out.println("default del");
    }
    //接口定义需要实现方法
    String showMsg();
}
