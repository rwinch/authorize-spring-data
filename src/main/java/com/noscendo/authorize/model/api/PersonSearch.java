package com.noscendo.authorize.model.api;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.List;

@Builder
@Data
public class PersonSearch {

    private String name;
    private int pageNumber;
    private int pageSize;
    private List<OrderBy> orders;

    @Builder
    @Data
    public static class OrderBy {
        private String property;
        private Sort.Direction direction;
    }
}
