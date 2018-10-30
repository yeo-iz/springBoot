package com.iz.controller;

import com.iz.pojo.MessageNotice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yt
 * @version 1.0
 * @date 2018/8/3
 * @remark
 */
@Controller
public class HomeController {

  @RequestMapping("/")
  public String index(Model model) {
    MessageNotice msg = new MessageNotice("测试标题", "测试内容", "额外信息，只对管理员显示");
    model.addAttribute("msg", msg);
    return "home";
  }
}
