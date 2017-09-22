package com.kwler.legacy.api.metrics.repository;

import com.kwler.legacy.api.metrics.mapper.FactFanMapper;
import com.kwler.legacy.api.metrics.model.FactFan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class FactFanRepository {

    @Autowired
    FactFanMapper factFanMapper;

    public Page<FactFan> findByArtistAndDate(String artist, Integer date, Pageable pageable) {
        return factFanMapper.findFansByDateAndArtistId(date, artist, pageable).toPage(pageable);
    }
}
