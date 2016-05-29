/*
 * Copyright 2013 - 2015, Neemworks Nigeria <dev@nimworks.com>
 Permission to use, copy, modify, and distribute this software for any
 purpose with or without fee is hereby granted, provided that the above
 copyright notice and this permission notice appear in all copies.

 THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package nw.commons.cache;

import java.util.concurrent.LinkedBlockingQueue;

import nw.commons.NeemClazz;
import nw.commons.logging.Loggable;

/**
 * Provides a simple blocking linked queue. Use with caution
 * @author kulgan
 *
 * @param <T> Generic class for item to be used in the queue
 */
public class RListBuffer<T> extends Loggable {

	/** The queue. */
	protected LinkedBlockingQueue<T> queue;

	/**
	 * Instantiates a new r list buffer.
	 */
	public RListBuffer(){
		queue = new LinkedBlockingQueue<T>(1000);
		logger.debug("Queue initialized with default size of 1000");
	}

	/**
	 * Instantiates a new r list buffer.
	 *
	 * @param queueCap the queue cap
	 */
	public RListBuffer(int queueCap){
		queue = new LinkedBlockingQueue<T>(queueCap);
		logger.debug("Queue initialized with default size " + queueCap);
	}

	/**
	 * Inserts item to the tail of the queue.
	 *
	 * @param item the item
	 */
	public void queueItem(T item){
		logger.debug("Adding item to queue. ItemType: " + item);
		queue.add(item);
	}

	/**
	 * Retrieves and removes the head element in queue.
	 *
	 * @return the head element in the queue
	 */
	public T deQueueItem() {
		T poll = queue.poll();
		logger.debug("Retrieved item from queue. ItemType: " + poll);
		return poll;
	}

	/**
	 * Retrieves and does not remove the head element in queue.
	 *
	 * @return the head element in the queue
	 */
	public T getHeadItem() {
		logger.debug("Retrieving head item from queue.");
		return queue.peek();
	}

	/**
	 * Long queue.
	 *
	 * @param item the item
	 * @throws InterruptedException the interrupted exception
	 */
	public void longQueue(T item) throws InterruptedException{
		logger.debug("Adding item to queue, may wait if queue is full. ItemType: " + item);
		queue.put(item);
	}

	/**
	 * Long deque.
	 *
	 * @return the t
	 * @throws InterruptedException the interrupted exception
	 */
	public T longDeque() throws InterruptedException{
		logger.debug("Retrieving item from queue. May wait if queue is empty");
		return queue.take();
	}

}
