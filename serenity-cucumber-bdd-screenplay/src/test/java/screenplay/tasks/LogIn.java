package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import screenplay.abilities.Authenticate;
import screenplay.user_interface.LoginForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LogIn implements Task {
    @Override
    @Step("{0} logs in the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(authenticated(actor).username())
                        .into(LoginForm.FILL_USERNAME),
                Enter.theValue(authenticated(actor).password())
                        .into(LoginForm.FILL_PASSWORD),
                Click.on(LoginForm.SIGN_IN)
        );
    }

    public static LogIn withCredentials() {
        return instrumented(LogIn.class);
    }

    private Authenticate authenticated(Actor actor) {
        return Authenticate.as(actor);
    }
}
