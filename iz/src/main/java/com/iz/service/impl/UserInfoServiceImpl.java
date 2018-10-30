package com.iz.service.impl;

import com.iz.pojo.UserInfo;
import com.iz.repository.UserInfoMapper;
import com.iz.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author yt
 * @version 1.0
 * @date 2018/8/2
 * @remark
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserInfoServiceImpl implements UserInfoService {

  @Autowired private UserInfoMapper userInfoMapper;

  @Override
  public List<UserInfo> getUsers() {
    return userInfoMapper.getUsers();
  }

  @Override
  public UserInfo user(String id) {
    Assert.hasText(id, "查询user ID不存在");

    return userInfoMapper.selectByPrimaryKey(id);
  }
}
