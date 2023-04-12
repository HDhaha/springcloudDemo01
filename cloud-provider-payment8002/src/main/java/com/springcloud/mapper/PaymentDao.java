package com.springcloud.mapper;

import com.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 申浩东
 */
@Mapper
public interface PaymentDao {
    public int insertPayment(Payment payment);
    public Payment getPaymentById(@Param("id") Integer id);

    int updatePayment(Payment payment);
}
