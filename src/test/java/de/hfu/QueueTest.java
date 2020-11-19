package de.hfu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
	private Queue q;

	@Before
	public void erstelleQueue() {
		q = new Queue(3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testQueue() {
		Queue t = new Queue(0);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testDequeueEmpty() {
		q.dequeue();
	}
	
	@Test
	public void testEnqueue() {
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		assertEquals(1, q.dequeue());
		assertEquals(2, q.dequeue());
		assertEquals(4, q.dequeue());
		
		for(int i=0; i<50; i++) {
			q.enqueue(i);
		}
		assertEquals(0, q.dequeue());
		assertEquals(1, q.dequeue());
		assertEquals(49, q.dequeue());
	}
}
