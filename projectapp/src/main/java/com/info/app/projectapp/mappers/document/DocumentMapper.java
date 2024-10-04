package com.info.app.projectapp.mappers.document;

import com.info.app.projectapp.domain.Documento;
import com.info.app.projectapp.dto.document.DocumentDto;
import org.mapstruct.Mapper;

@Mapper
public interface DocumentMapper {

    Documento documentDtoToDocumento(DocumentDto documentDto);
}
