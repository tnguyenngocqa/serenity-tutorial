package screenplay.abilities;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import screenplay.exceptions.CannotAuthenticateException;

import java.util.List;
import java.util.Map;

public class Authenticate implements Ability {

    private final String username;
    private final String password;

    public Authenticate(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Authenticate with(DataTable credentialsTableData) {
        // Convert the table data to map
        // ----------------------------------------------------------------------
        // credentialsMapList = [{username=carla_the_online_customer@getnada.com, password=password}]
        // credentialsData =     {username=carla_the_online_customer@getnada.com, password=password}
        // ----------------------------------------------------------------------
        int firstCredentialIndex = 0;
        List<Map<String, String>> credentialsMapList = credentialsTableData.asMaps(String.class, String.class);
        Map<String, String> credentialsData = credentialsMapList.get(firstCredentialIndex);

        return new Authenticate(credentialsData.get("username"), credentialsData.get("password"));
    }

    public static Authenticate as(Actor actor) {

        if (actor.abilityTo(Authenticate.class) == null) {
            throw new CannotAuthenticateException(actor.getName());
        }

        return actor.abilityTo(Authenticate.class);
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }
}
