import java.beans.Introspector;

/**
 * Created with IntelliJ IDEA.
 * Description: 看一下 Introspector.decapitalize(); 的效果!
 * User: cbiltps
 * Date: 2023-03-30
 * Time: 14:44
 */
public class NameVerification {
    public static void main(String[] args) {
//        String className = "UserContoller";
        String className = "APIContoller";
        System.out.println(Introspector.decapitalize(className));
    }
}
