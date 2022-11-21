package services;

import api.model.Project.Api_ProjectResponse;
import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;


public class ProjectService extends MethodsService {

    public static Response get(String jsonName) {
        return get(jsonName, Api_ProjectResponse.class, BaseService.setParams());
    }

    //metodo para cuando el endPoint devuelve un arreglo de objetos
    public static Response getlist(String jsonName) {
        return get(jsonName, Api_ProjectResponse[].class, BaseService.setParams());
    }

    public static Response post(String jsonName) {
        return post(jsonName, Api_ProjectResponse.class, BaseService.setParams());
    }

    //metodo que recibe el map de los datos del 4to parametro del step
//    public static Response postmap(String jsonName, Map<String, String> params) {
//        return post(jsonName, Api_ProjectResponse.class, BaseService.setParams());
//    }

    public static Response put(String jsonName) {
        return put(jsonName, Api_ProjectResponse.class, BaseService.setParams());
    }

//    public static Response putmap(String jsonName, Map<String, String> params) {
//        return put(jsonName, Api_ProjectResponse.class, BaseService.setParams());
//    }

    public static Response delete(String jsonName) {
        return delete(jsonName, Api_ProjectResponse.class, BaseService.setParams());
    }


    //Funciona
//    public static Map<String, String> setParams1() {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("base.url", BaseService.getBase_Url());
//        params.put("api_key", Api_Info.API_KEY);
//        params.put("workspace_id", Api_Info.WORKSPACE_ID);
//        params.put("project_id", Api_Info.PROJECT_ID);
//
//        return params;
//    }

//Original
//    private static Map<String, String> setParams() {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("base.url", PropertyManager.getProperty("base.api.url"));
//        params.put("api-key",API_KEY.get());
//        return params;
//    }

}
