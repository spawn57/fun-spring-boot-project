package com.sunil.fun.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Builder
@Getter
public class CreditScoreRequest {

  @NonNull
  private CompanyType companyType;
  @NonNull
  private Integer numberOfEmployees;
  @NonNull
  private Integer timeInBusiness;

}
