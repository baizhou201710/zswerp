package com.zsw.base;

import com.zsw.sys.entity.Log;
import com.zsw.sys.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 日志处理
 *
 * @author baizhou
 * @create 2017-11-16 14:19
 */
@Aspect
public class LogAopAction {
    //注入service,用来将日志信息保存在数据库
    @Resource(name = "logService")
    private LogService logService;

    //配置接入点,如果不知道怎么配置,可以百度一下规则
    @Pointcut("execution(* com.zsw.*.controller..*.*(..))")
    private void controllerAspect() {
    }//定义一个切入点

    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //常见日志实体对象
        Log log = new Log();
        //获取登录用户账户
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String name = (String) request.getSession().getAttribute("USER_ID");
        log.setUserName(name);
        //获取系统时间
        //String time = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
        log.setCreateTime(new Date());

        //获取系统ip,这里用的是我自己的工具类,可自行网上查询获取ip方法
        String ip = "127.0.0.1";//GetLocalIp.localIp();
        log.setIp(ip);

        //方法通知前获取时间,为什么要记录这个时间呢？当然是用来计算模块执行时间的
        long start = System.currentTimeMillis();
        // 拦截的实体类，就是当前正在执行的controller
        Object target = pjp.getTarget();
        // 拦截的方法名称。当前正在执行的方法
        String methodName = pjp.getSignature().getName();
        // 拦截的方法参数
        Object[] args = pjp.getArgs();
        // 拦截的放参数类型
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Class[] parameterTypes = msig.getMethod().getParameterTypes();

        Object object = null;
        // 获得被拦截的方法
        Method method = null;
        try {
            method = target.getClass().getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (SecurityException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        if (null != method) {
            // 判断是否包含自定义的注解，说明一下这里的SystemLog就是我自己自定义的注解
            if (method.isAnnotationPresent(SystemLog.class)) {
                SystemLog systemlog = method.getAnnotation(SystemLog.class);
                log.setModule(systemlog.module());
                log.setMethod(systemlog.method());
                try {
                    object = pjp.proceed();
                    long end = System.currentTimeMillis();
                    //将计算好的时间保存在实体中
                    log.setResponseTime((end - start));
                    log.setResult(ErpConstants.RESULT_SUCCESS);
                    //保存进数据库
                    logService.save(log);
                } catch (Throwable e) {
                    // TODO Auto-generated catch block
                    long end = System.currentTimeMillis();
                    log.setResponseTime(end - start);
                    log.setResult(ErpConstants.RESULT_FAILURE);
                    logService.save(log);
                }
            } else {//没有包含注解
                object = pjp.proceed();
            }
        } else { //不需要拦截直接执行
            object = pjp.proceed();
        }
        return object;
    }
}
