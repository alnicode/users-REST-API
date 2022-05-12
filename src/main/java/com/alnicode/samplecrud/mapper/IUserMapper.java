package com.alnicode.samplecrud.mapper;

import com.alnicode.samplecrud.dto.UserRequest;
import com.alnicode.samplecrud.dto.UserResponse;
import com.alnicode.samplecrud.entity.User;

public interface IUserMapper extends IBaseMapper<User, UserRequest, UserResponse> {
    
}
