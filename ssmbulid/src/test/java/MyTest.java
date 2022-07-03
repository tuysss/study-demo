import com.tuysss.pojo.Books;
import com.tuysss.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService service = (BookService)context.getBean("BookServiceImpl");
        for (Books books : service.queryAllBook()) {
            System.out.println(books);
        }
    }
}
