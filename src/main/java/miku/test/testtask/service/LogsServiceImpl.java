package miku.test.testtask.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import miku.test.testtask.entity.LogEntity;
import miku.test.testtask.repository.LogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@Service
@Slf4j
public class LogsServiceImpl implements LogsService {

    private final LogMapper mapper;
    private final CopyLogInFileService logInFileService;
    private final ObjectMapper objectMapper;

    public LogsServiceImpl(LogMapper mapper, CopyLogInFileService logInFileService, ObjectMapper objectMapper) {
        this.mapper = mapper;
        this.logInFileService = logInFileService;
        this.objectMapper = objectMapper;
    }

    @Override
    @Transactional
    public void save(LogEntity entity) {
        String json;
        OffsetDateTime dateTime = convertToOffsetDateTime(entity.getTime());
        try {
            json = objectMapper.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Невозможно сконвертировать entity в JSON");
        }
        mapper.saveLog(entity, dateTime, json);
        logInFileService.saveLogInFile(json);
    }

    private OffsetDateTime convertToOffsetDateTime(Long timestamp) {
        final ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = new Timestamp(timestamp).toLocalDateTime();
        ZoneOffset zoneOffSet = zone.getRules().getOffset(localDateTime);
        return localDateTime.atOffset(zoneOffSet);
    }
}
