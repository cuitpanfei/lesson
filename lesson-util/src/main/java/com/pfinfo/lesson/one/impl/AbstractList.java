package com.pfinfo.lesson.one.impl;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

import com.pfinfo.lesson.one.MyIterator;
import com.pfinfo.lesson.one.MyList;

public abstract class AbstractList<E> extends AbstractCollection<E> implements MyList<E> {

	/**
	 * Default initial capacity.
	 */
	protected static final int DEFAULT_CAPACITY = 10;

	/**
	 * Shared empty array instance used for default sized empty instances. We
	 * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
	 * first element is added.
	 */
	protected static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

	/**
	 * The array buffer into which the elements of the ArrayList are stored. The
	 * capacity of the ArrayList is the length of this array buffer. Any empty
	 * ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA will be
	 * expanded to DEFAULT_CAPACITY when the first element is added.
	 */
	transient Object[] elementData; // non-private to simplify nested class
									// access

	/**
	 * The size of the ArrayList (the number of elements it contains).
	 *
	 * @serial
	 */
	protected int size;

	/**
	 * The number of times this list has been <i>structurally modified</i>.
	 * Structural modifications are those that change the size of the list, or
	 * otherwise perturb it in such a fashion that iterations in progress may
	 * yield incorrect results.
	 *
	 * <p>
	 * This field is used by the iterator and list iterator implementation
	 * returned by the {@code iterator} and {@code listIterator} methods. If the
	 * value of this field changes unexpectedly, the iterator (or list iterator)
	 * will throw a {@code ConcurrentModificationException} in response to the
	 * {@code next}, {@code remove}, {@code previous}, {@code set} or
	 * {@code add} operations. This provides <i>fail-fast</i> behavior, rather
	 * than non-deterministic behavior in the face of concurrent modification
	 * during iteration.
	 *
	 * <p>
	 * <b>Use of this field by subclasses is optional.</b> If a subclass wishes
	 * to provide fail-fast iterators (and list iterators), then it merely has
	 * to increment this field in its {@code add(int, E)} and
	 * {@code remove(int)} methods (and any other methods that it overrides that
	 * result in structural modifications to the list). A single call to
	 * {@code add(int, E)} or {@code remove(int)} must add no more than one to
	 * this field, or the iterators (and list iterators) will throw bogus
	 * {@code ConcurrentModificationExceptions}. If an implementation does not
	 * wish to provide fail-fast iterators, this field may be ignored.
	 */
	protected transient int modCount = 0;
	/**
	 * The maximum size of array to allocate. Some VMs reserve some header words
	 * in an array. Attempts to allocate larger arrays may result in
	 * OutOfMemoryError: Requested array size exceeds VM limit
	 */
	protected static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean add(E e) {
		ensureCapacityInternal(size + 1); // Increments modCount!!
		elementData[size++] = e;
		return true;
	}

	private void ensureCapacityInternal(int minCapacity) {
		if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
			minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
		}

		ensureExplicitCapacity(minCapacity);
	}

	private void ensureExplicitCapacity(int minCapacity) {
		modCount++;

		// overflow-conscious code
		if (minCapacity - elementData.length > 0)
			grow(minCapacity);
	}

	/**
	 * Increases the capacity to ensure that it can hold at least the number of
	 * elements specified by the minimum capacity argument.
	 *
	 * @param minCapacity
	 *            the desired minimum capacity
	 */
	private void grow(int minCapacity) {
		// overflow-conscious code
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity - minCapacity < 0)
			newCapacity = minCapacity;
		if (newCapacity - MAX_ARRAY_SIZE > 0)
			newCapacity = hugeCapacity(minCapacity);
		// minCapacity is usually close to size, so this is a win:
		elementData = Arrays.copyOf(elementData, newCapacity);
	}

	private static int hugeCapacity(int minCapacity) {
		if (minCapacity < 0) // overflow
			throw new OutOfMemoryError();
		return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE
				: MAX_ARRAY_SIZE;
	}

	@Override
	public boolean del(Object o) {
		if (o == null) {
			for (int index = 0; index < size; index++)
				if (elementData[index] == null) {
					fastRemove(index);
					return true;
				}
		} else {
			for (int index = 0; index < size; index++)
				if (o.equals(elementData[index])) {
					fastRemove(index);
					return true;
				}
		}
		return false;
	}

	
	/*
	 * Private remove method that skips bounds checking and does not return the
	 * value removed.
	 */
	private void fastRemove(int index) {
		modCount++;
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elementData, index + 1, elementData, index,
					numMoved);
		elementData[--size] = null; // clear to let GC do its work
	}

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param index
	 *            index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException
	 *             {@inheritDoc}
	 */
	public E get(int index) {
		rangeCheck(index);

		return elementData(index);
	}

	@SuppressWarnings("unchecked")
	E elementData(int index) {
		return (E) elementData[index];
	}

	/**
	 * Checks if the given index is in range. If not, throws an appropriate
	 * runtime exception. This method does *not* check if the index is negative:
	 * It is always used immediately prior to an array access, which throws an
	 * ArrayIndexOutOfBoundsException if index is negative.
	 */
	private void rangeCheck(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	/**
	 * Constructs an IndexOutOfBoundsException detail message. Of the many
	 * possible refactorings of the error handling code, this "outlining"
	 * performs best with both server and client VMs.
	 */
	private String outOfBoundsMsg(int index) {
		return "Index: " + index + ", Size: " + size;
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 *
	 * @param index
	 *            index of the element to replace
	 * @param element
	 *            element to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException
	 *             {@inheritDoc}
	 */
	public E set(int index, E element) {
		rangeCheck(index);

		E oldValue = elementData(index);
		elementData[index] = element;
		return oldValue;
	}

	/**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * <p>This implementation returns a straightforward implementation of the
     * iterator interface, relying on the backing list's {@code size()},
     * {@code get(int)}, and {@code remove(int)} methods.
     *
     * <p>Note that the iterator returned by this method will throw an
     * {@link UnsupportedOperationException} in response to its
     * {@code remove} method unless the list's {@code remove(int)} method is
     * overridden.
     *
     * <p>This implementation can be made to throw runtime exceptions in the
     * face of concurrent modification, as described in the specification
     * for the (protected) {@link #modCount} field.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    public MyIterator<E> iterator() {
        return new Itr();
    }
    
	private class Itr implements MyIterator<E> {
        /**
         * Index of element to be returned by subsequent call to next.
         */
        int cursor = 0;

        /**
         * Index of element returned by most recent call to next or
         * previous.  Reset to -1 if this element is deleted by a call
         * to remove.
         */
        int lastRet = -1;

        /**
         * The modCount value that the iterator believes that the backing
         * List should have.  If this expectation is violated, the iterator
         * has detected concurrent modification.
         */
        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor != size();
        }

        public E next() {
            checkForComodification();
            try {
                int i = cursor;
                E next = get(i);
                lastRet = i;
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                AbstractList.this.del(lastRet);
                if (lastRet < cursor)
                    cursor--;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

}
