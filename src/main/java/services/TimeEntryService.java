package services;

import api.model.TimeEntry.Api_TimeEntry;
import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;


public class TimeEntryService extends MethodsService {

    public static Response get(String jsonName) {
        return get(jsonName, Api_TimeEntry.class, BaseService.setParams());
    }

    public static Response getlist(String jsonName) {
        return get(jsonName, Api_TimeEntry[].class, BaseService.setParams());
    }

    public static Response post(String jsonName) {
        return post(jsonName, Api_TimeEntry.class, BaseService.setParams());
    }

    public static Response put(String jsonName) {
        return put(jsonName, Api_TimeEntry.class, BaseService.setParams());
    }

    public static Response delete(String jsonName) {
        return delete(jsonName, Api_TimeEntry.class, BaseService.setParams());
    }

}
