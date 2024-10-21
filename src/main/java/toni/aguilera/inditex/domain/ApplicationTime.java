package toni.aguilera.inditex.domain;
import java.time.LocalDateTime;

public class ApplicationTime {
    private final LocalDateTime value;

    public LocalDateTime getValue() {
        return value;
    }

    public ApplicationTime(String value) {
        this.value = LocalDateTime.parse(value);
    }
}
