package org.spring.engine.beginner;

import org.springframework.asm.ClassWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class Logger {

	//@Autowired
	private ConsoleWriter consoleWriter;
	//@Autowired
	private FileWriter fileWriter;

	/*@Autowired
	public Logger(ConsoleWriter consoleWriter, FileWriter fileWriter) {
		this.consoleWriter = consoleWriter;
		this.fileWriter = fileWriter;
	}*/
	public void getConsoleWriter(String text) {
		consoleWriter.write(text);
	}
	/*//@Autowired
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}*/
	public void getFileWriter(String text) {
		fileWriter.write(text);
	}
	/*//@Autowired
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}*/
	
	
}
