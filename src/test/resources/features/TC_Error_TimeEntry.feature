@FeatureTimeEntryError
Feature: Invalid Time Entry

  Background:
    Given Cuenta creada en clockify y X-Api-Key Valida


  @GetError403_TimeEntry
  Scenario: 1. ERROR 403 (workspace Id Invalido) - Get - Consultar las horas registradas
    And ingreso un workspace-id Invalido
    And ingreso el user-id a consultar
    When I perform a 'GET' to 'EMPTY' endpoint with the 'time_entry/req_Get_AllTimesEntry' and ''
    Then se obtuvo el status code 403


  @GetError400_TimeEntry
  Scenario: 1. ERROR 400 (user Id Invalido) - Get - Consultar las horas registradas
    And ingreso un workspace-id Valido
    And ingreso el user-id Invalido a consultar
    When I perform a 'GET' to 'ERROR' endpoint with the 'time_entry/req_Get_AllTimesEntry' and ''
    Then se obtuvo el status code 400
    Then se obtuvo el response esperado en ERROR con el time_entry/resp_Get_Entry_code501 y sus parametros 'user_id_invalid:ERRORb92648048064054b07f,workspace_id:63434d76d89b0d464e043eca'
    Then se valida el mensaje con: code 501


  @PostError400_TimeEntry
  Scenario: 2. ERROR 400 (project Id Invalido) Post - Add a new time entry
    And ingreso un workspace-id Valido
    And ingreso datos en body y project-id Invalido
    When I perform a 'POST' to 'ERROR' endpoint with the 'time_entry/req_Post_AddNewTimeEntry' and ''
    Then se obtuvo el status code 400
    Then se obtuvo el response esperado en ERROR con el time_entry/resp_Post_Entry_code501 y sus parametros 'project_id_invalid:ERROR2fc4a7cfa3a5023d3fc,workspace_id:63434d76d89b0d464e043eca'
    Then se valida el mensaje con: code 501


  @PutError400_TimeEntry
  Scenario: 3. ERROR 400 (body sin Start) Put - Update time entry on workspace
    And ingreso un workspace-id Valido
    And ingreso el user-id a consultar
    When I perform a 'GETLIST' to 'TIME' endpoint with the 'time_entry/req_Get_AllTimesEntry' and ''
    And verifico si existe un time entry sino creo uno
    And actualizo datos de un time entry sin Start
    When I perform a 'PUT' to 'ERROR' endpoint with the 'time_entry/req_Put_Error_TimeEntryById' and ''
    And se obtuvo el status code 400
    Then se obtuvo el response esperado en ERROR con el time_entry/resp_Put_Entry_code501
    Then se valida el mensaje con: code 501


