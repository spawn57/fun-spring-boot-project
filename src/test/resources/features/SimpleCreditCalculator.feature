Feature: Credit Assessment Calculator
  This is a simple credit assessment calculator feature for software engineer candidates

  Scenario: Calculate Credit Assessment Score
    When The calculateCreditAssessmentScore API is called with company type "LIMITED_LIABILITY", 25 employees and 5 in business
    Then The credit assessment score should match "161"

#  Examples:
#    | numberOfEmployees | companyType | numberOfYearsOperated | result |
#    | 6 | Sole Proprietorship | 5 | ... |
#    | 10 | Limited Liability Company | 8 | ...fill in different use cases here... |
