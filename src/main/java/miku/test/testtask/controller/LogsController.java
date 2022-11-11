package miku.test.testtask.controller;

import io.swagger.v3.oas.annotations.Operation;
import miku.test.testtask.entity.LogEntity;
import miku.test.testtask.service.LogsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LogsController {

    private final LogsService logsService;

    public LogsController(LogsService logsService) {
        this.logsService = logsService;
    }

    @PostMapping("/logs")
    @Operation(summary = "Сохранить лог")
    public void saveLog(@RequestBody @Valid LogEntity entity) {
        logsService.save(entity);
    }
}
