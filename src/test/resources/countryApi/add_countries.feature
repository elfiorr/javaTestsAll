Feature: Rates API for Latest Foreign Exchange rates

  @add_countries_scenario
  Scenario Outline: x
    Given Create country "<countries>" with capitol "<capitol>" and population "<population>"
    Examples:
      | countries | capitol | population |
      | USD       |         | 1          |
      | GBP       |         |            |
      | USD,GBP   |         |            |

