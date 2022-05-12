package com.alnicode.samplecrud.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserRequest {
    @NotBlank
    private String name;
}
