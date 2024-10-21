package toni.aguilera.inditex.domain;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class ApplicationTime {
    private final Timestamp value;

    public Timestamp getValue() {
        return value;
    }

    public ApplicationTime(String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.value = Timestamp.valueOf(formatter.format(LocalDateTime.parse(value)));
    }
}
