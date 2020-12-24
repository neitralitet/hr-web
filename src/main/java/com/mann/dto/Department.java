package com.mann.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Vladimir Mann
 */
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;


    private String departmentName;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

}
