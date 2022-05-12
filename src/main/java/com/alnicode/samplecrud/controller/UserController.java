package com.alnicode.samplecrud.controller;

import com.alnicode.samplecrud.dto.UserRequest;
import com.alnicode.samplecrud.dto.UserResponse;
import com.alnicode.samplecrud.service.ICrudService;
import com.alnicode.samplecrud.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends CrudController<UserRequest, UserResponse> {
    @Autowired
    private IUserService service;

    @Override
    protected ICrudService<UserRequest, UserResponse> service() {
        return this.service;
    }
    
}
