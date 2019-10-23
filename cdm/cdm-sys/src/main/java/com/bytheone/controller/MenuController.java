package com.bytheone.controller;

import com.alibaba.fastjson.JSONArray;
import com.bytheone.base.BaseController;
import com.bytheone.core.annotation.Log;
import com.bytheone.core.annotation.Log.LOG_TYPE;
import com.bytheone.entity.SysMenu;
import com.bytheone.exception.MyException;
import com.bytheone.service.MenuService;
import com.bytheone.util.BeanUtil;
import com.bytheone.util.JsonUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ArtLinty
 * @date 2017/12/13.
 * @email liu.tingli@qq.com
 * 菜单
 */
@RequestMapping("/menu")
@Controller
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    /**
     * 展示tree
     *
     * @param model
     * @return
     */
    @ApiOperation(value = "/showMenu", httpMethod = "GET", notes = "展示菜单")
    @GetMapping(value = "showMenu")
    @RequiresPermissions("menu:show")
    public String showMenu(Model model) {
        JSONArray ja = menuService.getMenuJsonList();
        model.addAttribute("menus", ja.toJSONString());
        return "/system/menu/menuList";
    }

    @GetMapping(value = "showAddMenu")
    public String addMenu(Model model) {
        JSONArray ja = menuService.getMenuJsonList();
        System.out.print(ja.toJSONString());
        model.addAttribute("menus", ja.toJSONString());
        return "/system/menu/add-menu";
    }

    @Log(desc = "添加菜单", type = LOG_TYPE.UPDATE)
    @ApiOperation(value = "/addMenu", httpMethod = "POST", notes = "添加菜单")
    @PostMapping(value = "addMenu")
    @ResponseBody
    public JsonUtil addMenu(SysMenu sysMenu, Model model) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (sysMenu == null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        if (StringUtils.isEmpty(sysMenu.getPId())) {
            sysMenu.setPId(null);
        }
        if (StringUtils.isEmpty(sysMenu.getUrl())) {
            sysMenu.setUrl(null);
        }
        if (StringUtils.isEmpty(sysMenu.getPermission())) {
            sysMenu.setPermission(null);
        }

        try {
            if (sysMenu.getMenuType() == 2) {
                sysMenu.setMenuType((byte) 0);
            }
            menuService.insertSelective(sysMenu);
            jsonUtil.setMsg("添加成功");
        } catch (MyException e) {
            e.printStackTrace();
            jsonUtil.setMsg("添加失败");
        }
        return jsonUtil;
    }

    @GetMapping(value = "showUpdateMenu")
    public String showUpdateMenu(Model model, String id) {
        SysMenu sysMenu = menuService.selectByPrimaryKey(id);
        JSONArray ja = menuService.getMenuJsonList();
        model.addAttribute("menus", ja.toJSONString());
        model.addAttribute("sysMenu", sysMenu);
        if (null != sysMenu.getPId()) {
            SysMenu pSysMenu = menuService.selectByPrimaryKey(sysMenu.getPId());
            model.addAttribute("pName", pSysMenu.getName());
        }
        return "/system/menu/update-menu";
    }


    @Log(desc = "更新菜单", type = LOG_TYPE.ADD)
    @PostMapping(value = "updateMenu")
    @ResponseBody
    public JsonUtil updateMenu(SysMenu sysMenu) {
        SysMenu oldMenu = menuService.selectByPrimaryKey(sysMenu.getId());
        BeanUtil.copyNotNullBean(sysMenu, oldMenu);
        menuService.updateByPrimaryKeySelective(oldMenu);
        return JsonUtil.sucess("保存成功");
    }

}
