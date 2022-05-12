package com.alnicode.samplecrud.mapper;

import java.util.List;

public interface IBaseMapper<Entity, Request, Response> {
    Response toResponse(Entity entity);
    List<Response> toResponses(List<Entity> entities);
    Entity toEntity(Request request);
}
