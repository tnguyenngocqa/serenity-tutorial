package screenplay.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Refresh implements Interaction {
    public static Refresh theBrowserSession() {
        return instrumented(Refresh.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().manage().deleteAllCookies();
    }
}
