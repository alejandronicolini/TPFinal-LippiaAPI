package ar.steps;

import ar.validator.TimeEntryValidator;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import services.Api_Info;
import services.BaseService;

public class TimeEntrySteps extends PageSteps {


    @And("ingreso el user-id a consultar")
    public void ingresoElUserIdAConsultar() {
        BaseService.AddParams("user_id", Api_Info.USER_ID);
    }

    @Then("se valida que los id de las entradas no sean null")
    public void seValidaQueLosIdDeLasEntradasNoSeanNull() {
        TimeEntryValidator.verifyIdInAllTimesEntries();
    }

    @And("ingreso datos en body")
    public void ingresoDatosEnBody() {
        TimeEntryValidator.dataBodyNewTimeEntry();
    }

    @Then("se valida datos new time entry")
    public void seValidaElUpdate() {
        TimeEntryValidator.verifyIdNotNull();
        TimeEntryValidator.verifyDataNewEntry();
    }

    @And("configuro parametros para delete")
    public void recuperoElTime_entry_idCreadoParaEliminar() {
        TimeEntryValidator.setAddParamDeleteTimeEntry();
    }

    @And("verifico si existe un time entry sino creo uno")
    public void verificoSiExisteUnTimeEntrySinoCreoUno() {
        TimeEntryValidator.verifyTimeEntryExistOrCreate();
    }

    @And("actualizo datos de un time entry")
    public void actualizoDatosDeUnTimeEntry() {
        TimeEntryValidator.updateDataBody();
    }

    @And("actualizo datos de un time entry sin Start")
    public void actualizoDatosDeUnTimeEntrySinStart() {
        TimeEntryValidator.updateDataBodyWithoutStart();
    }

    @Then("se valida datos update Time Entry")
    public void seValidaDatosUpdateTimeEntry() {
        TimeEntryValidator.verifyIdNotNull();
        TimeEntryValidator.verifyDataUpdateEntry();
    }

    @And("ingreso el user-id Invalido a consultar")
    public void ingresoElUserIdInvalidoAConsultar() {
        BaseService.AddParams("user_id", Api_Info.USER_ID_INVALID);
    }

    @And("ingreso datos en body y project-id Invalido")
    public void ingresoDatosEnBodyYProjectIdInvalido() {
        TimeEntryValidator.invalidDataBodyNewTimeEntry();
    }

}
