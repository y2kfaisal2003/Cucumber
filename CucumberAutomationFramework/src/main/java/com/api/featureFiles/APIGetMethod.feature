Feature: Status Code validation from Weather API for different Cities

  Scenario: Verify Status Code of Weather API
    Given Weather API Endpoint and URI for different Cities from Excel
    When Reading Endpoint and URI from Excel Sheet "/resources/DataSource/TestData.xlsx;APITestsGETMethod".
    Then Verify Status Code 200