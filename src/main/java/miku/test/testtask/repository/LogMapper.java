package miku.test.testtask.repository;

import miku.test.testtask.entity.LogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

@Mapper
@Repository
public interface LogMapper {

    void saveLog(@Param("entity") LogEntity entity, @Param("time")OffsetDateTime time, @Param("json") String json);
}
