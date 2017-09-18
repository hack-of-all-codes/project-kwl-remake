package com.kwler.legacy.api.metrics.repository;

import com.kwler.legacy.api.metrics.model.FactFans;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface FactFansMapper {

    @Select("SELECT * FROM fact_fans WHERE date_id = #{date} LIMIT #{limit}")
    List<FactFans> findByDate(@Param("date") Integer date, @Param("limit") Integer limit);

    @Select("SELECT * FROM fact_fans WHERE date_id = #{date} LIMIT #{limit}")
    List<Map<String, Object>> findByDateM(@Param("date") Integer date, @Param("limit") Integer limit);
}
