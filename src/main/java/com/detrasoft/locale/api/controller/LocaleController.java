package com.detrasoft.locale.api.controller;

import com.detrasoft.framework.api.controllers.hateoas.GenericHateoasCRUDController;
import com.detrasoft.framework.api.controllers.jackson.ResponseView;
import com.detrasoft.locale.api.assemblers.LocaleAssembler;
import com.detrasoft.locale.api.dtos.LocaleDTO;
import com.detrasoft.locale.domain.repository.LocaleRepository;
import com.detrasoft.locale.domain.services.LocaleCRUDService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/locale")
public class LocaleController extends GenericHateoasCRUDController<LocaleDTO> {

    @Autowired
    LocaleRepository localeRepository;

    @Autowired
    public LocaleController(LocaleCRUDService service, LocaleAssembler assembler) {
        super(service, assembler);
    }

    @JsonView(ResponseView.findAll.class)
    @PostMapping(value = "/by-list-id")
    public ResponseEntity<List<LocaleDTO>> findByListId(@RequestBody List<Long> body) {
        return ResponseEntity.ok(
                localeRepository.findByIdIn(body)
                        .stream()
                        .map(obj -> assembler.toModel(obj, true)).toList()
        );
    }
}
