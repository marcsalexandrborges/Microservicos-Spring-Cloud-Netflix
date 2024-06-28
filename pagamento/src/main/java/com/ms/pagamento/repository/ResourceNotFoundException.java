package com.ms.pagamento.repository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 8120036922771184540L;

    public ResourceNotFoundException(String exception){
        super(exception);
    }


}
