package com.sunil.fun.contollers;

import com.sunil.fun.entities.CreditScoreRequest;
import com.sunil.fun.mappers.CreditScoreRequestMapper;
import com.sunil.fun.dto.CreditScoreRequestDto;
import com.sunil.fun.dto.CreditScoreResponseDto;
import com.sunil.fun.services.CreditScoreService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CreditScoreController {

  private final CreditScoreService creditScoreService;
  private final CreditScoreRequestMapper creditScoreRequestMapper;

  @Autowired
  public CreditScoreController(CreditScoreService creditScoreService, CreditScoreRequestMapper creditScoreRequestMapper) {

    this.creditScoreService = creditScoreService;
    this.creditScoreRequestMapper = creditScoreRequestMapper;
  }

  @ApiOperation(value = "Calculates the Credit Score: "
      + "company should be either SOLE_PROPRIETOR, LIMITED_LIABILITY, PARTNERSHIP or OTHER.  "
      + "Note that it is case sensitive.\n")
  @GetMapping(value="calculateCreditScore", produces="application/json")
  public CreditScoreResponseDto calculateCreditScore(CreditScoreRequestDto creditScoreRequestDto) {
    CreditScoreRequest creditScoreRequest = creditScoreRequestMapper
        .fromCreditScoreRequestDto(creditScoreRequestDto);

    int score = creditScoreService.calculateScore(creditScoreRequest);

    return new CreditScoreResponseDto(score);
  }
}
