import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SequencePrinter {
	public static void main(String[] args) {
		Order order = new Order(0);
		Thread th1 = new Thread(new sp(order));
		Thread th2 = new Thread(new sp(order));
		Thread th3 = new Thread(new sp(order));
		Thread th4 = new Thread(new sp(order));
		Thread th5 = new Thread(new sp(order));
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
	}
}
class sp implements Runnable{
	Order order;
	public sp(Order order) {
		this.order = order;
	}
	public void run() {
		order.print();
	}
}
class Order{
	int order;
	Lock lock = new ReentrantLock();
	public Order(int order) {
		this.order = order;
	}
	public void print() {
		try {
			lock.lock();
			System.out.println(order++);
			
		}finally {
			lock.unlock();
		}
	}
	
}
