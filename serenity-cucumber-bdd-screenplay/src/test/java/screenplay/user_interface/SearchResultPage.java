package screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class SearchResultPage {
    public static Target SEARCH_RESULTS_GRID = Target.the("Search results grid")
            .locatedBy("#products");
}
