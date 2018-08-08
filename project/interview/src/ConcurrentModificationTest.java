import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
//https://www.cnblogs.com/snowater/p/8024776.html
public class ConcurrentModificationTest {
	public List<String> m1(List<String> list) {
        for (String temp : list) {
            if ("3".equals(temp)) {
                list.remove(temp);
            }
        }
        return list;
        
    }
    // ³öÏÖjava.util.ConcurrentModificationException
    public List<String> m2(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String temp = iterator.next();
            if ("3".equals(temp)) {
                list.remove(temp);
            }
            
        }
        return list;
        
    }
    //successful!
    public List<String> m3(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if ("3".equals(list.get(i))) {
                list.remove(i);
            }
        }
        return list;
        
    }
    
    public static void test5() throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.valueOf(i));
        }

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (arrayList) {
                    ListIterator<Integer> iterator = arrayList.listIterator();
                    while (iterator.hasNext()) {
                        System.out.println("thread1 " + iterator.next().intValue());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (arrayList) {
                    ListIterator<Integer> iterator = arrayList.listIterator();
                    while (iterator.hasNext()) {
                        Integer integer = iterator.next();
                        System.out.println("thread2 " + integer.intValue());
                        if (integer.intValue() == 5) {
                            iterator.remove();
                        }
                    }
                    System.out.println("size is "+arrayList.size());
                }
            }
        });
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        
    }
    
    public static void test6() {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(Integer.valueOf(i));
        }

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ListIterator<Integer> iterator = list.listIterator();
                while (iterator.hasNext()) {
                    System.out.println("thread1 " + iterator.next().intValue());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                for (Integer integer : list) {
//                    System.out.println("thread2 " + integer.intValue());
//                    if (integer.intValue() == 5) {
//                        list.remove(integer);
//                    }
//                }
//                for (Integer integer : list) {
//                    System.out.println("thread2 again " + integer.intValue());
//                }
                ListIterator<Integer> iterator = list.listIterator();
                while (iterator.hasNext()) {
                    Integer integer = iterator.next();
                    System.out.println("thread2 " + integer.intValue());
                    if (integer.intValue() == 5) {
                        iterator.remove();
                    }
                }
                for (Integer integer : list) {
                  System.out.println("thread2 again " + integer.intValue());
              }
            }
        });
        thread1.start();
        thread2.start();
    }
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        ConcurrentModificationTest test = new ConcurrentModificationTest();
        List<String> listTemp = test.m2(list);
        System.out.println(listTemp.toString());
    	
//    	try {
//			test5();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	test6();
    }
}
