package com.visa.pro;

public class RunnablePrie implements Runnable {
	long start;
	long end;
	int count;
	volatile boolean resultReady;

	public RunnablePrie(long start, long end) {
		this.start = start;
		this.end = end;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (long i = start; i <= end; i++)
			if (isPrime(i))
				count++;
		resultReady=true;
	}

	private boolean isPrime(long num) {
		if (num <= 2) {
			return true;
		}
		for (long i = 2; i < num; i++) {
			if ((num % i) == 0) {
				return false;
			}
		}
		return true;
	}
}
