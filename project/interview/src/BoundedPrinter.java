import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedPrinter {
	public static void main(String[] args) {
//		Lock lock = new ReentrantLock();
//		Integer target = new Integer(0);
		BoundedNumber bn = new BoundedNumber(5, 0, 10);
		Thread InThread = new Thread(new IncrementPrinter(bn), "incre");
		Thread DeThread = new Thread(new DecrementPrinter(bn), "decre");
		InThread.start();
		DeThread.start();
		
	}
    
}

class IncrementPrinter implements Runnable{
	BoundedNumber number;
	public IncrementPrinter(BoundedNumber bn) {
		this.number = bn;
	}
	public void run() {
		while (true) {
			number.increase();;
		}
	}
}

class DecrementPrinter implements Runnable{
	BoundedNumber number;
	public DecrementPrinter(BoundedNumber bn) {
		this.number = bn;
	}
	public void run() {
		while (true) {
			number.decrease();
		}
	}
}

class BoundedNumber{
	private int printer;
	private int least;
	private int most;
	
	private final Lock lock = new ReentrantLock();
	private final Condition notLeast = lock.newCondition();
	private final Condition notMost = lock.newCondition();
	
	BoundedNumber(int start, int least, int most){
		this.printer = start;
		this.least = least;
		this.most = most;
	}
	
	public void increase() {
		try {
			lock.lock();
			while(printer == most) {
				notMost.await();
			}
			printer++;
			System.out.println("increase 1 =>" + printer);
			Thread.sleep(1000);
			notLeast.signal();
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void decrease() {
		try {
			lock.lock();
			while(printer == least) {
				notLeast.await();
			}
			printer--;
			System.out.println("decrease 1 =>" + printer);
			Thread.sleep(1000);
			notMost.signal();
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}