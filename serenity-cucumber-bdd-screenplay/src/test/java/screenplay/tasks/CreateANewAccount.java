package screenplay.tasks;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import screenplay.model.ProfileInformation;
import screenplay.user_interface.RegistrationForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateANewAccount implements Task {
    private ProfileInformation profileInformation;

    public static CreateANewAccount with(DataTable profileTable) {
        return instrumented(CreateANewAccount.class, profileTable);
    }

    @Override
    @Step("{0} creates a new account")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(RegistrationForm.SOCIAL_TITLE.of("Mr.")),
                Enter.theValue("profile().getFirstName()").into(RegistrationForm.FIRST_NAME),
                Enter.theValue("profile().getLastName()").into(RegistrationForm.LAST_NAME),
                Enter.theValue("profile().getEmail()").into(RegistrationForm.EMAIL),
                Enter.theValue("profile().getPassword()").into(RegistrationForm.PASSWORD)
        );
    }

    public CreateANewAccount(DataTable profileTable) {


        this.profileInformation = new ProfileInformation();
    }

    private void convertDataTableToMap(){

    }
}
