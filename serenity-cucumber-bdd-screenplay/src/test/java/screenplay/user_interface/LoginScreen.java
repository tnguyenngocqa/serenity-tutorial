package screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginScreen {

    public static Target CREATE_ACCOUNT_ELEMENT
            = Target.the("'No account? Create one here' link").located(By.cssSelector(".no-account"));
}
