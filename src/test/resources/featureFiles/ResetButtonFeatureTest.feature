Feature: Reset Functionality Scenarios

  Scenario Outline: Reset Functionality
    Given User navigates to "<website>"
    When User enter the Username "<username>" and Password "<password>"
    Then Reset the credential

    Examples:
      | website                                     | username              | password   |
      | https://www.demo.guru99.com/v4              | test1                 | test1      |
      | https://www.demo.guru99.com/v4              | test2                 | test2      |
      
	