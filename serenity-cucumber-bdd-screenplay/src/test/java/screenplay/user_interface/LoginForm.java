package screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class LoginForm {
    public static Target FILL_USERNAME = Target.the("Fill user name")
            .locatedBy("#login-form > section > div:nth-child(2) > div.col-md-6 > input");
    public static Target FILL_PASSWORD = Target.the("Fill password")
            .locatedBy("#login-form > section > div:nth-child(3) > div.col-md-6 > div > input");
    public static Target SIGN_IN = Target.the("Submit login")
            .locatedBy("#submit-login");
}
