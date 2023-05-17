package com.springcloud.service.impl;

import com.springcloud.mapper.MyTestMapper;
import com.springcloud.service.MyTestService;
import com.springcloud.util.DataSourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: HD
 * @create: 2023/5/12
 * @remark:
 */
@Service
public class MyTestServiceImpl implements MyTestService {
    @Autowired
    private MyTestMapper testMapper;
    @Override
    public void test() {
        List<String> objects = testMapper.queryAna();
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}
