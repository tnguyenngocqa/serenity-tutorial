package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import screenplay.user_interface.LoginScreen;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class GoToRegistrationForm implements Task {

    @Step("Go to the Registration Form")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LoginScreen.CREATE_ACCOUNT_ELEMENT)

        );
    }

    public static GoToRegistrationForm called() {
        return instrumented(GoToRegistrationForm.class);
    }
}
