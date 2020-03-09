package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import screenplay.user_interface.GlobalHeader;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchAnItem implements Task {
    private final String keyword;

    public static SearchAnItem with(String keyword) {
        return instrumented(SearchAnItem.class, keyword);
    }

    @Override
    @Step("Search an item")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(keyword)
                        .into(GlobalHeader.SEARCH_BAR)
                        .thenHit(Keys.ENTER)
        );
    }

    public SearchAnItem(String keyword) {
        this.keyword = keyword;
    }
}
