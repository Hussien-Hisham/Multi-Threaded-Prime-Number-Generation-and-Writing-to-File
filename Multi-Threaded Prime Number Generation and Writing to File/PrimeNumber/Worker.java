package PrimeNumber;

public abstract class Worker {

	private Queue queue;

	/**
	 * Set the queue for either the producer, either the consumer
	 *
	 */
	protected Worker(Queue queue) {
		this.setQueue(queue);
	}

	/**
	 * 
	 * return the queue instance
	 */
	protected Queue queue() {
		return queue;
	}

	private void setQueue(Queue queue) {
		this.queue = queue;
	}
}
