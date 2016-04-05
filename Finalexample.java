package john_test;

public class Finalexample {
	
	public void finallyFunction(){
		int[] array = new int[]{1,2,3, 4, 5};
		int sum = 0;
		try{
			for(int i = 0; i < 6; i++){
				sum += array[i];
			}
		}
		catch (IndexOutOfBoundsException e){
			System.out.println(e);
		}
		/*
		 * Any statement in finally will run regardless of the outcome of try/catch
		 * It must be put after the catch statement
		 */
		finally{
			System.out.println("Done");
		}
	}
	
	@Override
	protected void finalize() throws Throwable{
		try{
			System.out.println("Finalize");
			//removes resources from this class
		}
		catch (Throwable t){
			throw t;
		}
		finally{
			super.finalize();
		}
	}
	
	public static void main(String[] args){
		/*
		 * Can make variables final, which means their value can't be changed in the rest of the program
		 * Can also make functions final, which means it can't be overridden by subclasses
		 */
		final int x = 5;
		System.out.println(x);
		
		Finalexample fe = new Finalexample();
		fe.finallyFunction();
		try {
			fe.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
