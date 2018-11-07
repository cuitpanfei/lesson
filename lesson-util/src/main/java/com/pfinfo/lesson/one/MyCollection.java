package com.pfinfo.lesson.one;


/**
 * 自定义Collection，定义了<code>add(T)</code>,<code>del(T)</code>,<code>clear(T)</code>,<code>size(T)</code>
 * 
 * @author pys1714
 *
 * @param <E>
 */
public interface MyCollection<E> extends MyIterable<E>{
	
	/**
     * 返回元素的个数。 如果集合中超过了 <tt>Integer.MAX_VALUE</tt> 个元素，返回
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of elements in this collection
     */
	int size();
	
	MyIterator<E> iterator();
	
	/**
     * 从这个集合中移除所有元素（可选操作）。
     * 此方法返回后，集合将为空。
     *
     * @throws UnsupportedOperationException 如果此集合不支持<tt>clear</tt>操作，抛出异常
     */
    void clear();
    
    /**
     * Returns <tt>true</tt> if this collection contains no elements.
     *
     * @return <tt>true</tt> if this collection contains no elements
     */
    boolean isEmpty();
    
    /**
     * 添加一个指定的元素到集合 (可选操作)。如果此集合因调用而更改了，返回true。（集合不允许重复，并且已经包含了指定元素。返回false）
     * 需要注意的是，这个操作对被添加的元素可能会存在限制。事实上，有的集合可能会拒绝添加<tt>null</tt>元素，另一些集合或许对可能添加的元素类型施加限
     * 集合类应该在文档中明确地规定对哪些元素可以添加，对限制进行详细描述。
     * 
     * 如果一个集合由于除了已经包含元素之外的任何原因拒绝添加特定的元素，
     * 则它<i>必须</i>抛出异常（而不是返回<tt>false</tt>）。
     * 
     * @param e 指定要添加到集合的元素
     * @return <tt>true</tt> 如果此集合因调用而更改了，返回true。
     * @throws UnsupportedOperationException 如果集合不支持 <tt>add</tt> 操作。
     * 
     * @throws ClassCastException 如果指定元素的类类型不是符合指定规则的类型
     * @throws NullPointerException 如果指定元素为<tt>null<tt>并且且此集合不允许空元素
     * @throws IllegalArgumentException 如果元素的某个属性阻止它被添加到集合中
     * @throws IllegalStateException 如果处在插入限制，此时不能添加元素
     */
    boolean add(E e);
    
    /**
     * 如果存在,从集合中移除指定元素的单个实例(可选操作)。
     * 
     * @param o 指定要从集合删除的元素
     * @return <tt>true</tt> 如果此集合因调用而更改了，返回true。
     * @throws UnsupportedOperationException 如果集合不支持 <tt>add</tt> 操作。
     * 
     * @throws ClassCastException 如果指定元素的类类型不是符合指定规则的类型
     * @throws NullPointerException 如果指定元素为<tt>null<tt>并且且此集合不允许空元素
     * @throws UnsupportedOperationException 如果这个集合不支持<tt>remove</tt>操作 
     */
    boolean del(Object o);

}
