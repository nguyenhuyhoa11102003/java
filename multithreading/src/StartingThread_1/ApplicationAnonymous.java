package StartingThread_1;

public class ApplicationAnonymous {
	public static void main(String[] strings) {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i < 5;i++) {
                    System.out.println("Hello: " + i + " Thread: " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ignored) {}
				}
			}
		});
		
		thread.start();
	}

}
