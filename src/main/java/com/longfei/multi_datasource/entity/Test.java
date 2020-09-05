package com.longfei.multi_datasource.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class Test implements Serializable {
    private Integer id;

    private String name;

    private Integer dd;

    private Integer age;

    private static final long serialVersionUID = 1L;
}