package com.malsolo.springframework.samples.vasken;

import java.io.IOException;
import java.lang.management.ManagementFactory;

public class ProcessBuilderExample {
	
	/*
	 * Take a look to: http://www.golesny.de/p/code/javagetpid
	 */
	
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder("notepad.exe");
		Process p = pb.start();
		for (int i = 0; i < 10000; i++) {
			System.out.println("Waiting for notepad to exit...");
		}
		System.out.println("¿PID?: " + ManagementFactory.getRuntimeMXBean().getName());
		Thread.sleep(3000);
		p.destroy();
		System.out.println("Notepad exited with code: " + p.waitFor());
		
	}

}
