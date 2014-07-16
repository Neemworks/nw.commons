package nw.commons.cache;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import nw.commons.NeemClazz;

/**
 * 
 * @author kulgan
 *
 * @param <T>
 */
public class LocalBlockingQueue<T> extends NeemClazz{
	
	protected LinkedBlockingQueue<T> queue;
	
	public LocalBlockingQueue(){
		queue = new LinkedBlockingQueue<T>(1000);
		debug("Queue initialized with default size of 1000");
	}
	
	public LocalBlockingQueue(int queueCap){
		queue = new LinkedBlockingQueue<T>(queueCap);
		debug("Queue initialized with default size " + queueCap);
	}
	
	/**
	 * Inserts item to the tail of the queue
	 * @param item
	 * @return 
	 */
	public boolean queueItem(T item){
		debug("Adding item to queue. ItemType: " + item);
		return queue.add(item);
	}
	
	public boolean queueItems(List<T> items){
		return queue.addAll(items);
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
