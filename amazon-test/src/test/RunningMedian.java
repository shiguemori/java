package test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {

	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}
		scan.close();
		medianTracker(array);
	}

	/**
	 * @param array
	 */
	public static void medianTracker(int[] array) {
		for (int i = 0; i < array.length; i++) {
			addNumber(array[i]);
			System.out.println(getMedian());
		}
	}

	/**
	 * @param n
	 */
	private static void addNumber(int n) {
		if (maxHeap.isEmpty()) {
			maxHeap.add(n);
		} else if (maxHeap.size() == minHeap.size()) {
			if (n < minHeap.peek()) {
				maxHeap.add(n);
			} else {
				minHeap.add(n);
				maxHeap.add(minHeap.remove());
			}
		} else if (maxHeap.size() > minHeap.size()) {
			if (n > maxHeap.peek()) {
				minHeap.add(n);
			} else {
				maxHeap.add(n);
				minHeap.add(maxHeap.remove());
			}
		}
	}

	/**
	 * @return
	 */
	private static double getMedian() {
		if (maxHeap.isEmpty()) {
			return 0;
		} else if (maxHeap.size() == minHeap.size()) {
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		} else { 
			return maxHeap.peek();
		}
	}

}
