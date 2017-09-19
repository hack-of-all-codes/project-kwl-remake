package com.kwler.legacy.api.metrics.mapper;

import com.kwler.legacy.api.metrics.model.FactFans;
import com.kwler.legacy.api.metrics.model.ArtistResults;
import org.apache.ibatis.annotations.*;
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

//    @Results({
//            @Result(property = "totalCount", column = "totalCount"),
//            @Result(property = "artists.id", column = "artists_id"),
//            @Result(property = "artists.name", column = "artists_name")
//    })
//    @ResultMap()
//    @Select("SELECT count(*) OVER() AS totalCount, id AS artists_id, name AS artists_name FROM dim_artist LIMIT 10")
    ArtistResults findArtists(@Param("limit") Integer limit);

}
