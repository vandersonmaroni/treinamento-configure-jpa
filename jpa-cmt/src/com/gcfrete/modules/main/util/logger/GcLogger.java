package com.gcfrete.modules.main.util.logger;

public class GcLogger {

	public void fatal(String message, Exception e) {
		System.out.println("=======FATAL=======");
		System.out.println(message);
		System.out.println("===================");
		e.printStackTrace();
	}
}
