package com.bytheone.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ArtLinty
 * @date 2017/12/19.
 * @email liu.tingli@qq.com
 * 404 403 500
 */
@Controller
@RequestMapping(value = "/error")
public class ErrorController {

    @GetMapping(value = "404")
    public String pageNotFound() {
        return "error/404";
    }

    @GetMapping(value = "403")
    public String NotFound(String message, Model model) {
        if (!StringUtils.isEmpty(message)) {
            model.addAttribute("message", message);
        }
        return "error/403";
    }

}
