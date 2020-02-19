import com.gmail.ggas.ui.command.Command;
import com.gmail.ggas.ui.command.CommandResult;
import com.gmail.ggas.ui.command.ShowAdminActionsCommand;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShowAdminActionCommandTest {
    @Test
    public void processTestWithUnexpectedCase(){
        ShowAdminActionsCommand showAdminActionCommandTest = new ShowAdminActionsCommand();
        List<String> params = new ArrayList<>();
        params.add("100");
        CommandResult commandResult = new CommandResult(new ShowAdminActionsCommand());
        CommandResult commandResultActual = showAdminActionCommandTest.process(params);
        Assert.assertEquals(commandResultActual.getCommand().getClass(),commandResult.getCommand().getClass());

    }
}
