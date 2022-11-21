package ar.validator;

import api.model.TimeEntry.Api_TimeEntry;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;
import services.Api_Info;
import services.BaseService;

import java.util.Arrays;

public class TimeEntryValidator {

    public static void verifyIdInAllTimesEntries() {
        Api_TimeEntry[] response = (Api_TimeEntry[]) APIManager.getLastResponse().getResponse();
        for (Api_TimeEntry entry : response) {
            Assert.assertNotNull(entry.getId(), "El id es null");
        }
    }

    public static void verifyIdNotNull() {
        Api_TimeEntry response = (Api_TimeEntry) APIManager.getLastResponse().getResponse();
        Assert.assertNotNull(response.getId(), "El id es null");
    }

    public static void setAddParamDeleteTimeEntry() {
        Api_TimeEntry response = (Api_TimeEntry) APIManager.getLastResponse().getResponse();
        BaseService.params.remove("project_id");
        BaseService.params.remove("task_id");
        BaseService.params.remove("start_time");
        BaseService.params.remove("descripcion");
        BaseService.params.remove("end_time");

        BaseService.AddParams("time_entry_id",  response.getId());
    }

    public static void dataBodyNewTimeEntry() {
        BaseService.AddParams("project_id", Api_Info.PROJECT_ID_CROWDAR);
        BaseService.AddParams("task_id", Api_Info.TASK_ID_CROWDAR);
        BaseService.AddParams("start_time", TpUtils.horaInicio());
        BaseService.AddParams("descripcion", TpUtils.randomString("entrada"));
        BaseService.AddParams("end_time", TpUtils.horaFin());
    }

    public static void invalidDataBodyNewTimeEntry() {
        BaseService.AddParams("project_id", Api_Info.PROJECT_INVALID_ID);
        BaseService.AddParams("start_time", TpUtils.horaInicio());
        BaseService.AddParams("descripcion", TpUtils.randomString("entrada"));
        BaseService.AddParams("end_time", TpUtils.horaFin());
    }

    public static void verifyDataNewEntry() {
        Api_TimeEntry response = (Api_TimeEntry) APIManager.getLastResponse().getResponse();
        String descripcion = BaseService.params.get("descripcion");
        String project_id = BaseService.params.get("project_id");
        Assert.assertEquals(response.getDescription(), descripcion,"El dato no concuerda: ");
        Assert.assertEquals(response.getProjectId(), project_id,"El project_id no concuerda: ");
    }

    public static String idTimeEntry;
    public static void verifyTimeEntryExistOrCreate() {
        Api_TimeEntry[] response = (Api_TimeEntry[]) APIManager.getLastResponse().getResponse();
        if (response.length==0){
            dataBodyNewTimeEntry();
            TpUtils.hacerRequest("POST","TIME","time_entry/req_Post_AddNewTimeEntry","");
            TpUtils.verifyStatus(201);
            Api_TimeEntry entradaNueva = (Api_TimeEntry) APIManager.getLastResponse().getResponse();
            idTimeEntry = entradaNueva.getId();
        }
        Api_TimeEntry objTimeEntry = Arrays.stream(response).findAny().get();
        idTimeEntry = objTimeEntry.getId();
    }

    public static void updateDataBody() {
        BaseService.AddParams("time_entry_id", idTimeEntry);
        BaseService.AddParams("project_id", Api_Info.PROJECT_ID_CROWDAR);
        BaseService.AddParams("start_time", TpUtils.horaInicio());
        BaseService.AddParams("descripcion", TpUtils.randomString("entrada"));
        BaseService.AddParams("end_time", TpUtils.horaFin());
    }

    public static void updateDataBodyWithoutStart() {
        BaseService.AddParams("time_entry_id", idTimeEntry);
        BaseService.AddParams("project_id", Api_Info.PROJECT_ID_CROWDAR);
        BaseService.AddParams("descripcion", TpUtils.randomString("entrada"));
        BaseService.AddParams("end_time", TpUtils.horaFin());
    }

    public static void verifyDataUpdateEntry() {
        Api_TimeEntry response = (Api_TimeEntry) APIManager.getLastResponse().getResponse();
        String descripcion = BaseService.params.get("descripcion");
        String timeEntryId_id = BaseService.params.get("time_entry_id");
        Assert.assertEquals(response.getDescription(), descripcion,"El dato no concuerda: ");
        Assert.assertEquals(response.getId(), timeEntryId_id,"El project_id no concuerda: ");
    }

}
