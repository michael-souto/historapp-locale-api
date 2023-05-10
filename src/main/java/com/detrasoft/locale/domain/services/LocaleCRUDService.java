package com.detrasoft.locale.domain.services;

import com.detrasoft.framework.crud.services.crud.GenericCRUDService;
import com.detrasoft.locale.domain.entities.Locale;
import com.detrasoft.locale.domain.repository.LocaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class LocaleCRUDService  extends GenericCRUDService<Locale> {

    @Autowired
    public LocaleCRUDService(LocaleRepository repository) {
        super(repository);
    }

    @Override
    protected void beforeInsert(Locale entity) {
        beforeSave(entity);
        entity.setCreateAt(Instant.now());
        super.beforeInsert(entity);
    }

    @Override
    public void beforeUpdate(Locale entity) {
        beforeSave(entity);
        entity.setUpdateAt(Instant.now());
        super.beforeUpdate(entity);
    }

    protected void beforeSave(Locale entity) {

    }
}
