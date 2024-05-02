package transformation;

import constants.Cards;
import io.cucumber.java.ParameterType;

public class Transformations {
    @ParameterType("LOGIN|INTERESTS|DETAILS")
    public Cards cards(String card) {
        return Cards.valueOf(card);
    }
}
