package com.sunil.fun.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreditScoreRequestDto {

  private String companyType;
  private Integer numberOfEmployees;
  private Integer timeInBusiness;

}
