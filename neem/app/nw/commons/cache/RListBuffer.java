package nw.commons.cache;

import java.util.concurrent.LinkedBlockingQueue;

import nw.commons.NeemClazz;

/**
 * Provides a simple blocking linked queue. Use with caution
 * @author kulgan
 *
 * @param <T> Generic class for item to be used in the queue
 */
public class RListBuffer<T> extends NeemClazz {
	
	/** The queue. */
	protected LinkedBlockingQueue<T> queue;
	
	/**
	 * Instantiates a new r list buffer.
	 */
	public RListBuffer(){
		queue = new LinkedBlockingQueue<T>(1000);
		debug("Queue initialized with default size of 1000");
	}
	
	/**
	 * Instantiates a new r list buffer.
	 *
	 * @param queueCap the queue cap
	 */
	public RListBuffer(int queueCap){
		queue = new LinkedBlockingQueue<T>(queueCap);
		debug("Queue initialized with default size " + queueCap);
	}
	
	/**
	 * Inserts item to the tail of the queue.
	 *
	 * @param item the item
	 */
	public void queueItem(T item){
		debug("Adding item to queue. ItemType: " + item);
		queue.add(item);
	}
	
	/**
	 * Retrieves and removes the head element in queue.
	 *
	 * @return the head element in the queue
	 */
	public T deQueueItem() {
		T poll = queue.poll();
		debug("Retrieved item from queue. ItemType: " + poll);
		return poll;
	}
	
	/**
	 * Retrieves and does not remove the head element in queue.
	 *
	 * @return the head element in the queue
	 */
	public T getHeadItem() {
		debug("Retrieving head item from queue.");
		return queue.peek();
	}
	
	/**
	 * Long queue.
	 *
	 * @param item the item
	 * @throws InterruptedException the interrupted exception
	 */
	public void longQueue(T item) throws InterruptedException{
		debug("Adding item to queue, may wait if queue is full. ItemType: " + item);
		queue.put(item);
	}
	
	/**
	 * Long deque.
	 *
	 * @return the t
	 * @throws InterruptedException the interrupted exception
	 */
	public T longDeque() throws InterruptedException{
		debug("Retrieving item from queue. May wait if queue is empty");
		return queue.take();
	}
	
}
