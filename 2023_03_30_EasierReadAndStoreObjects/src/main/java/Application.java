import com.beans.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-03-30
 * Time: 01:36
 */
public class Application {
    public static void main(String[] args) {

        // 1.先得到上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
//        // 2.得到 bean
//        UserController controller = context.getBean("userController", UserController.class);// 用小驼峰就可以找到对应的对象
//        // 3.使用 bean
//        controller.sayHi();

        /**
         * 有的时候类名命名的时候是这样的:APIController
         * 我们在getBean的时候用"aPIController"找是找不到的?
         * 用"APIController"却又找到了?
         * 前面不是说用小驼峰是可以找的吗?
         * 这是为什么? 我们只能看看源代码!去寻找一些蛛丝马迹!
         * 找到对应的代码如下:
         *     public static String decapitalize(String name) {
         *         if (name == null || name.length() == 0) {
         *             return name;
         *         }
         *         if (name.length() > 1 && Character.isUpperCase(name.charAt(1)) &&
         *                         Character.isUpperCase(name.charAt(0))){
         *             return name;
         *         }
         *         char chars[] = name.toCharArray();
         *         chars[0] = Character.toLowerCase(chars[0]);
         *         return new String(chars);
         *     }
         *
         * 注意: spring生成beanName的规格不是spring的, 而是jdk自身的!
         */
//        APIController apiController = context.getBean("aPIController", APIController.class);// error
        APIController apiController = context.getBean("APIController", APIController.class);
        apiController.sayHi();



//        UserService userService = context.getBean(UserService.class);
//        userService.sayHi();

//        UserRepository repository = context.getBean(UserRepository.class);
//        repository.sayHi();

//        UserConfig config = context.getBean(UserConfig.class);
//        config.sayHi();

//        UserComponent component = context.getBean(UserComponent.class);
//        component.sayHi();
    }
}
