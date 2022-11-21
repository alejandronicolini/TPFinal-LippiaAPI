@FeatureTimeEntry
Feature: Time Entry

  Background:
    Given Cuenta creada en clockify y X-Api-Key Valida
    And ingreso un workspace-id Valido


  @Get_TimeEntry
  Scenario: 1. Get - Consultar las horas registradas
    And ingreso el user-id a consultar
    When I perform a 'GETLIST' to 'TIME' endpoint with the 'time_entry/req_Get_AllTimesEntry' and ''
    Then se obtuvo el status code 200
    Then se valida que los id de las entradas no sean null


  @Post_TimeEntry
  Scenario: 2. Post - Add a new time entry
    And ingreso datos en body
    When I perform a 'POST' to 'TIME' endpoint with the 'time_entry/req_Post_AddNewTimeEntry' and ''
    Then se obtuvo el status code 201
    Then se valida datos new time entry
    And configuro parametros para delete
    When I perform a 'DELETE' to 'EMPTY' endpoint with the 'time_entry/req_Get_TimeEntryById' and ''
    And se obtuvo el status code 204
    When I perform a 'GET' to 'ERROR' endpoint with the 'time_entry/req_Get_TimeEntryById' and ''
    Then se obtuvo el status code 400
    Then se valida el mensaje con: code 501


  @Put_TimeEntry
  Scenario: 3. Put - Update time entry on workspace
    And ingreso el user-id a consultar
    When I perform a 'GETLIST' to 'TIME' endpoint with the 'time_entry/req_Get_AllTimesEntry' and ''
    And verifico si existe un time entry sino creo uno
    And actualizo datos de un time entry
    When I perform a 'PUT' to 'TIME' endpoint with the 'time_entry/req_Put_TimeEntryById' and ''
    And se obtuvo el status code 200
    Then se valida datos update Time Entry


  @Delete_TimeEntry
  Scenario: 4. Delete - Delete time entry from workspace
    And ingreso datos en body
    When I perform a 'POST' to 'TIME' endpoint with the 'time_entry/req_Post_AddNewTimeEntry' and ''
    Then se obtuvo el status code 201
    And configuro parametros para delete
    When I perform a 'DELETE' to 'EMPTY' endpoint with the 'time_entry/req_Delete_TimeEntry' and ''
    And se obtuvo el status code 204
    When I perform a 'GET' to 'ERROR' endpoint with the 'time_entry/req_Get_TimeEntryById' and ''
    Then se obtuvo el status code 400
    Then se valida el mensaje con: code 501

