package com.noscendo.authorize.model.api;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonResponse {

    private Long id;
    private String name;
    private String email;
}
