package ThreadPools_5;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{

	private int id;
	
	public Processor(int id) {
		this.id= id;
	}
		

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
        System.out.println("Starting: " + id);

        try {
        	Thread.sleep(5000);

        }
        catch (Exception e) {
			// TODO: handle exception
		}
        System.out.println("Completed: " + id);		
	}
}


public class App {	
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for(int i=0;i < 2;i ++) {
			executor.submit(new Processor(i));
		}
		executor.shutdown();
		
        System.out.println("All tasks submitted.");

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException ignored) {
        }
        System.out.println("All tasks completed.");
		
	}

}
