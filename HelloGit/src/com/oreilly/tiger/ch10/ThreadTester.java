package com.oreilly.tiger.ch10;

import java.io.IOException;
import java.io.PrintStream;

public class ThreadTester {

	private final int[] posArray = new int[] { 1, 3, 6, 3, 4, 2, 5 };

	private final int[] negArray = new int[] { -2, -8, -3, -9, -10 };

	public ThreadTester() {

	}

	public void testBubbleSort(PrintStream out) throws IOException {

		Thread t1 = new BubbleSortThread(posArray);

		t1.start();

		out.println("Testing with postive numbers...");

		// Wait for the thread to complete

		try {

			t1.join();

			printArray(posArray, out);

		} catch (InterruptedException ignored) {
		}

		Thread t2 = new BubbleSortThread(negArray);

		t2.start();

		out.println("Testing with negative numbers...");

		try {

			t2.join();

			printArray(negArray, out);

		} catch (InterruptedException ignored) {
		}

	}

	private void printArray(int[] a, PrintStream out) throws IOException {

		for (int n : a) {

			out.println(n);

		}

		out.println();

	}

	public static void main(String[] args) {

		ThreadTester tester = new ThreadTester();

		try {

			tester.testBubbleSort(System.out);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
