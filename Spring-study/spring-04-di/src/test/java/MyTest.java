import com.tuysss.pojo.Student;
import com.tuysss.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("s");
        System.out.println(student);
    }

    @Test
    public void TestPNamespace(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User u = context.getBean("user", User.class);
        System.out.println(u);
    }
    @Test
    public void TestCNamespace(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User u = context.getBean("user2", User.class);
        System.out.println(u);
    }
}
