package toni.aguilera.inditex.domain;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApplicationTime {
    private final LocalDateTime value;

    public LocalDateTime getValue() {
        return value;
    }

    public ApplicationTime(String value) {
        this.value = LocalDateTime.parse(value);
    }

    public ApplicationTime(LocalDateTime value) {
        this.value = value;
    }

    public String format() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return this.value.format(formatter);
    }
}
