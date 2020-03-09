package keywords.search;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import screenplay.questions.SearchResult;
import screenplay.tasks.NavigateMenu;
import screenplay.tasks.SearchAnItem;
import screenplay.tasks.Start;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static screenplay.questions.ElementAvailability.Available;


public class SearchItemKeywords {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that (.*) wants to buy (?:Sweater|an item)$")
    public void user_wants_to_buy_an_item(String actor) {
        OnStage.theActorCalled(actor).wasAbleTo(Start.readyToSearch());
    }

    @When("^s?he searches for Sweater using the navigate menu$")
    public void user_searches_for_an_item_using_the_navigate_menu() {
        OnStage.theActorInTheSpotlight().attemptsTo(NavigateMenu.toBlousesItem());
    }

    @When("^s?he searches for keyword (.*)$")
    public void user_searches_for_keyword(String keyword) {
        OnStage.theActorInTheSpotlight().attemptsTo(SearchAnItem.with(keyword));
    }

    @Then("^s?he should see the list of (.*) with prices available for sale$")
    public void user_should_see_the_list_of_items_with_prices_available_for_sale() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(SearchResult.resultsGrid(), is(Available)),
                seeThat(SearchResult.checkForTitle(), containsString("product")),
                seeThat(SearchResult.price(), is(Available))
        );
    }
}
