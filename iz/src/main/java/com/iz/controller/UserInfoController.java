package com.iz.controller;

import com.iz.pojo.UserInfo;
import com.iz.service.RedisService;
import com.iz.service.impl.UserInfoServiceImpl;
import com.util.LogUtils;
import com.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户Controller
 *
 * @author yt
 * @version 1.0
 * @date 2018/7/30
 * @remark
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserInfoController {

  @Autowired private UserInfoServiceImpl userInfoService;

  @Autowired private RedisService redisService;

  protected static final Logger logException = LogUtils.getExceptionLogger();
  protected static final Logger logBus = LogUtils.getBussinessLogger();
  protected static final Logger logDb = LogUtils.getDBLogger();
  protected final Logger logger = LoggerFactory.getLogger(this.getClass());

  @GetMapping(value = "/users")
  @ExceptionHandler
  public ResponseEntity<Result> getUsers() throws Exception {
    List<UserInfo> users = userInfoService.getUsers();
    // redisService.set("123456", "123456");
    logException.warn("测试异常");
    logBus.trace("测试业务");
    logDb.error("测试db");
    logger.error("aaaaa");
    return ResponseEntity.ok(new Result("success", users));
  }

  @GetMapping(value = "/user/{id}")
  public ResponseEntity<Result> getUser(@PathVariable("id") String id) {
    UserInfo user = userInfoService.user(id);
    return ResponseEntity.ok(new Result("success", user));
  }

  @GetMapping(value = "/findUser")
  public ResponseEntity<Result> findUser(String id) {
    UserInfo user = userInfoService.user(id);
    return ResponseEntity.ok(new Result("success", user));
  }
}
