package com.iz.repository;

import com.iz.pojo.SysUser;

public interface SysUserMapper {
  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * iz_sys_user
   *
   * @mbggenerated
   */
  int deleteByPrimaryKey(String id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * iz_sys_user
   *
   * @mbggenerated
   */
  int insert(SysUser record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * iz_sys_user
   *
   * @mbggenerated
   */
  int insertSelective(SysUser record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * iz_sys_user
   *
   * @mbggenerated
   */
  SysUser selectByPrimaryKey(String id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * iz_sys_user
   *
   * @mbggenerated
   */
  int updateByPrimaryKeySelective(SysUser record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * iz_sys_user
   *
   * @mbggenerated
   */
  int updateByPrimaryKey(SysUser record);

  SysUser getUser(String userName);
}
