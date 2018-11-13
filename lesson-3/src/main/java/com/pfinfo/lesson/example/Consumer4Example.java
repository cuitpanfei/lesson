package com.pfinfo.lesson.example;

import java.util.Objects;

/**
 * 仿写Consumer<T>，添加部分方法用于代码示例
 * @author pys1714
 *
 * @param <T>
 */
@FunctionalInterface
public interface Consumer4Example<T> {

    void accept(T t);
    
    @Override
    boolean equals(Object obj);

    default Consumer4Example<T> andThen(Consumer4Example<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
    
    static void printHello(){
        System.out.println("Hello，Consumer4Example");
    }

}
