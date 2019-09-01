package task;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class TaskTest {

	private Task task = new Task();

	@Test(expected = NoSuchElementException.class)
	public void testEmpty() {
		int[] arr = {};
		task.compute(arr);
	}

	@Test
	public void testSameFirstAndLastElements() {
		int[] arr = {3,0,3};
		assertEquals(3,task.compute(arr));
	}
	
	@Test
	public void testOneElement() {
		int[] arr = {1};
		assertEquals(0,task.compute(arr));
	}
	
	@Test
	public void testTwoSameElements() {
		int[] arr = {1,1};
		assertEquals(0,task.compute(arr));
	}
	
	@Test
	public void testTwoDifferentElements() {
		int[] arr = {0,1};
		assertEquals(0,task.compute(arr));
	}
	
	@Test
	public void testEvenCountOfElements() {
		int[] arr = {0,2,0,7,0,3};
		assertEquals(5,task.compute(arr));
	}
	
	@Test
	public void testNotEvenCountOfElements() {
		int[] arr = {2,1,4,3,5};
		assertEquals(2,task.compute(arr));
	}
}
