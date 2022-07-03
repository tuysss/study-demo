import com.tuysss.dao.UserDao;
import com.tuysss.dao.UserDaoOracleImpl;
import com.tuysss.service.UserService;
import com.tuysss.service.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //获取applicationContext,Spring上下文容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //拿到Spring容器后，需要什么，就get什么
        UserService userService = (UserService)context.getBean("userServiceImpl");

        userService.getUser();

/*
        //用户调用的是业务层，无需接触dao层
        UserService userService=new UserServiceImpl();

        //控制反转IoC：控制权转移到用户手上
        //Test即模拟用户传入请求
        UserDao userDaoChosenByInput;
        userDaoChosenByInput=new UserDaoOracleImpl();

        ((UserServiceImpl) userService).setUser(userDaoChosenByInput);
        userService.getUser();
*/

    }
}
