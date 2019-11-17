package com.sunil.fun.mappers;

import com.sunil.fun.dto.CreditScoreRequestDto;
import com.sunil.fun.entities.CompanyType;
import com.sunil.fun.entities.CreditScoreRequest;
import org.springframework.stereotype.Service;

@Service
public class CreditScoreRequestMapper {
  public CreditScoreRequest fromCreditScoreRequestDto(CreditScoreRequestDto creditScoreRequestDto) {

    CompanyType companyType = CompanyType.valueOf(creditScoreRequestDto.getCompanyType());

    return CreditScoreRequest.builder()
        .companyType(companyType)
        .numberOfEmployees(creditScoreRequestDto.getNumberOfEmployees())
        .timeInBusiness(creditScoreRequestDto.getTimeInBusiness())
        .build();
  }
}
