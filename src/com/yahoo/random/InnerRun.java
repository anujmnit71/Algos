package com.yahoo.random;


public class InnerRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InnerRun().test();
		System.out.println("Main thread name: "+Thread.currentThread().getName());
		Test t = new Test();
	}
	private void test() {
	
		Thread myThread = new Thread(new Runnable(){
			public void run(){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Inner thread name: "+Thread.currentThread().getName());
			}
		});
		//myThread.setDaemon(true);// main thread would finish first and hence no Inner thread output
		myThread.start();
		
	}
	private static class Test{
		
	}
}

class Test2 {
	//Test t ; //Its Private
	
}
