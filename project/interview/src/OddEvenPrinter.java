import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class OddEvenPrinter {
	 
	public static void main(String[] args) {
//		AtomicInteger target = new AtomicInteger(0);
//		Semaphore s = new Semaphore(1, true);
//		Semaphore t = new Semaphore(0, true);
//	    Thread oddThread = new Thread(new odd_printer(target, s, t), "odd thread");
//	    Thread evenThread = new Thread(new even_printer(target, s, t), "even thread");
//	    oddThread.start();
//	    evenThread.start();
		Printer1 printer = new Printer1(0,100);
		Thread odd = new Thread(new OddPrinter(printer), "odd");
		Thread even = new Thread(new EvenPrinter(printer), "even");
		odd.start();
		even.start();
	}
}

class odd_printer implements Runnable{
    private AtomicInteger target;
    private Semaphore s, t;
	public odd_printer(AtomicInteger target, Semaphore s, Semaphore t) {
		super();
		this.target = target;
		this.s = s;
		this.t= t;
	}
	public void run() {
		while(100 >= target.intValue()) {
			try {
				s.acquire();
				System.out.println(Thread.currentThread().getName() + "--" + target.getAndIncrement());
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}finally {
            	t.release();
            }
		}
	}
}
class even_printer implements Runnable{
	AtomicInteger target;
	private Semaphore s, t;
	public even_printer(AtomicInteger target, Semaphore s, Semaphore t) {
		super();
		this.target = target;
		this.s = s;
		this.t= t;
	}
	public void run() {
		while(100 >= target.intValue()) {
			try {
				t.acquire();
				System.out.println(Thread.currentThread().getName() + "--" + target.getAndIncrement());
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}finally {
            	s.release();
            }
		}
	}
}
class OddPrinter implements Runnable{
	Printer1 printer ;
	public OddPrinter(Printer1 printer) {
		this.printer = printer;
	}
	public void run() {
		printer.printOdd();
	}
}

class EvenPrinter implements Runnable{
	Printer1 printer ;
	public EvenPrinter(Printer1 printer) {
		this.printer = printer;
	}
	public void run() {
		printer.printEven();
	}
}
class Printer1{
	private int start, end;
	private Semaphore odd = new Semaphore(1);
	private Semaphore even = new Semaphore(0);
	public Printer1(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public void printOdd() {
		while(start < end) {
			try {
				odd.acquire();
				if(start < end) {
					start++;
					System.out.println(Thread.currentThread().getName() + "--" +start);
				}
			}catch(InterruptedException ex) {
			    ex.printStackTrace();	
			}finally {
				even.release();
			}
		}
	}
	public void printEven() {
		while(start < end) {
			try {
				even.acquire();
				if(start < end) {
					start++;
					System.out.println(Thread.currentThread().getName() + "--" +start);
				}
			}catch(InterruptedException ex) {
			    ex.printStackTrace();	
			}finally {
				odd.release();
			}
		}
	}
}