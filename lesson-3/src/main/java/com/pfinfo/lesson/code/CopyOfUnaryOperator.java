package com.pfinfo.lesson.code;


public interface CopyOfUnaryOperator<T> extends UnaryOperator<T> {
	
	default UnaryOperator<T> identity() {

        return t->apply(t);
    }
	
}