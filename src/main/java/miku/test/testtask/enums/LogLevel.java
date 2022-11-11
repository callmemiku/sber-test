package miku.test.testtask.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Log Level", description = "Допустимые уровни логгирования")
public enum LogLevel {

    @JsonProperty("INFO")
    INFO,
    @JsonProperty("DEBUG")
    DEBUG,
    @JsonProperty("ERROR")
    ERROR,
    @JsonProperty("TRACE")
    TRACE

}
