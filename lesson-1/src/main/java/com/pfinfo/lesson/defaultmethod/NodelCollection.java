package com.pfinfo.lesson.defaultmethod;

/**
 * 特殊集合，不允许删除元素
 */
public class NodelCollection implements CollectionInterface {
	@Override
	public String showMsg() {
		return null;
	}

	@Override
	public void delOneObj(Object object) {
		System.out.println("none del");
	}
}