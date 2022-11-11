package miku.test.testtask.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

@Service
@Slf4j
public class CopyLogInFileServiceImpl implements CopyLogInFileService {

    @Value("${file-to-save}")
    private String logfilePath;

    private Path file;

    @PostConstruct
    public void init() {
        file = Path.of(logfilePath);
        File asFile = file.toFile();
        if (!asFile.exists()) {
            try {
                asFile.getParentFile().mkdirs();
                asFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Невозможно создать файл: " + e.getMessage());
            }
        }
    }

    @Override
    public void saveLogInFile(String json) {
        try {
            Files.writeString(file,
                    json + System.lineSeparator(),
                    CREATE, APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи лога в файл: " + e.getMessage());
        }
    }
}
