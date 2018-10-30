package com.iz.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yt
 * @version 1.0
 * @date 2018/8/3
 * @remark
 */
@Getter
@Setter
public class MessageNotice {

  private String title;
  private String content;
  private String etraInfo;

  public MessageNotice(String title, String content, String etraInfo) {
    this.title = title;
    this.content = content;
    this.etraInfo = etraInfo;
  }
}
