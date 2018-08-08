

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-12-4
 * Time: 上午11:25
 * To change this template use File | Settings | File Templates.
 * 
 */




public class GenricSample<T extends Parent> {
  public static <F, G> void func(F arg1, G arg2) {
	 
  }
  public T func2(Class<?> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	  Constructor<?>[] cc = clazz.getConstructors();
	  T r = (T)cc[0].newInstance("Miao");
	  
	  return r;
  }
  public static void main(String[] args) throws Exception{
   GenricSample<Son> t = new GenricSample<Son>();
   Son s = t.func2(Son.class);
   System.out.println(s.getName());
  }
}

class Parent {
	private String name;
	public Parent(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}

class Son extends Parent{
	
	public Son(String n) {
		// TODO Auto-generated constructor stub
		super(n);
	}
}
