package ar.steps;

import ar.validator.TpUtils;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.Api_Info;
import services.BaseService;

public class Common_Steps_Utils extends PageSteps {

    @Given("Cuenta creada en clockify y X-Api-Key Valida")
    public void set_XApiKey_Valida() {
        BaseService.AddParams("base.url", Api_Info.BASE_URL);
        BaseService.AddParams("api_key", Api_Info.API_KEY);
    }

    @And("ingreso un workspace-id Valido")
    public void inputWorkspaceIdValido() {
        BaseService.AddParams("workspace_id", Api_Info.WORKSPACE_ID);
    }

    @And("ingreso un workspace-id Invalido")
    public void inputWorkspaceIdInvalido() {
        BaseService.AddParams("workspace_id", Api_Info.WORKSPACE_INVALID_ID);
    }

    @Then("se valida el mensaje con: code {int}")
    public void verifyMessageCode(int code) {
        TpUtils.verifyCodeResponse(code);
    }

}
