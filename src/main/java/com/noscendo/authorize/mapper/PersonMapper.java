package com.noscendo.authorize.mapper;

import com.noscendo.authorize.model.api.PersonRequest;
import com.noscendo.authorize.model.api.PersonResponse;
import com.noscendo.authorize.model.dao.Person;
import org.mapstruct.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface PersonMapper {

    @ToPerson
    Person create(PersonRequest request);

    @ToPerson
    Person update(PersonRequest request, @MappingTarget Person person);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @ToPerson
    Person patch(PersonRequest request, @MappingTarget Person person);

    PersonResponse retrieve(Person person);

    @Mapping(target = "id", ignore = true)
    @Retention(RetentionPolicy.CLASS)
    @interface ToPerson {
    }
}
