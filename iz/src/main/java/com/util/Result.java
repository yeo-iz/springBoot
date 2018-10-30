package com.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yt
 * @version 1.0
 * @date 2018/8/1
 * @remark
 */
@Getter
@Setter
public class Result {

  private String status;

  private Object message;

  public Result(String status, Object message) {
    this.status = status;
    this.message = message;
  }

  @Override
  public String toString() {
    return "Result{" + "status='" + status + '\'' + ", message=" + message + '}';
  }
}
