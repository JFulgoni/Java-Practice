public class ThreadMain {
	
	public static void main(String[] args){
		Task t1 = new Task();
		Thread thread = new Thread(t1, "Thread 1");
		thread.start();
		Thread thread2 = new Thread(t1, "Thread 2");
		thread2.start();
	}

}
