import model.Login;
import org.junit.Test;

public class TestModel {

    @Test

    public void testLogin(){
        Login log = new Login();
        log.verifyCredentials("tatto","1234");
    }

}
