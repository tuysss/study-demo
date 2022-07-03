import com.tuysss.pojo.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void TestInit(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person p = context.getBean("p", Person.class);
        p.getCat().bark();
        p.getDog().bark();
        System.out.println(p);
    }
}
