package nw.commons.cache;

import java.util.concurrent.ConcurrentLinkedQueue;

import nw.commons.NeemClazz;

/**
 * Provides a simple none blocking linked queue. Use with caution
 * @author kulgan
 *
 * @param <T> Generic class for item to be used in the queue
 */
public class RListBuffer<T> extends NeemClazz {
	
	private ConcurrentLinkedQueue<T> queue;
	
	public RListBuffer(){
		queue = new ConcurrentLinkedQueue<T>();
	}
	
	/**
	 * Inserts item to the tail of the queue
	 * @param item
	 */
	public void queueItem(T item){
		queue.add(item);
	}
	
	/**
	 * Retrieves and removes the head element in queue
	 * @return the head element in the queue
	 */
	public T deQueueItem() {
		return queue.poll();
	}
	
	/**
	 * Retrieves and does not remove the head element in queue
	 * @return the head element in the queue
	 */
	public T getHeadItem() {
		return queue.peek();
	}
	
}
