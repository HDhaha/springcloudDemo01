package com.springcloud.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 申浩东
 */
@Data
public class Payment implements Serializable {
    private Integer id;
    private String serial;
}
