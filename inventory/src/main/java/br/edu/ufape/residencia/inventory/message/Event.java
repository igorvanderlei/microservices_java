package br.edu.ufape.residencia.inventory.message;

import java.util.Date;

import lombok.Data;

@Data
public class Event<K, T> {
	public enum Type {CREATE, DELETE, UPDATE}
	private Event.Type type;
	private K key;
	private T data;
	private Date createdAt;
	
	public Event() {
		this.type = null;
		this.key = null;
		this.data = null;
	}

	public Event(Type eventType, K key, T data) {
		this.type = eventType;
		this.key = key;
		this.data = data;
		this.createdAt = new Date();
	}
}
