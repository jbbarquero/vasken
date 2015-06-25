package com.malsolo.springframework.samples.vasken;

import java.io.IOException;
import java.lang.management.ManagementFactory;

public class RuntimeExecExample {
	
	/*
	 * Take a look to: https://blogs.oracle.com/thejavatutorials/entry/changes_to_runtime_exec_problems
	 */
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Process p = Runtime.getRuntime().exec("notepad.exe");
		for (int i = 0; i < 10000; i++) {
			System.out.println("Waiting for notepad to exit...");
		}
		System.out.println("¿PID?: " + ManagementFactory.getRuntimeMXBean().getName());
		Thread.sleep(3000);
//		p.destroy();
		System.out.println("Notepad exited with code: " + p.waitFor());
	}

}
