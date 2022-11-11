package miku.test.testtask.service;

import lombok.extern.slf4j.Slf4j;
import miku.test.testtask.entity.LogEntity;
import miku.test.testtask.repository.LogMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogsServiceImpl implements LogsService {

    private final LogMapper mapper;
    private final CopyLogInFileService logInFileService;

    public LogsServiceImpl(LogMapper mapper, CopyLogInFileService logInFileService) {
        this.mapper = mapper;
        this.logInFileService = logInFileService;
    }

    @Override
    public void save(LogEntity entity) {
        log.debug("Сохраняю лог: {} @ {}", entity.getMessage(), entity.getLevel());
        mapper.saveLog(entity);
        logInFileService.saveLogInFile(entity);
        log.debug("Сохранен лог: {} @ {}", entity.getMessage(), entity.getLevel());
    }
}
