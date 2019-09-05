# SpringAOP
A simple project describes the internals of SpringAOP

SpringAOP面向切面编程核心思想及底层机制

  核心思想：解耦代码 更好的使业务代码和非业务代码分离 以便后期的维护和扩展
  
  底层实现：定义代理类MyInvocationHandler实现JDKInvocationHandler代理接口
            定义bind方法 通过Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
            取得代理对象（反射获取到委托对象的类加载器，接口里边的相应方法）
            
            
   Spring提供的AOP：
    两个注解：
    
    @Aspect 
      表示该类是切面类
    
    @Component
      将该类注入到 IOC 容器中


@Before("execution(public int com.southwind.aspect.CalImpl.*(..))")

public void before(JoinPoint joinPoint){
  //获取方法名
  String name = joinPoint.getSignature().getName();
  //获取参数列表
  String args = Arrays.toString(joinPoint.getArgs());
  
  System.out.println(name+"的参数是:"+args);
}

@Before：表示 before 方法执行的时机。execution(public int com.southwind.aspect.CalImpl.*(..))：

表示切入点是 com.southwind.aspect 包下 CalImpl 类中的所有方法。

即 CalImpl 所有方法在执行之前会首先执行 LoggerAspect 类中的 before 方法。

after 方法同理，表示 CalImpl 所有方法执行之后会执行 LoggerAspect 类中的 after 方法。

afterReturn 方法表示 CalImpl 所有方法在 return 之后会执行 LoggerAspect 类中的 afterReturn 方法。

afterThrowing 方法表示 CalImpl 所有方法在抛出异常时会执行 LoggerAspect 类中的 afterThrowing 方法。

目标类也需要添加 @Component 注解

@Component

public class CalImpl implements Cal{

    @Override
    public int add(int num1, int num2) {
        // TODO Auto-generated method stub
        return num1+num2;
    }

    @Override
    public int sub(int num1, int num2) {
        // TODO Auto-generated method stub
        return num1-num2;
    }

    @Override
    public int mul(int num1, int num2) {
        // TODO Auto-generated method stub
        return num1*num2;
    }

    @Override
    public int div(int num1, int num2) {
        // TODO Auto-generated method stub
        return num1/num2;
    }

}

最后再在Spring.xml中进行IOC的配置
#上传自github客户端
