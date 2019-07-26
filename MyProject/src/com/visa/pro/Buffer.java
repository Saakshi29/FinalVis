package com.visa.pro;

public class Buffer {

	int data;
	boolean available = false;

	public synchronized void produce(int newData) {
		while (available) {
			try {
				// Thread.sleep(100);
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		System.out.println("Producer producing" + newData);
		data = newData;
		available = true;
		this.notify();
	}

	public synchronized int consume() {
		while (!available) {
			try {
				// Thread.sleep(100);
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		System.out.println("Consumer consuming" + data);
		available = false;
		this.notify();
		return data;
	}
}
