import com.gmail.ggas.ui.command.LoginCommand;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LoginCommandTest {
    @Test
    public void loginWithFakeAccount(){
        LoginCommand loginCommandFake = new LoginCommand();
        List<String> paramsFakeAccount = new ArrayList<>();
        paramsFakeAccount.add("dadasd");
        paramsFakeAccount.add("dadad");
        String fakeResult;
        try {
            fakeResult = loginCommandFake.process(paramsFakeAccount).getResult();
            Assert.assertTrue(fakeResult.equals("Неверный логин или пароль"));
        }
        catch (Exception e){}


    }
}
