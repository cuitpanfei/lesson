package com.pfinfo.lesson.one;

public interface MyIterable<T> {
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an MyIterator.
     */
    MyIterator<T> iterator();
}
