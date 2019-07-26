package com.visa.pro;

import java.util.function.Consumer;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		Buffer buffer=new Buffer();
		Producer producer=new Producer(buffer);
		consumer cons=new consumer(buffer);
		producer.start();
		cons.start();
		System.out.println("started");

	}

}
