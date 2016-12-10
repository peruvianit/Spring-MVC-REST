package it.peruvianit.metrics;

import java.util.LinkedList;
import java.util.Queue;

import it.peruvianit.dto.RequestDetailsDTO;

public class ExecuteQueuSingleton {
	private static ExecuteQueuSingleton instance = null;
	private static Queue<RequestDetailsDTO> queue = new LinkedList<RequestDetailsDTO>();
	
	protected ExecuteQueuSingleton() {
	}
 
	public static ExecuteQueuSingleton getInstance() {
		if (instance == null) {
			synchronized (ExecuteQueuSingleton.class) {
				if (instance == null) {
					instance = new ExecuteQueuSingleton();
				}
			}
		}
		return instance;
	}
	
	// Methdos
	public Queue<RequestDetailsDTO> get() {
		return queue;
	}
	
	// Inserts the specified element into this queue if it is possible to do so
	// immediately without violating capacity restrictions
	public void add(RequestDetailsDTO value) {
		synchronized (queue) {
			queue.add(value);
		}
	}
	// Removes a single instance of the specified element from this collection
	public void remove(RequestDetailsDTO value) {
		synchronized (queue) {
			queue.remove(value);
		}
	}
 
	// Retrieves and removes the head of this queue, or returns null if this
	// queue is empty.
	public RequestDetailsDTO poll() {
		RequestDetailsDTO data = queue.poll();
		return data;
	}
 
	// Returns true if this collection contains no elements
	public boolean isEmpty() {
		return queue.isEmpty();
	}
 
	// Returns the number of elements in this collection. If this collection
	// contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE
	public int getTotalSize() {
		return queue.size();
	}
}
