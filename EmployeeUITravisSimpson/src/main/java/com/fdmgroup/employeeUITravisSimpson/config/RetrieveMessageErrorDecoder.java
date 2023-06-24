package com.fdmgroup.employeeUITravisSimpson.config;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdmgroup.employeeUITravisSimpson.exception.ExceptionMessage;
import com.fdmgroup.employeeUITravisSimpson.exception.InvalidEmployeeException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class RetrieveMessageErrorDecoder implements ErrorDecoder {
	
	private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionMessage message = null;
        try (InputStream bodyIs = response.body()
            .asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(bodyIs, ExceptionMessage.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }
        switch (response.status()) {
        case 400:
            return new InvalidEmployeeException(message.getMessage() != null ? message.getMessage() : "@@@ Bad Request @@@");
//        case 404:
//            return new NotFoundException(message.getMessage() != null ? message.getMessage() : "Not found");
        default:
            return errorDecoder.decode(methodKey, response);
        }
    }

}
