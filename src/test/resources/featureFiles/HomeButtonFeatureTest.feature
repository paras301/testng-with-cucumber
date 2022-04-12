Feature: Home Button Functionality Scenarios

  Scenario Outline: Home Button Functionality
    Given User navigates to "<website>"
    When User clicks on Home Button
    Then Home website "<website2>" is reached

    Examples:
      | website                                | website2                    |
      | https://www.javatpoint.com/gui-testing | https://www.javatpoint.com/ |
      | https://www.javatpoint.com/gui-testing | https://www.javatpoint.com/ |
      
	