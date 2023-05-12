package com.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: HD
 * @create: 2023/5/12
 * @remark:
 */
@Mapper
public interface MyTestMapper {
    List<String> queryAna();
}
