@wip
Feature: Working with Users

  Scenario: Loading the current user
    Given that I am authenticated as user "123456"
    When I get the details of the current user
    Then the user details are successfully returned
    And the user details look like:
      | ID       | 123456                 |
      | Version  | 1                      |
      | Created  | 2015-07-29T12:55:00Z   |
      | Modified | 2015-07-29T12:55:00Z   |
      | Name     | Graham Cox             |
      | Email    | graham@grahamcox.co.uk |
      | Enabled  | True                   |

  Scenario: Loading the current user by ID
    Given that I am authenticated as user "123456"
    When I get the details of the user "123456"
    Then the user details are successfully returned
    And the user details look like:
      | ID       | 123456                 |
      | Version  | 1                      |
      | Created  | 2015-07-29T12:55:00Z   |
      | Modified | 2015-07-29T12:55:00Z   |
      | Name     | Graham Cox             |
      | Email    | graham@grahamcox.co.uk |
      | Enabled  | True                   |

  Scenario: Loading a non-existent user
    Given that I am authenticated as user "123456"
    When I get the details of the user "654321"
    Then the user details are not found
