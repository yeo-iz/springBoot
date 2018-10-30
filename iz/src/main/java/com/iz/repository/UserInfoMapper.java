package com.iz.repository;

import com.iz.pojo.UserInfo;

import java.util.List;

public interface UserInfoMapper {
  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * iz_user
   *
   * @mbggenerated
   */
  int deleteByPrimaryKey(String id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * iz_user
   *
   * @mbggenerated
   */
  int insert(UserInfo record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * iz_user
   *
   * @mbggenerated
   */
  int insertSelective(UserInfo record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * iz_user
   *
   * @mbggenerated
   */
  UserInfo selectByPrimaryKey(String id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * iz_user
   *
   * @mbggenerated
   */
  int updateByPrimaryKeySelective(UserInfo record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * iz_user
   *
   * @mbggenerated
   */
  int updateByPrimaryKey(UserInfo record);

  List<UserInfo> getUsers();
}