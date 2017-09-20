package com.kwler.legacy.api.metrics.model.internal;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * DTO for handling mapper result.
 * currently MyBatis does not support
 * constructor injection of collections,
 * so we are stuck with this workaround
 * @param <T>
 */
@Data
@NoArgsConstructor
public class PartialResult<T> {

    Long count;
    List<T> contents;

    public Page<T> toPage(Pageable pageable) {
        return new PageImpl<>(this.contents, pageable, this.count);
    }
}
