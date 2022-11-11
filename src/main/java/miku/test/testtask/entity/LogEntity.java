package miku.test.testtask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import miku.test.testtask.enums.LogLevel;
import miku.test.testtask.enums.LogType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Data
public class LogEntity {

    @JsonIgnore
    private Long id;
    @NotBlank
    private String message;
    @NotNull
    private LogType type;
    @NotNull
    private LogLevel level;

    private OffsetDateTime timestamp;

    public LogEntity(String message, LogType type, LogLevel level, OffsetDateTime timestamp) {
        this.message = message;
        this.type = type;
        this.level = level;
        this.timestamp = timestamp == null ? OffsetDateTime.now() : timestamp;
    }
}
