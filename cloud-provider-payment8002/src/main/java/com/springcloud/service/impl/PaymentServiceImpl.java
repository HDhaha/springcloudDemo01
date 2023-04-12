package com.springcloud.service.impl;

import com.springcloud.domain.Payment;
import com.springcloud.mapper.PaymentDao;
import com.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 申浩东
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int insertPayment(Payment payment) {
        return paymentDao.insertPayment(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public int updatePayment(Payment payment) {
        return paymentDao.updatePayment(payment);
    }
}
