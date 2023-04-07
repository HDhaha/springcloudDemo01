package com.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 申浩东
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommenResult<T>{
    private Integer code;
    private String msg;
    private T data;

    /**
     * 调用全参构造器,此时data数据为空
     * @param code
     * @param msg
     */
    public CommenResult(Integer code, String msg){
        this(code,msg,null);
    }

    public static CommenResult success(){
        return new CommenResult(200,"操作成功",null);
    }

    public static CommenResult success(Object data){
        return new CommenResult(200,"操作成功",data);
    }
    public static CommenResult error(){
        return new CommenResult(400,"操作失败",null);
    }

    public static CommenResult toCommentResult(int i){
        return i>0?success():error();
    }
}
