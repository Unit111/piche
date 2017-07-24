Feature: Selenium 3 tests

  @YouTube
  Scenario: User can open Youtube and search for a video
    Given a user opens Youtube
    When the user searches for "Nier Automata"
    Then the user can open the first result
    And the video is ran