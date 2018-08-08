
public class Account {
	private int balance;
	 
    public Account(int money) {
        this.balance = money;
    }
 
    public synchronized void withdrawal(int money) {
        // 注意这个地方必须用while循环，因为即便再存入钱也有可能比取的要少
        while (this.balance < money) {
            System.out.println("取款：" + money + " 余额：" + this.balance
                    + " 余额不足，正在等待存款......");
            try {
                wait();
            } catch (Exception e) {
            }
        }
        this.balance = this.balance - money;
        System.out.println("取出：" + money + " 还剩余：" + this.balance);
 
    }
 
    public synchronized void deposit(int money) {
 
        try {
            Thread.sleep(10);
        } catch (Exception e) {
        }
        this.balance = this.balance + money;
        System.out.println("新存入：" + money + " 共计：" + this.balance);
        notify();
    }
 
    public static void main(String args[]) {
        Account Account = new Account(0);
        Deposit b = new Deposit(Account);
        Consumer c = new Consumer(Account);
        new Thread(b).start();
        new Thread(c).start();
    }
}
 
// 存款类
class Deposit implements Runnable {
    Account Account;
 
    public Deposit(Account Account) {
        this.Account = Account;
    }
 
    public void run() {
        while (true) {
            int temp = (int) (Math.random() * 1000);
            Account.deposit(temp);
        }
    }
 
}
 
// 取款类
class Consumer implements Runnable {
    Account Account;
 
    public Consumer(Account Account) {
        this.Account = Account;
    }
 
    public void run() {
        while (true) {
            int temp = (int) (Math.random() * 1000);
            Account.withdrawal(temp);
        }
    }
}
