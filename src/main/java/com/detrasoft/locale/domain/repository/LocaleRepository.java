package com.detrasoft.locale.domain.repository;

import com.detrasoft.framework.crud.repositories.GenericCRUDRepository;
import com.detrasoft.locale.domain.entities.Locale;

import java.util.List;

public interface LocaleRepository extends GenericCRUDRepository<Locale> {
    List<Locale> findByIdIn(List<Long> idList);
}
