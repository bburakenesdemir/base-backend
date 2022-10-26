package com.burakenesdemir.basebackend.mapper;

import com.burakenesdemir.basebackend.model.dto.UserDTO;
import com.burakenesdemir.basebackend.model.mongo.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User registerDtoToUser(UserDTO.RegisterDto registerDto);
}
