package com.alnicode.samplecrud.service.impl;

import java.util.Optional;

import com.alnicode.samplecrud.dto.UserRequest;
import com.alnicode.samplecrud.dto.UserResponse;
import com.alnicode.samplecrud.entity.User;
import com.alnicode.samplecrud.mapper.IBaseMapper;
import com.alnicode.samplecrud.mapper.IUserMapper;
import com.alnicode.samplecrud.repository.IUserRepository;
import com.alnicode.samplecrud.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CrudServiceImpl<User, UserRequest, UserResponse> implements IUserService {
    @Autowired
    private IUserMapper mapper;

    @Autowired
    private IUserRepository repository;

    @Override
    public Optional<UserResponse> update(long id, UserRequest request) {
        if (!this.repository.existsById(id)) {
            return Optional.empty();
        }

        var entity = this.mapper.toEntity(request);
        entity.setId(id);

        return Optional.of(this.mapper.toResponse(this.repository.save(entity)));
    }

    @Override
    protected CrudRepository<User, Long> repository() {
        return this.repository;
    }

    @Override
    protected IBaseMapper<User, UserRequest, UserResponse> mapper() {
        return this.mapper;
    }
    
}
