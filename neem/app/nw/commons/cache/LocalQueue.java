package nw.commons.cache;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import nw.commons.NeemClazz;

// TODO: Auto-generated Javadoc
/**
 * Simple queue Implementation.
 *
 * @author kulgan
 * @param <T> object in queue
 */
public class LocalQueue<T> extends NeemClazz{
	
	/** The queue. */
	protected ConcurrentLinkedQueue<T> queue;
	
	/**
	 * Instantiates a new local queue.
	 */
	public LocalQueue(){
		queue = new ConcurrentLinkedQueue<T>();
		debug("Queue successfully initialized.");
	}
	
	
	/**
	 * Inserts item to the tail of the queue.
	 *
	 * @param item the item
	 * @return true, if successful
	 */
	public boolean queueItem(T item){
		return queue.add(item);
	}
	
	/**
	 * Inserts a list of items into the queue.
	 *
	 * @param items the items
	 * @return true, if successful
	 */
	public boolean queueItems(List<T> items){
		return queue.addAll(items);
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

}
