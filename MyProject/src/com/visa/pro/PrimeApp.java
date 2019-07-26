package com.visa.pro;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeApp {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		RunnablePrie w1 = new RunnablePrie(1, 10000);

		RunnablePrie w2 = new RunnablePrie(10000, 25000);
		/*
		 * Thread t1 = new Thread(w1); Thread t2 = new Thread(w2); t1.start();
		 * t2.start(); t1.join(); t2.join(); System.out.println(w1.count);
		 * System.out.println(w2.count);
		 */

		ExecutorService pool = Executors.newFixedThreadPool(4);
	/*	pool.execute(w1);
		pool.execute(w2);
		while (!(w1.resultReady & w2.resultReady))
		{
			Thread.sleep(200);
		}
		System.out.println(w1.count);
		System.out.println(w2.count);
		*/
		
		CallablePrimeSearch c1=new CallablePrimeSearch(1, 10000);
		CallablePrimeSearch c2=new CallablePrimeSearch(10000,25000);
		Future<Integer>r1=pool.submit(c1);
		Future<Integer>r2=pool.submit(c2);
		System.out.println(r1.get());
		System.out.println(r2.get());
	
		pool.shutdown();
	}
}
