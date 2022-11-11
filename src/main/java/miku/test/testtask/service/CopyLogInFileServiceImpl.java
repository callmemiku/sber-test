package miku.test.testtask.service;

import lombok.extern.slf4j.Slf4j;
import miku.test.testtask.entity.LogEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;

import static java.nio.file.StandardOpenOption.APPEND;

@Service
@Slf4j
public class CopyLogInFileServiceImpl implements CopyLogInFileService {

    @Value("${logging.file.name}")
    private String logfilePath;

    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    private Path file;

    @PostConstruct
    public void init() {
        file = Path.of(logfilePath);
    }

    @Override
    public void saveLogInFile(LogEntity entity) {
        String message = String.format("%s\t%s\t%s: %s",
                dateFormat.format(entity.getTimestamp()),
                entity.getLevel(), entity.getType(), entity.getMessage());
        try {
            Files.writeString(file,
                    message + System.lineSeparator(),
                    APPEND);
        } catch (IOException e) {
            log.error("Ошибка при записи лога в файл");
        }
    }
}
