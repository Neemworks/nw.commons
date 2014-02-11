package nw.commons.cache;

import java.util.concurrent.LinkedBlockingQueue;

import nw.commons.NeemClazz;

/**
 * Provides a simple none blocking linked queue. Use with caution
 * @author kulgan
 *
 * @param <T> Generic class for item to be used in the queue
 */
public class RListBuffer<T> extends NeemClazz {
	
	protected LinkedBlockingQueue<T> queue;
	
	public RListBuffer(){
		queue = new LinkedBlockingQueue<T>(1000);
		debug("Queue initialized with default size of 1000");
	}
	
	public RListBuffer(int queueCap){
		queue = new LinkedBlockingQueue<T>(queueCap);
		debug("Queue initialized with default size " + queueCap);
	}
	
	/**
	 * Inserts item to the tail of the queue
	 * @param item
	 */
	public void queueItem(T item){
		debug("Adding item to queue. ItemType: " + item);
		queue.add(item);
	}
	
	/**
	 * Retrieves and removes the head element in queue
	 * @return the head element in the queue
	 */
	public T deQueueItem() {
		T poll = queue.poll();
		debug("Retrieved item from queue. ItemType: " + poll);
		return poll;
	}
	
	/**
	 * Retrieves and does not remove the head element in queue
	 * @return the head element in the queue
	 */
	public T getHeadItem() {
		debug("Retrieving head item from queue.");
		return queue.peek();
	}
	
	public void longQueue(T item) throws InterruptedException{
		debug("Adding item to queue, may wait if queue is full. ItemType: " + item);
		queue.put(item);
	}
	
	public T longDeque() throws InterruptedException{
		debug("Retrieving item from queue. May wait if queue is empty");
		return queue.take();
	}
	
}
