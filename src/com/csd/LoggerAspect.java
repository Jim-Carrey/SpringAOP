package com.csd;

@Aspect
@Component
public class LoggerAspect {

    @Before("execution(public int com.southwind.aspect.CalImpl.*(..))")
    public void before(JoinPoint joinPoint){
        //获取方法名
        String name = joinPoint.getSignature().getName();
        //获取参数列表
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(name+"的参数是:"+args);
    }

    @After("execution(public int com.southwind.aspect.CalImpl.*(..))")
    public void after(JoinPoint joinPoint){
        //获取方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法结束");
    }

    @AfterReturning(value="execution(public int com.southwind.aspect.CalImpl.*(..))",returning="result")
    public void afterReturn(JoinPoint joinPoint,Object result){
        //获取方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法的结果是"+result);
    }

    @AfterThrowing(value="execution(public int com.southwind.aspect.CalImpl.*(..))",throwing="ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        //获取方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法抛出异常："+ex);
    }

}