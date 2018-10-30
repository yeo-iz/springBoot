package com.iz.service;

import com.iz.pojo.UserInfo;

import java.util.List;

/**
 * @author yt
 * @version 1.0
 * @date 2018/8/2
 * @remark
 */
public interface UserInfoService {

  /**
   * 获取user list
   *
   * @return
   */
  List<UserInfo> getUsers();

  /**
   * 获取user
   *
   * @param id
   * @return
   */
  UserInfo user(String id);
}
