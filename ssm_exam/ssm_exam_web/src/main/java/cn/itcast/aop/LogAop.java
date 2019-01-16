package cn.itcast.aop;

import cn.itcast.pojo.SysLog;
import cn.itcast.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService sysLogService;

    private Date visiTime;
    private Class clazz;
    private Method method;

    //前置通知 主要是获取开始的时间,执行的类是哪一个,执行的是哪一个方法
    @After("execution(* cn.itcast.controller.*.*(..))")
    public void doBefore(JoinPoint jp) {
        try {
            visiTime = new Date();//当前开始的时间
            clazz = jp.getTarget().getClass();//具体要访问的类
            String methodName = jp.getSignature().getName();//获取访问的方法的名称
            Object[] args = jp.getArgs();//获取访问的方法的参数
            if (args == null || args.length == 0) {
                method = clazz.getMethod(methodName);
            } else {
                Class[] classArgs = new Class[args.length];
                for (int i = 0; i < args.length; i++) {
                    if (args[i] instanceof Model) {
                        classArgs[i] = Model.class;
                        continue;
                    }
                    classArgs[i] = args[i].getClass();
                }
                method = clazz.getMethod(methodName, classArgs);
            }
        } catch (Exception e) {
            System.out.println("***************" + e.getMessage());
        }
    }

    //后置通知
    @Before("execution(* cn.itcast.controller.*.*(..))")
    public void doAfter(JoinPoint jp) {
        try {
            long time = new Date().getTime() - visiTime.getTime();
            String url = "";
            if (clazz != null && method != null && clazz != LogAop.class) {
                //1.获取类上的@RequestMapping("/orders")
                RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
                if (classAnnotation != null) {
                    String[] classValue = classAnnotation.value();
                    //2.获取方法上的@RequesMapping(xxx)
                    RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                    if (methodAnnotation != null) {
                        String[] methodValue = methodAnnotation.value();
                        url = classValue[0] + methodValue[0];
                        //获取访问的id
                        String ip = request.getRemoteAddr();
                        //获取当前操作的用户
                        //可以通过securityContext获取,也可以从request,getSession中获取
                        SecurityContext context = SecurityContextHolder.getContext();
                        String username = ((User) (context.getAuthentication().getPrincipal())).getUsername();
                        //将日志相关信息封装到SysLog对象
                        SysLog sysLog = new SysLog();
                        sysLog.setExecutionTime(time);//执行时长
                        sysLog.setIp(ip);
                        sysLog.setMethod("[类名]" + clazz.getName() + "[方法名]" + method.getName());
                        sysLog.setUrl(url);
                        sysLog.setUsername(username);
                        sysLog.setVisitTime(visiTime);
                        sysLogService.saveSysLog(sysLog);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("**********" + e.getMessage());
        }
    }


}
