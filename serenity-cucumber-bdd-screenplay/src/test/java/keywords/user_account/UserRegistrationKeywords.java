package keywords.user_account;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import screenplay.tasks.CreateANewAccount;
import screenplay.tasks.GoToRegistrationForm;
import screenplay.tasks.Start;

public class UserRegistrationKeywords {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that (.*) is a new online customer$")
    public void user_is_a_new_online_customer(String actor) {
        OnStage.theActorCalled(actor).wasAbleTo(
                Start.prepareToSignIn(),
                GoToRegistrationForm.called()
        );
    }

    @When("^(?:he|she) create a new account with information$")
    public void user_create_a_new_account_with_information(DataTable profileInformation) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CreateANewAccount.with(profileInformation)
        );
    }
}
