#Feature: Workspace
#
#  COMO usuario de Clockify
#  QUIERO ver las configuraciones de mi Workspace
#  PARA llevar un buen control de mis horas de trabajo y el de mis empleados
#
##BIEN
#  Scenario Outline: Get - all my workspaces
#    Given Cuenta creada en clockify y X-Api-Key Valida
#    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
#    And se obtuvo el status code <status>
#    Then Obtengo los datos de mi Workspace
#    Examples:
#      | operation | entity    | jsonName                       | status |
#      | GET       | WORKSPACE | workspace/req_GetAllWorkspaces | 200    |
#
# #BIEN
#  Scenario Outline: ERROR 401 (Api Invalida) - Get - all my workspaces
#    Given Cuenta creada en clockify y X-Api-Key Invalida
#    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
#    And se obtuvo el status code <status>
#    Then se obtuvo el response esperado en <entity> con el <response>
#    Then se valida el mensaje con: code 4003
#    Examples:
#      | operation | entity | jsonName                       | status | response           |
#      | GET       | ERROR  | workspace/req_GetAllWorkspaces | 401    | workspace/resp_401 |


    