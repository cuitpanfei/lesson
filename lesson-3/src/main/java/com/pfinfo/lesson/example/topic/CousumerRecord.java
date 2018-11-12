package com.pfinfo.lesson.example.topic;

public final class CousumerRecord<K, V> {
	private K key;
	private V value;

	public K key() {
		return key;
	}
	public V value() {
		return value;
	}
	@Override
	public String toString() {
		return "CousumerRecord [key=" + key + ", value=" + value + "]";
	}
	
}
