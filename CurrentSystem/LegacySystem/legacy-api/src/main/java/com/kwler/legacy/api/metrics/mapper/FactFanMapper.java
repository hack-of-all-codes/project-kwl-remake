package com.kwler.legacy.api.metrics.mapper;

import com.kwler.legacy.api.metrics.model.FactFan;
import com.kwler.legacy.api.metrics.model.internal.PartialResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface FactFanMapper {

    @Select("SELECT * FROM fact_fans WHERE date_id = #{date} LIMIT #{limit}")
    List<FactFan> findByDate(@Param("date") Integer date, @Param("limit") Integer limit);

    @Select("SELECT * FROM fact_fans WHERE date_id = #{date} LIMIT #{limit}")
    List<Map<String, Object>> findByDateM(@Param("date") Integer date, @Param("limit") Integer limit);

    PartialResult<FactFan> findFansByDateAndArtistId(
            @Param("date") Integer date,
            @Param("artist") String artistId,
            @Param("page") Pageable page);
}
