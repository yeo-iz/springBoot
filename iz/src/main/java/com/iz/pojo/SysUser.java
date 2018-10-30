package com.iz.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author yt
 * @version 1.0
 * @date 2018/8/3
 * @remark
 */
@Getter
@Setter
public class SysUser {

  private String id;
  private String userName;
  private String passWord;

  private List<SysRole> roles;
}
