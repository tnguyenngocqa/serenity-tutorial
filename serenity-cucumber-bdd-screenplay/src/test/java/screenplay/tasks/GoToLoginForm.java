package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import screenplay.user_interface.GlobalHeaderNavigationBar;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoToLoginForm implements Task {
    @Step("Go to the Login Form")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(GlobalHeaderNavigationBar.getLoginScreen())
        );
    }

    public static Task called() {
        return instrumented(GoToLoginForm.class);
    }
}
