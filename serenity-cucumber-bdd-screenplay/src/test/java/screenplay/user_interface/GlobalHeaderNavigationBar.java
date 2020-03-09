package screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;
import screenplay.model.RunEnvironment;

public class GlobalHeaderNavigationBar {

    private static Target GET_LOGIN_SCREEN = Target.the("Desktop Sign In Button")
            .locatedBy("#_desktop_user_info > div > a");

    public static Target getLoginScreen() {

        if (RunEnvironment.ofValue() == RunEnvironment.Mobile) {
            GET_LOGIN_SCREEN = Target.the("Mobile Sign In Button")
                    .locatedBy("#_mobile_user_info > div > a");
        }

        return GET_LOGIN_SCREEN;
    }
}
