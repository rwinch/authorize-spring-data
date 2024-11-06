package com.noscendo.authorize.model.api;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonRequest {

    private String name;
    private String email;
}
