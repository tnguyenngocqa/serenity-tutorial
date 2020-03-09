import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {
                //"src/test/resources/features/user_account/create_online_customer_account.feature",
                "src/test/resources/features/search/search_for_an_item.feature"
        },
        plugin = {"pretty"},
        tags = {"@smoke"}
)
public class CucumberTestSuite {
}
