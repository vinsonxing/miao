import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 10/20/14
 * Time: 11:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestForPoxy {

}
class JDKProxy{
  public static Object getProxyObject(final Object c)
  {
    return Proxy.newProxyInstance(c.getClass().getClassLoader(), c.getClass().getInterfaces(), new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object reObject = null;
        System.out.println("before...");
        reObject = method.invoke(c, args);
        System.out.println("after...");
        return reObject;
      }
    });
  }
}
