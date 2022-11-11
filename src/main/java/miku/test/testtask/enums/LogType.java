package miku.test.testtask.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Log Type", description = "Допустимые типы логгирования")
public enum LogType {

    @JsonProperty("APPLICATION")
    APPLICATION,
    @JsonProperty("HTTP")
    HTTP,
    @JsonProperty("MESSAGING")
    MESSAGING

}
