package com.company.mybatis.pojo;

import java.util.List;

/**
 * @Author wlb10
 * @PackageName MyBatis
 * @Package com.company.mybatis.pojo
 * @Date 2022/4/21 16:21
 * @Version 1.0
 */
public class Dept {
    private Integer did;
    private String deptName;
    private List<Emp> empList;

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", empList=" + empList +
                '}';
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public Dept() {
    }

    public Dept(Integer did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}
