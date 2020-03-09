package screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class RegistrationForm {
    public static Target SOCIAL_TITLE
            = Target.the("The Social Title radio button")
            .locatedBy("//*[@class='radio-inline' and contains(.,'{0}')]/span/input");

    public static Target FIRST_NAME
            = Target.the("")
            .locatedBy("//input[@name='firstname']");

    public static Target LAST_NAME
            = Target.the("")
            .locatedBy("//input[@name='lastname']");

    public static Target EMAIL
            = Target.the("")
            .locatedBy("//input[@name='email']");

    public static Target PASSWORD
            = Target.the("")
            .locatedBy("//input[@name='password']");
}
