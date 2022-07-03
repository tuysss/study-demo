import com.tuysss.pojo.User;
import com.tuysss.pojo.UserT;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void TestConstructorWithParas(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User)context.getBean("jkhlxisb");
        user.show();
    }

    @Test
    public void TestBeanConfig(){
        //Test: 1.bean中别名  2.一次加载，全部实现
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserT userT =(UserT) context.getBean("tt");
        System.out.println(userT.getName());
    }
}
