package com.iz.repository;

import com.iz.pojo.SysRole;

public interface SysRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table iz_sys_role
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table iz_sys_role
     *
     * @mbggenerated
     */
    int insert(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table iz_sys_role
     *
     * @mbggenerated
     */
    int insertSelective(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table iz_sys_role
     *
     * @mbggenerated
     */
    SysRole selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table iz_sys_role
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table iz_sys_role
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysRole record);
}