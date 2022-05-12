package com.alnicode.samplecrud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.alnicode.samplecrud.mapper.IBaseMapper;
import com.alnicode.samplecrud.service.ICrudService;

import org.springframework.data.repository.CrudRepository;

public abstract class CrudServiceImpl<Entity, Request, Response> implements ICrudService<Request, Response> {
    protected abstract CrudRepository<Entity, Long> repository();
    protected abstract IBaseMapper<Entity, Request, Response> mapper();

    @Override
    public Response create(Request request) {
        return this.mapper().toResponse(this.repository().save(this.mapper().toEntity(request)));
    }

    @Override
    public boolean delete(long id) {
        try {
            this.repository().deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Optional<Response> get(long id) {
        return this.repository().findById(id).map(mapper()::toResponse);
    }

    @Override
    public List<Response> getAll() {
        return this.mapper().toResponses((ArrayList<Entity>) this.repository().findAll());
    }
    
}
