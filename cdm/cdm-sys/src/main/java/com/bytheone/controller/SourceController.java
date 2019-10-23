package com.bytheone.controller;

import com.bytheone.base.BaseController;
import com.bytheone.core.annotation.Log;
import com.bytheone.entity.SysSource;
import com.bytheone.exception.MyException;
import com.bytheone.service.SourceService;
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
 * @date 2018/06/13.
 * @email liu.tingli@qq.com
 * 商机
 */
@RequestMapping("/source")
@Controller
public class SourceController extends BaseController {

    @Autowired
    private SourceService sourceService;


    /**
     * 展示tree
     *
     * @param model 商机数据
     * @return String
     */
    @ApiOperation(value = "/showSource", httpMethod = "GET", notes = "展示商机")
    @GetMapping(value = "showSource")
    @RequiresPermissions("source:show")
    public String showSource(Model model) {
        return "/system/source/query_source";
    }

    @ApiOperation(value = "/showSourceList", httpMethod = "GET", notes = "展示商机")
    @GetMapping(value = "showSourceList")
    @ResponseBody
    @RequiresPermissions("source:show")
    public String showSourceList(SysSource source, Model model, String page, String limit) {
        return sourceService.show(source, Integer.valueOf(page), Integer.valueOf(limit));
    }

    @GetMapping(value = "showAddSource")
    public String addSource(Model model) {
        return "/system/source/add_source";
    }

    @Log(desc = "添加商机", type = Log.LOG_TYPE.UPDATE)
    @ApiOperation(value = "/addSource", httpMethod = "POST", notes = "添加商机")
    @PostMapping(value = "addSource")
    @ResponseBody
    public JsonUtil doAddSource(SysSource sysSource, Model model) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (sysSource == null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }

        if (StringUtils.isEmpty(sysSource.getPermission())) {
            sysSource.setPermission(null);
        }

        try {
            if (sysSource.getSourceType() == 2) {
                sysSource.setSourceType((byte) 0);
            }
            sourceService.insertSelective(sysSource);
            jsonUtil.setMsg("添加成功");
        } catch (MyException e) {
            e.printStackTrace();
            jsonUtil.setMsg("添加失败");
        }
        return jsonUtil;
    }

    @GetMapping(value = "showSyncSource")
    public String syncSource(Model model) {
        return "/system/source/sync_source";
    }

    @Log(desc = "同步商机", type = Log.LOG_TYPE.UPDATE)
    @ApiOperation(value = "/syncSource", httpMethod = "POST", notes = "同步商机")
    @PostMapping(value = "syncSource")
    @ResponseBody
    public JsonUtil doSyncSource(SysSource sysSource, Model model) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (sysSource == null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }

        if (StringUtils.isEmpty(sysSource.getPermission())) {
            sysSource.setPermission(null);
        }

        try {
            if (sysSource.getSourceType() == 2) {
                sysSource.setSourceType((byte) 0);
            }
            sourceService.sync();
            jsonUtil.setMsg("添加成功");
        } catch (MyException e) {
            e.printStackTrace();
            jsonUtil.setMsg("添加失败");
        }
        return jsonUtil;
    }

    @GetMapping(value = "showUpdateSource")
    public String showUpdateSource(Model model, String id) {
        SysSource sysSource = sourceService.selectByPrimaryKey(id);
        model.addAttribute("sysSource", sysSource);

        return "/system/source/update_source";
    }


    @Log(desc = "更新商机", type = Log.LOG_TYPE.ADD)
    @PostMapping(value = "updateSource")
    @ResponseBody
    public JsonUtil updateSource(SysSource sysSource) {
        SysSource oldSource = sourceService.selectByPrimaryKey(sysSource.getId());
        BeanUtil.copyNotNullBean(sysSource, oldSource);
        sourceService.updateByPrimaryKeySelective(oldSource);
        return JsonUtil.sucess("保存成功");
    }
}
