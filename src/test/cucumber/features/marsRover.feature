Feature: To find final position of the Mars Rover

Scenario: making the mars rover move
    Given I enter the end coordinates of Plateau as 5 5
    When I enter the initial position of the Rover as 1 2 N
    And I give the instructions for its movement as LMLMLMLMLMM
    Then the Mars Rover should reach position 1 3 N