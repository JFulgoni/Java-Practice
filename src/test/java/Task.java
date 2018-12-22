public class Task implements Runnable, java.io.Serializable{
	private static volatile int TASKNUM = 10;
	//private String threadName;
	private char killKey;
	private boolean threadInterrupt;
	private int displayNum;
	
	public Task(){
		//this.threadName = threadName;
		threadInterrupt = false;
		displayNum = 0;
	}

	@Override
	public void run() {
		int derp;
		try{
			while(TASKNUM > 0){
				derp = TASKNUM;
				--TASKNUM;
				System.out.println("Inside " + Thread.currentThread().getName() + ": " + TASKNUM);
				Thread.sleep(2000L);
			}		
		}
		catch (InterruptedException iex){}
		
//		try{
//			int derp = 0;
//			//System.out.println("Inside " + threadName);	        
//			while(!threadInterrupt){
//				System.out.println(++derp);
//				threadInterrupt = shouldStop();
//				Thread.sleep(2000L);
//			}
//		}
//		catch (InterruptedException iex){}
//		//System.out.println("Exiting " + threadName);
	}

	public boolean shouldStop(){
		return false;
	}

}
