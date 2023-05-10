package com.detrasoft.locale.api.assemblers;

import com.detrasoft.framework.api.dto.converters.GenericRepresentationModelDTOAssembler;
import com.detrasoft.locale.api.controller.LocaleController;
import com.detrasoft.locale.api.dtos.LocaleDTO;
import com.detrasoft.locale.domain.entities.Locale;
import org.springframework.stereotype.Component;

@Component
public class LocaleAssembler extends GenericRepresentationModelDTOAssembler<Locale, LocaleDTO> {
    public LocaleAssembler() {
        super(LocaleController.class, LocaleDTO.class);
    }
}
