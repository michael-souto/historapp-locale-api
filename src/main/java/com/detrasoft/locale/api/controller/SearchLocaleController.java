package com.detrasoft.locale.api.controller;

import com.detrasoft.locale.api.assemblers.LocaleAssembler;
import com.detrasoft.locale.api.dtos.LocaleDTO;
import com.detrasoft.locale.domain.entities.Locale;
import com.detrasoft.locale.domain.repository.LocaleRepository;
import com.detrasoft.locale.domain.specifications.LocaleSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RestController
@RequestMapping(value = "/locale/search")
public class SearchLocaleController {
    @Autowired
    private LocaleRepository _localeRepository;

    @Autowired
    private LocaleAssembler _localeAssembler;

    @GetMapping(value = "")
    public ResponseEntity<Page<LocaleDTO>> search(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "comments", required = false) String comments,
            @RequestParam(name = "tag", required = false) String tag,
            Pageable pageable) {
        Page<Locale> list = _localeRepository.findAll(
                LocaleSpecs.byName(name)
                        .and(LocaleSpecs.byComments(comments))
                        .and(LocaleSpecs.byTag(tag)), pageable);

        Page<LocaleDTO> resultList = new PageImpl<LocaleDTO>(
                list.getContent().stream()
                        .map(obj -> _localeAssembler.toModel(obj)).toList(), pageable, list.getTotalElements());
        return ResponseEntity.ok().body(resultList);
    }
}
