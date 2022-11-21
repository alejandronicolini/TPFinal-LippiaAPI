package services;

import api.model.ErrorResponse;
import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;


public class ErrorService extends MethodsService {

    public static Response get(String jsonName) {
        return get(jsonName, ErrorResponse.class, BaseService.setParams());
    }

    public static Response delete(String jsonName) {
        return delete(jsonName, ErrorResponse.class, BaseService.setParams());
    }

    public static Response post(String jsonName) {
        return post(jsonName, ErrorResponse.class, BaseService.setParams());
    }

    public static Response put(String jsonName) {
        return put(jsonName, ErrorResponse.class, BaseService.setParams());
    }

}
