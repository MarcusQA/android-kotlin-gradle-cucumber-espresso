Feature: Say greeting

  Scenario: Say "hello"
    When I select SAY HELLO
    Then I see greeting "Hello!"

  Scenario: Say "goodbye"
    When I select SAY GOODBYE
    # This step will fail
    Then I see greeting "GoodbyeQ!"