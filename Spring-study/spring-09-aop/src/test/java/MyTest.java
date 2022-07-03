import com.tuysss.service.UserService;
import com.tuysss.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void Test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Error: 动态代理代理的是一个接口，返回类型不应设置为实现类
        UserService userService =(UserService) context.getBean("userService");
        userService.add();
    }

}
