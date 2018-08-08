public class MyThread implements Runnable {  
          
    @Override  
    public synchronized void run() {  
          
        // TODO Auto-generated method stub  
        for(int i=0; i<10; i++){  
            System.out.println(i + "--" + Thread.currentThread().getName()); 
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }     
          
    }  
      
    public static void main(String[] args) throws InterruptedException {  
        MyThread mt = new MyThread();  
        for(int j=0; j<3; j++){    
            Thread t = new Thread(mt);  
            t.setName(Integer.valueOf(j).toString());         
            t.start();  
              
        }  
    }  
}  