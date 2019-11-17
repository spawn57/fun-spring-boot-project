package com.sunil.fun.unit.mappers;

import static org.junit.Assert.assertEquals;

import com.sunil.fun.mappers.CreditScoreRequestMapper;
import com.sunil.fun.dto.CreditScoreRequestDto;
import com.sunil.fun.entities.CompanyType;
import com.sunil.fun.entities.CreditScoreRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CreditScoreRequestMapperTest {

  @InjectMocks
  CreditScoreRequestMapper creditScoreRequestMapper;

  @Test
  public void test_all_caps_and_underscore_for_company_type_returns_enum() {
    CreditScoreRequestDto creditScoreRequestDto = new CreditScoreRequestDto("SOLE_PROPRIETORSHIP", 1,
        3);

    CreditScoreRequest creditScoreRequest = creditScoreRequestMapper
        .fromCreditScoreRequestDto(creditScoreRequestDto);

    assertEquals(CompanyType.SOLE_PROPRIETORSHIP, creditScoreRequest.getCompanyType());
    assertEquals(1, creditScoreRequest.getNumberOfEmployees());
    assertEquals(3, creditScoreRequest.getTimeInBusiness());
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_small_letters_for_company_type_throws_excpetion() {
    CreditScoreRequestDto creditScoreRequestDto = new CreditScoreRequestDto("other", 1,
        3);

    CreditScoreRequest creditScoreRequest = creditScoreRequestMapper
        .fromCreditScoreRequestDto(creditScoreRequestDto);

  }
}
