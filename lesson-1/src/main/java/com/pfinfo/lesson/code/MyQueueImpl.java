package com.pfinfo.lesson.code;

import com.pfinfo.lesson.one.Queue;

/**
 * 顺序队列
 * @author pys1714
 *
 */
public class MyQueueImpl<T> implements Queue<T>{
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		// TODO 返回队列长度
		return 0;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		// TODO 判断队列是否为空
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(T data) {
		// TODO data 入队,添加成功返回true,否则返回false,可扩容
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean offer(T data) {
		// TODO offer 方法可插入一个元素,这与add方法不同， 该方法只能通过抛出未经检查的异常使添加元素失败。而不是出现异常的情况，例如在容量固定（有界）的队列中 NullPointerException:data==null时抛出
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T peek() {
		// TODO 返回队头元素,不执行删除操作,若队列为空,返回null
		return null;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T element() {
		// TODO 返回队头元素,不执行删除操作,若队列为空,抛出异常:NoSuchElementException
		return null;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T poll() {
		// TODO 出队,执行删除操作,返回队头元素,若队列为空,返回null
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T remove() {
		// TODO 出队,执行删除操作,若队列为空,抛出异常:NoSuchElementException
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clearQueue() {
		// TODO 清空队列

	}

}
