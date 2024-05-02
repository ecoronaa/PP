package constants;

import lombok.Getter;

@Getter
public enum Cards {
    LOGIN(1),
    INTERESTS(2),
    DETAILS(3);

    private final int value;

    Cards(int value) {
        this.value = value;
    }
}
