package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Visibility;
import screenplay.user_interface.SearchResultPage;

import static net.serenitybdd.screenplay.questions.ValueOf.the;

@Subject("the 'Search Result' view")
public class SearchResultsGrid implements Question<ElementAvailability> {
    @Override
    public ElementAvailability answeredBy(Actor actor) {
        return ElementAvailability.from(
                the(
                        Visibility.of(SearchResultPage.SEARCH_RESULTS_GRID)
                                .viewedBy(actor)
                )
        );
    }
}
