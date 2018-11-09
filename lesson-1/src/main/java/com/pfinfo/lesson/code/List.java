package com.pfinfo.lesson.code;

import com.pfinfo.lesson.one.MyList;

public interface List<E> extends MyList<E> {
	/**
	 * {@inheritDoc}}
	 * 
	 * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IllegalStateException         {@inheritDoc}
	 */
	@Override
	default boolean add(E e){
		throw new UnsupportedOperationException("add");	
	}
}
