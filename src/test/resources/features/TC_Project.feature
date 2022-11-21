Feature: Project

#  @Get
#  Scenario: 1. Get - all projects on workspace
#    Given Cuenta creada en clockify y X-Api-Key Valida
#    And ingreso un workspace-id Valido
#    When I perform a 'GETLIST' to 'PROJECT' endpoint with the 'project/req_Get_AllProjects' and ''
#    And se obtuvo el status code 200
#    Then se valida que los id projects no sean null
#
#  @Get
  Scenario: 1. ERROR 403 (workspace Id Invalido)- Get - all projects on workspace
    Given Cuenta creada en clockify y X-Api-Key Valida
    And ingreso un workspace-id Invalido
    When I perform a 'GET' to 'ERROR' endpoint with the 'project/req_Get_AllProjects' and ''
    Then se obtuvo el status code 403
#
#  @Get
#  Scenario: 2. Get - Find project by ID
#    Given Cuenta creada en clockify y X-Api-Key Valida
#    And ingreso un workspace-id Valido
#    And ingreso un project-id Valido
#    When I perform a 'GET' to 'PROJECT' endpoint with the 'project/req_Get_ProjectById' and ''
#    And se obtuvo el status code 200
#    Then se valida que el id no sea null
#
#  @Get
  Scenario: 2. ERROR 400 (project id Invalido)- Get - Find project by ID Invalido
    Given Cuenta creada en clockify y X-Api-Key Valida
    And ingreso un workspace-id Valido
    And ingreso un project-id Invalido
    When I perform a 'GET' to 'ERROR' endpoint with the 'project/req_Get_ProjectById' and ''
    And se obtuvo el status code 400
    Then se obtuvo el response esperado en ERROR con el project/resp_code501 y sus parametros 'project_id_invalid:ERROR2fc4a7cfa3a5023d3fc,workspace_id:63434d76d89b0d464e043eca'
    Then se valida el mensaje con: code 501
#
#
#  @Post
#  Scenario Outline: 3. Post - Add a new project with name changeable
#    Given Cuenta creada en clockify y X-Api-Key Valida
#    And ingreso un workspace-id Valido
#    And ingreso un titulo '<name>'
#    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
#    Then se obtuvo el status code <status>
#    Then se valida datos update
#    Examples:
#      | operation | entity  | jsonName                       | status | name       |
#      | POST      | PROJECT | project/req_Post_AddNewProject | 201    | Academy 10 |
#      | POST      | PROJECT | project/req_Post_AddNewProject | 201    | Academy 20 |
#      | POST      | PROJECT | project/req_Post_AddNewProject | 201    | Academy 30 |
#
#  @Put
#  Scenario: 4. Put - Update project on workspace
#    Given Cuenta creada en clockify y X-Api-Key Valida
#    And ingreso un workspace-id Valido
#    And ingreso un project-id y actualizo sus datos
#    When I perform a 'PUT' to 'PROJECT' endpoint with the 'project/req_Put_UpdateProject' and ''
#    And se obtuvo el status code 200
#    Then se valida datos update
#
#
#  #Comentario: el Scenario 5c, es el que tiene todas las validaciones del Endpoint Delete
#  Scenario: 5a. Delete - Delete project from workspace
#    Given Cuenta creada en clockify y X-Api-Key Valida
#    And ingreso un workspace-id Valido
#    And ingreso un project-id archivado a eliminar
#    When I perform a 'DELETE' to 'PROJECT' endpoint with the 'project/req_Delete_ProjectById' and ''
#    Then se obtuvo el status code 200
#
#  Scenario: 5b. Delete - Delete project from workspace
#    Given Cuenta creada en clockify y X-Api-Key Valida
#    And ingreso un workspace-id Valido
#    And ingreso un project-id archivado a eliminar
#    When I perform a 'DELETE' to 'PROJECT' endpoint with the 'project/req_Delete_ProjectById' and ''
#    Then se obtuvo el status code 200
#    When I perform a 'GET' to 'ERROR' endpoint with the 'project/req_Get_ProjectById' and ''
#    Then se obtuvo el status code 400
#
##Comentario: para poder eliminar un proyecto, es necesario que el atributo archived sea true.
##Ademas, el proyecto al ser creado, setea por default el valor en false, independientemente de como figura en la request POST.
#  @Delete
#  Scenario: 5c. Delete - Delete project from workspace con validaciones
#    Given Cuenta creada en clockify y X-Api-Key Valida
#    And ingreso un workspace-id Valido
#    And ingreso un titulo 'Prueba Eliminacion1'
#    When I perform a 'POST' to 'PROJECT' endpoint with the 'project/req_Post_NewProjectForDelete' and ''
#    And se obtuvo el status code 201
#    And recupero el project_id creado para eliminar
#    And cambio estado del atributo archived a "true"
#    When I perform a 'PUT' to 'PROJECT' endpoint with the 'project/req_Put_ProjectToDelete' and ''
#    And se obtuvo el status code 200
#    And elimino datos del map params
#    When I perform a 'DELETE' to 'PROJECT' endpoint with the 'project/req_Delete_ProjectById' and ''
#    And se obtuvo el status code 200
#    When I perform a 'GET' to 'ERROR' endpoint with the 'project/req_Get_ProjectById' and ''
#    Then se obtuvo el status code 400
#
#
##Creo que hay un BUG. Ya que devuelve 200 y sin cuerpo en la response.
##En Postman, no deja eliminar un proyecto que este Activo en Clockify.
#  Scenario: 5. Error 400 Delete - Delete Active project from workspace
#    Given Cuenta creada en clockify y X-Api-Key Valida
#    And ingreso un workspace-id Valido
#    And ingreso un project-id activo a eliminar
#    When I perform a 'DELETE' to 'ERROR' endpoint with the 'project/req_Delete_ProjectById' and ''
#    And se obtuvo el status code 400
#    Then se obtuvo el response esperado en ERROR con el project/resp_Delete_code501
#    Then se valida el mensaje con: code 501
#
#
##Tarea Punto 5
#    #  5. Por medio de API realizar las siguientes acciones:
#    #  5.1. Consultar un proyecto por su identificador.
#    #  5.2 Editar el valor de algún campo del proyecto y validar el cambio realizado (ejercicio libre).
#  @TP5
#  Scenario: Get and Put - Update project on workspace
#    Given Cuenta creada en clockify y X-Api-Key Valida
#    And ingreso un workspace-id Valido
#    When I perform a 'GETLIST' to 'PROJECT' endpoint with the 'project/req_Get_AllProjects' and ''
#    And se obtuvo el status code 200
#    And consulto un proyecto aleatorio a actualizar
#    When I perform a 'PUT' to 'PROJECT' endpoint with the 'project/req_Put_UpdateProject' and ''
#    And se obtuvo el status code 200
#    Then se valida datos update
