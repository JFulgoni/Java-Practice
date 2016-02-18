package john_test;

public class Task implements Runnable{
	private static volatile int TASKNUM = 10;
	private String threadName;
	
	public Task(String name){
		threadName = name;
	}

	@Override
	public void run() {
		//boolean interrupted = false;
		int derp;
		try{
			while(TASKNUM > 0){
				derp = TASKNUM;
				System.out.println(threadName + " " + derp);
				--TASKNUM;
				Thread.sleep(2000L);
			}
			
		}
		catch (InterruptedException iex){}
		System.out.println("Exiting Thread");
	}

}
