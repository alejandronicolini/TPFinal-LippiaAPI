package ar.validator;

import api.model.ErrorResponse;
import ar.steps.UserSteps;
import com.crowdar.api.rest.APIManager;
import com.crowdar.api.rest.CommonSteps;
import org.testng.Assert;
import services.Api_Info;
import services.BaseService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class TpUtils {


    public static String randomString(String frase) {
        int num = (int) (Math.random() * (1000));
        return frase + " v: " + num;
    }

    public static String horaInicio() {
        ZonedDateTime horaActual = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Z"));
        ZonedDateTime horaFormated = horaActual.withNano(0);
        return horaFormated.toString();
    }

    public static String horaFin() {
        ZonedDateTime horaActual = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Z"));
        ZonedDateTime horaFormated = horaActual.withNano(0);
        ZonedDateTime horaEnd = horaFormated.plusHours(5);
        return horaEnd.toString();
    }

    public static void hacerRequest(String metodo, String entity, String jsonName, String valores) {
        UserSteps userSteps = new UserSteps();
        try {
            userSteps.doRequest(metodo, entity, jsonName, valores);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verifyStatus(int code) {
        CommonSteps commonSteps = new CommonSteps();
        commonSteps.iWillGetTheProperStatusCodeStatusCode(code);
    }

    public static void setAddParamsDefault() {
        BaseService.AddParams("base.url", Api_Info.BASE_URL);
        BaseService.AddParams("api_key", Api_Info.API_INVALID_KEY);
        BaseService.AddParams("workspace_id", Api_Info.WORKSPACE_ID);
    }

    public static void verifyCodeResponse(int code) {
        ErrorResponse response = (ErrorResponse) APIManager.getLastResponse().getResponse();
        Assert.assertEquals(response.getCode(), (Integer) code);
    }


}
