public class Downloader extends Thread{
	private String url;
	public Downloader(String url){
		this.url = url;
	}
	
	public void run(){		
		/*
		 * Below just an example, not an existing class
		 * Can be called from main with:
		 * Downloader d1 = new Downloader("http://...");
		 * Downloader d2 = new Downloader("http://...");
		 * d1.start();
		 * d2.start();
		 */
		
		// FileDownloader fd = new FileDownloader();
		// fd.download(this.url);
	}
	/*
	 * Thread has a ton of better methods
	 * So really this is bad practice
	 * Since the only thing we need is the run method
	 * Instead, we use the runnable interface, and use the runnable class with a Thread object
	 * Check out Task.java and ThreadMain.java for an example of how to do this!
	 */
}
