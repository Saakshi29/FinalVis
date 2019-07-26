package com.visa.pro;

import java.util.concurrent.Callable;

public class CallablePrimeSearch implements Callable<Integer> {
	long start;
	long end;
	int count;
	volatile boolean resultReady;

	public CallablePrimeSearch(long start, long end) {
		this.start = start;
		this.end = end;

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



	@Override
	public Integer call() throws Exception {
		for (long i = start; i <= end; i++)
			if (isPrime(i))
				count++;
		resultReady=true;
		return count;
	}
}
