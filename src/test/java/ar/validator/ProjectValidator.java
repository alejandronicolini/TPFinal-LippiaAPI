package ar.validator;

import api.model.ErrorResponse;
import api.model.Project.Api_ProjectResponse;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;
import services.BaseService;

import java.util.Arrays;

public class ProjectValidator {

    public static void verifyIdNotNull() {
        Api_ProjectResponse response = (Api_ProjectResponse) APIManager.getLastResponse().getResponse();
        Assert.assertNotNull(response.getId(), "El id es null");
    }

    public static void verifyIdInAllProjects() {
        //guardo todos los datos de la ultima request en la variable response
        Api_ProjectResponse[] response = (Api_ProjectResponse[]) APIManager.getLastResponse().getResponse();
        for (Api_ProjectResponse project : response) {
            Assert.assertNotNull(project.getId(), "El id es null");  //el atributo id (se definio en model)
        }
    }

    public static void randomProjectUpdate() {
        Api_ProjectResponse[] response = (Api_ProjectResponse[]) APIManager.getLastResponse().getResponse();
        Api_ProjectResponse proyecto = Arrays.stream(response).filter(elemento ->(!(elemento.isArchived()))).findAny().get();

        double random = Math.random();
        int num = (int)(Math.random()*(100));
        String nombre = "Proyecto UPDATE-Ejercicio 5 v." + num ;

        BaseService.AddParams("project_id",  proyecto.getId());
        BaseService.AddParams("nombre", nombre);
        BaseService.AddParams("notas", "Curso Crowdar 2022");
    }

    public static void verifyDataUpdate() {
        Api_ProjectResponse response = (Api_ProjectResponse) APIManager.getLastResponse().getResponse();
        String dato = BaseService.params.get("nombre");
        BaseService.params.clear();
        Assert.assertEquals(response.getName(), dato,"El dato no concuerda: ");
    }

    public static void searchProjectIdToDelete() {
        Api_ProjectResponse response = (Api_ProjectResponse) APIManager.getLastResponse().getResponse();
        BaseService.AddParams("project_id",  response.getId());
    }

    public static void changeStateArchived(String estado) {
        BaseService.AddParams("archivado",  estado);
    }

    public static void removeDataInParams() {
        BaseService.params.remove("nombre");
        BaseService.params.remove("archivado");
    }
}
