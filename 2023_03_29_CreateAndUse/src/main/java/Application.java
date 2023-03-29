import com.beans.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-03-29
 * Time: 21:26
 */
public class Application {
    public static void main(String[] args) {
//        // 1.获取 spring 上下文对象
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
//
//        // 2.根据上下文对象提供的方法获取到 bean
//        // 以往的写法是通过 new 的, 但是经过IOC之后就不用了~
//        User user = (User) context.getBean("user");
//
//        // 3.使用 bean
//        user.sayHi("zhangsan");

        /**
         * 下面是第二种(从spring中获取bean的)写法: 使用 bean 工厂!
         * 这是一个非常经典的面试题! 探究它们之间的区别是什么?
         *     看磊哥上课的笔记!
         */

//        // 1.获取 bean 工厂
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring_config.xml"));
//
//        // 2.获取 bean
        User user = (User) factory.getBean("user");
//
//        // 3.使用bean
//        user.sayHi("lisi");

        /**
         * 从性能方面来说：ApplicationContext 是一次性加载并初始化所有的 Bean 对象，而 BeanFactory 是需要那个才去加载那个，
         *     因此更加轻量。
         *
         * 如何证明呢?看下面!!!
         *
         * 单独运行ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
         * 结果是:
         * 加载了User!
         * 加载了Article!
         *
         * 单独运行BeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring_config.xml"));
         * 没有发生任何事!
         *
         * 但是运行下面两段:
         * BeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring_config.xml"));
         * User user = (User) factory.getBean("user");
         * 结果是:
         * 加载了User!
         */
    }
}