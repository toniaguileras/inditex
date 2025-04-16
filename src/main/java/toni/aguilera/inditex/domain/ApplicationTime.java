package toni.aguilera.inditex.domain;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class ApplicationTime {
    private final LocalDateTime value;

    public LocalDateTime getValue() {
        return value;
    }

    public ApplicationTime(String value) {
        try {
            this.value = LocalDateTime.parse(value);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException();
        }
    }

    public ApplicationTime(LocalDateTime value) {
        this.value = value;
    }

    public String format() {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return this.value.format(formatter);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationTime that = (ApplicationTime) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
