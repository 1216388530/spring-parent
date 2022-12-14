package com.myself.spring.mybatis.mbg.mapper;

import com.myself.spring.mybatis.mbg.pojo.Department;
import java.util.List;

public interface DepartmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Sat Jul 23 11:22:27 GMT+08:00 2022
     */
    int deleteByPrimaryKey(Integer did);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Sat Jul 23 11:22:27 GMT+08:00 2022
     */
    int insert(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Sat Jul 23 11:22:27 GMT+08:00 2022
     */
    Department selectByPrimaryKey(Integer did);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Sat Jul 23 11:22:27 GMT+08:00 2022
     */
    List<Department> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Sat Jul 23 11:22:27 GMT+08:00 2022
     */
    int updateByPrimaryKey(Department record);
}