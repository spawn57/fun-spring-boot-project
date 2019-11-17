package com.sunil.fun.unit.services;

import com.sunil.fun.entities.CompanyType;
import com.sunil.fun.entities.CreditScoreRequest;

public class CreditScoreService {

  public int calculateScore(CreditScoreRequest creditScoreRequest) {
    int score;

    score = calculateScoreForCompany(creditScoreRequest.getCompanyType());

    score += getScoreForNumberOfEmployees(creditScoreRequest.getNumberOfEmployees());

    score += getScoreForNumberOfYearsInBusiness(creditScoreRequest.getTimeInBusiness());
    return score;
  }

  private int calculateScoreForCompany(CompanyType companyType) {
    switch (companyType) {
      case SOLE_PROPRIETORSHIP:
        return 12;
      case LIMITED_LIABILITY:
        return 63;
      case PARTNERSHIP:;
        return 75;
      case OTHER:
        return 0;
    }

    return 0;
  }

  private int getScoreForNumberOfEmployees(int numberOfEmployees) {
    if (numberOfEmployees < 6) {
      return 0;
    } else if (numberOfEmployees < 11) {
      return 20;
    } else if (numberOfEmployees < 16) {
      return 32;
    } else if (numberOfEmployees < 21) {
      return 55;
    } else {
      return 70;
    }
  }

  private int getScoreForNumberOfYearsInBusiness(int numberOfYearsInBusiness) {
    if (numberOfYearsInBusiness < 4) {
      return 0;
    } else if (numberOfYearsInBusiness < 10) {
      return 28;
    } else if (numberOfYearsInBusiness < 16) {
      return 36;
    } else {
      return 59;
    }
  }
}
