package PrimeNumber;

import PrimeNumberExceptions.*;

public final class Consumer extends Worker implements Runnable {

	public Consumer(Queue _queue) {
		super(_queue);
	}
	

	private void consume() throws QueueFoundNumbersException {
		try {
			/* flag a prime number candidate as prime, or not */
			Number pnc = this.queue().read();
		} catch (QueueEmptyException e) {
			System.err.println(e.getMessage());

			Thread.yield();
			try {
				Thread.sleep(Queue.WAIT_TIME);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}catch (QueueFoundNumbersException qfne) {
			throw qfne;
		}
	}
	
	@Override
	public void run() {
		boolean canWork = true;
		while(canWork) {
			try {
				this.consume();
			} catch (QueueFoundNumbersException e) {
				canWork = false;
			}
			
			try {
				Thread.sleep(Queue.WAIT_TIME);
			} catch (InterruptedException e) {
				canWork = false;
			}
		}
	}
}
