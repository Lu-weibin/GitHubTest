/**
 * Created by luwb on 2020/05/22.
 */
public class InitialContext {
    public Object lookup(String jndiName){
        if("SERVICE1".equalsIgnoreCase(jndiName)){
            System.out.println("Looking up and creating a new Service1 object");
            return new Service1();
        }else if ("SERVICE2".equalsIgnoreCase(jndiName)){
            System.out.println("Looking up and creating a new Service2 object");
            return new Service2();
        }
        return null;
    }
}
