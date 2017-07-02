package LetvMemberShipInfoProcessor.LetvMemberShipInfoProcessor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.letv.backend.Bean;
import com.letv.backend.dao.TestDao;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        final ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");

        context.start();
        Bean bean = (Bean) context.getBean("bean");
        TestDao dao = (TestDao) context.getBean("testDao");
        System.out.println(dao.get().getAppName());

        System.out.println(bean);
        synchronized (App.class) {
            try {
                App.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
