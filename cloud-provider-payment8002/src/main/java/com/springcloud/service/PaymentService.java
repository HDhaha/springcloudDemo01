package com.springcloud.service;

import com.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 申浩东
 */
public interface PaymentService {
    public int insertPayment(Payment payment);
    public Payment getPaymentById(@Param("id") Integer id);

    int updatePayment(Payment payment);
}
