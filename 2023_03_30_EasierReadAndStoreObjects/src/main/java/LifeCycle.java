import com.beans.life.BeanLife;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description: 探究生命周期
 * User: cbiltps
 * Date: 2023-04-01
 * Time: 15:37
 */
public class LifeCycle {
    public static void main(String[] args) {
        System.out.println("Bean的命周期: ");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
        BeanLife beanLife = context.getBean(BeanLife.class);
        beanLife.use();
        context.destroy();

//        System.out.println(9 / 10);
    }
}