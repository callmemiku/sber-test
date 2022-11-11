package miku.test.testtask.repository;

import miku.test.testtask.entity.LogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LogMapper {

    void saveLog(@Param("entity") LogEntity entity);
}
