package com.sunil.fun.unit.services;

import static org.junit.Assert.assertEquals;

import com.sunil.fun.services.CreditScoreService;
import com.sunil.fun.entities.CompanyType;
import com.sunil.fun.entities.CreditScoreRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CreditScoreServiceTest {

  @InjectMocks
  CreditScoreService creditScoreService;

  @Test
  public void test_sole_proprietorship_returns_score_of_12() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.SOLE_PROPRIETORSHIP,
        0, 0);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(12, score);
  }

  @Test
  public void test_limited_liability_company_returns_score_of_63() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.LIMITED_LIABILITY, 0,
        0);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(63, score);
  }

  @Test
  public void test_comapny_partnership_returns_score_of_75() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.PARTNERSHIP, 0, 0);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(75, score);
  }


  @Test
  public void test_other_company_returns_score_of_0() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 0, 0);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(0, score);
  }

  @Test
  public void test_1_employee_returns_score_of_0() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 1, 0);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(0, score);
  }

  @Test
  public void test_5_employee_returns_score_of_0() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 1, 0);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(0, score);
  }

  @Test
  public void test_6_employee_returns_score_of_20() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 6, 0);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(20, score);
  }

  @Test
  public void test_10_employees_returns_score_of_20() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 10, 0);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(20, score);
  }

  @Test
  public void test_11_employees_returns_score_of_32() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 11, 0);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(32, score);
  }

  @Test
  public void test_15_employees_returns_score_of_32() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 15, 0);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(32, score);
  }

  @Test
  public void test_16_employees_returns_score_of_55() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 16, 0);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(55, score);
  }

  @Test
  public void test_20_employees_returns_score_of_55() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 20, 0);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(55, score);
  }

  @Test
  public void test_21_employees_returns_score_of_70() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 21, 0);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(70, score);
  }

  @Test
  public void test_0_years_in_business_returns_0() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 0, 0);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(0, score);
  }

  @Test
  public void test_3_years_in_business_returns_0() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 0, 3);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(0, score);
  }

  @Test
  public void test_4_years_in_business_returns_28() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 0, 4);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(28, score);
  }

  @Test
  public void test_9_years_in_business_returns_28() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 0, 9);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(28, score);
  }

  @Test
  public void test_10_years_in_business_returns_36() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 0, 10);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(36, score);
  }

  @Test
  public void test_15_years_in_business_returns_36() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 0, 15);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(36, score);
  }

  @Test
  public void test_16_years_in_business_returns_59() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.OTHER, 0, 16);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(59, score);
  }

  @Test
  public void test_limited_liability_company_with_10_employees_with_8_years_in_business_returns_score_of_111() {
    CreditScoreRequest creditScoreRequest = new CreditScoreRequest(CompanyType.LIMITED_LIABILITY, 10, 8);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    assertEquals(111, score);
  }
}
