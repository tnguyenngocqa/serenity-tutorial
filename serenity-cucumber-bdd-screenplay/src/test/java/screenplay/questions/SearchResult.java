package screenplay.questions;

import net.serenitybdd.screenplay.Question;

public class SearchResult {

    public static Question<ElementAvailability> resultsGrid() {
        return new SearchResultsGrid();
    }

    public static Question<String> checkForTitle() {
        return new SearchResultResponseTitle();
    }

    public static Question<ElementAvailability> price() {
        return new SearchResults;
    }
}
