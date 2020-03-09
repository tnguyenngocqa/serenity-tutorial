package keywords.user_account;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import screenplay.abilities.Authenticate;
import screenplay.questions.UserAccount;
import screenplay.tasks.LogIn;
import screenplay.tasks.Start;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.ConsequenceMatchers.displays;
import static org.hamcrest.Matchers.equalTo;


public class UserLoginKeywords {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that (.*) is a registered (?:member|admin)$")
    public void user_is_a_registered_member(String actor) {
        OnStage.theActorCalled(actor).wasAbleTo(Start.prepareToSignIn());
    }

    @When("^(?:he|she|they|Byron) logs in with valid credentials$")
    public void user_has_signed_in_with_their_account(DataTable credentialsTableData) {
        OnStage.theActorInTheSpotlight()
                .whoCan(Authenticate.with(credentialsTableData))
                .attemptsTo(LogIn.withCredentials());
    }

    @Then("^(?:he|she|they|Byron) should be able to view (?:his|her) account profile$")
    public void sheShouldBeAbleToViewHerAccountProfile() {
        OnStage.theActorInTheSpotlight()
                .should(seeThat(UserAccount.loaded(),
                        displays("title", equalTo("My account"))));
    }
}
