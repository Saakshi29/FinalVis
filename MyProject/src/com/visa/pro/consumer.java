package com.visa.pro;

public class consumer extends Thread {
	Buffer buffer;

	public consumer(Buffer buffer) {
		super();
		this.buffer = buffer;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			buffer.consume();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
