package dev.akinaksoy.quadrigabe.core.utilities.modelmapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forResponse();
    ModelMapper forRequest();
}
