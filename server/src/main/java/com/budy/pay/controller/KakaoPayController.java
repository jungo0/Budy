package com.budy.pay.controller;

import com.budy.exception.BusinessLogicException;
import com.budy.exception.ExceptionCode;
import com.budy.pay.response.KakaoReadyResponse;
import com.budy.pay.response.KakaoApproveResponse;
import com.budy.pay.response.KakaoCancelResponse;
import com.budy.pay.service.KakaoPayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class KakaoPayController {
    private final KakaoPayService kakaoPayService;
    private final KakaoApproveResponse kakaoApproveResponse;

    /** 결제요청 */
    @PostMapping("/ready")
    public KakaoReadyResponse ready() {

        return kakaoPayService.kakaoPayReady();
    }


    /** 결제 성공 */
    @GetMapping("/success")
    public ResponseEntity success(@RequestParam("pg_token") String pgToken) {

        KakaoApproveResponse kakaoApprove = kakaoPayService.approveResponse(pgToken);

        return new ResponseEntity<>(kakaoApprove, HttpStatus.OK);
    }

    /** 결제 진행 중 취소  */
    @GetMapping("/cancel")
    public void cancel() {

        throw new BusinessLogicException(ExceptionCode.PAY_CANCEL);
    }

    /** 결제 실패 */
    @GetMapping("/fail")
    public void fail() {

        throw new BusinessLogicException(ExceptionCode.PAY_FAILED);
    }

    /** 환불 */
    @PostMapping("/refund")
    public ResponseEntity refund() {

        KakaoCancelResponse kakaoCancelResponse = kakaoPayService.kakaoCancel();

        return new ResponseEntity<>(kakaoCancelResponse, HttpStatus.OK);
    }
}