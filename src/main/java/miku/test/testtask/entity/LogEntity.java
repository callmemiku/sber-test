package miku.test.testtask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import miku.test.testtask.enums.LogLevel;
import miku.test.testtask.enums.LogType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class LogEntity {

    @JsonIgnore
    private Long id;
    @NotBlank
    private String message;
    @NotNull
    private LogType type;
    @NotNull
    private LogLevel level;
    @NotNull
    private Long time;
}
