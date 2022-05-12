package com.alnicode.samplecrud.mapper;

import java.util.ArrayList;
import java.util.List;

import com.alnicode.samplecrud.dto.UserRequest;
import com.alnicode.samplecrud.dto.UserResponse;
import com.alnicode.samplecrud.entity.User;

import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements IUserMapper {

    @Override
    public UserResponse toResponse(User entity) {
        if (entity.getId() == null) {
            return null;
        }

        var response = new UserResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());

        return response;
    }

    @Override
    public List<UserResponse> toResponses(List<User> entities) {
        if (entities == null) {
            return null;
        }

        List<UserResponse> responses = new ArrayList<>(entities.size());
        
        entities.forEach(entity -> responses.add(this.toResponse(entity)));

        return responses;
    }

    @Override
    public User toEntity(UserRequest request) {
        if (request == null) {
            return null;
        }

        var entity = new User();
        entity.setName(request.getName());

        return entity;
    }
    
}
