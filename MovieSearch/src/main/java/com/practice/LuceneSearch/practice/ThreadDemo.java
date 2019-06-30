package com.practice.LuceneSearch.practice;

public class ThreadDemo extends Thread 
{
   public static void main(String args[]){
	   Thread t = new Thread(new ThreadDemo());
	   t.start();
	   System.out.println("main thread executing");
   }
   
	public void run() {
		System.out.println("Thread execution starts");
		try {
			System.out.println("Thread is sleeping ....");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread is awake now");
	}
}
