package ar.steps;

import ar.validator.ProjectValidator;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import services.Api_Info;
import services.BaseService;

public class ProjectSteps extends PageSteps {


    @And("ingreso un project-id Valido")
    public void inputProjectIdValido() {
        BaseService.AddParams("project_id", Api_Info.PROJECT_ID);
    }

    @And("ingreso un project-id Invalido")
    public void inputProjectIdInvalido() {
        BaseService.AddParams("project_id", Api_Info.PROJECT_INVALID_ID);
    }

    @Then("se valida que el id no sea null")
    public void seValidaQueElIdNoSeaNull() {
        ProjectValidator.verifyIdNotNull();
    }

    @Then("se valida que los id projects no sean null")
    public void verifyIdProjectsNotNull() {
        ProjectValidator.verifyIdInAllProjects();
    }

    @And("ingreso un project-id y actualizo sus datos")
    public void inputProjectIdAndDataUpdate() {
        BaseService.AddParams("project_id", "63499aa6a6c95831856a2f2b");
        BaseService.AddParams("nombre", "Proyecto UPDATE-4");
        BaseService.AddParams("notas", "Actualizo un dato4");
    }

    @Then("se valida datos update")
    public void seValidaElUpdate() {
        ProjectValidator.verifyIdNotNull();
        ProjectValidator.verifyDataUpdate();
    }

    @And("ingreso un project-id archivado a eliminar")
    public void ingresoUnProjectIdArchivadoAEliminar() {
        BaseService.AddParams("project_id", "634b0c18ac11fd230b550dac");
    }

    @And("ingreso un project-id activo a eliminar")
    public void ingresoUnProjectIdAEliminar() {
        BaseService.AddParams("project_id", "63488263f1437a08b65a02f8");
    }

    @And("consulto un proyecto aleatorio a actualizar")
    public void consultoUnProyectoAleatorioAActualizar() {
        ProjectValidator.randomProjectUpdate();
    }

    @And("ingreso un titulo {string}")
    public void ingresoUnTituloName(String titulo) {
        BaseService.AddParams("nombre", titulo);
    }

    @And("recupero el project_id creado para eliminar")
    public void recuperoElProject_IdCreadoParaEliminar() {
        ProjectValidator.searchProjectIdToDelete();
    }

    @And("cambio estado del atributo archived a {string}")
    public void cambioEstadoDelAtributoArchivedA(String estado) {
        ProjectValidator.changeStateArchived(estado);
    }

    @And("elimino datos del map params")
    public void eliminoDatosDelMapParams() {
        ProjectValidator.removeDataInParams();
    }
}
