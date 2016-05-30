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
package com.nimworks.commons.cache;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.nimworks.commons.logging.Loggable;

/**
 * Simple queue Implementation.
 *
 * @author Ogwara O. Rowland
 * @param <T> object in queue
 */
public class GenericQueue<T> extends Loggable{

	/** The queue. */
	protected ConcurrentLinkedQueue<T> queue;

	/**
	 * Instantiates a new local queue.
	 */
	public GenericQueue(){
		queue = new ConcurrentLinkedQueue<T>();
		logger.debug("Queue successfully initialized.");
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

}
