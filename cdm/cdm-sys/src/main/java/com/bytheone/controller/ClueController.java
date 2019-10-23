package com.bytheone.controller;


import com.bytheone.base.BaseController;
import com.bytheone.core.annotation.Log;
import com.bytheone.entity.SysClue;
import com.bytheone.exception.MyException;
import com.bytheone.service.ClueService;
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
 * 线索
 */
@RequestMapping("/clue")
@Controller
public class ClueController extends BaseController {

    @Autowired
    private ClueService clueService;

    /**
     * 展示tree
     *
     * @param model
     * @return String
     */
    @ApiOperation(value = "/showClue", httpMethod = "GET", notes = "展示线索")
    @GetMapping(value = "showClue")
    @RequiresPermissions("clue:show")
    public String showClue(Model model) {
        return "/system/clue/query_clue";
    }

    @GetMapping(value = "showAddClue")
    public String addClue(Model model) {
        return "/system/clue/add_clue";
    }

    @Log(desc = "添加线索", type = Log.LOG_TYPE.UPDATE)
    @ApiOperation(value = "/addClue", httpMethod = "POST", notes = "添加线索")
    @PostMapping(value = "addClue")
    @ResponseBody
    public JsonUtil doAddClue(SysClue sysClue, Model model) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (sysClue == null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        if (StringUtils.isEmpty(sysClue.getPId())) {
            sysClue.setPId(null);
        }
        if (StringUtils.isEmpty(sysClue.getUrl())) {
            sysClue.setUrl(null);
        }
        if (StringUtils.isEmpty(sysClue.getPermission())) {
            sysClue.setPermission(null);
        }

        try {
            if (sysClue.getClueType() == 2) {
                sysClue.setClueType((byte) 0);
            }
            clueService.insertSelective(sysClue);
            jsonUtil.setMsg("添加成功");
        } catch (MyException e) {
            e.printStackTrace();
            jsonUtil.setMsg("添加失败");
        }
        return jsonUtil;
    }

    @GetMapping(value = "showUpdateClue")
    public String showUpdateClue(Model model, String id) {
        SysClue sysClue = clueService.selectByPrimaryKey(id);
        model.addAttribute("sysClue", sysClue);
        if (null != sysClue.getPId()) {
            SysClue pSysClue = clueService.selectByPrimaryKey(sysClue.getPId());
            model.addAttribute("pName", pSysClue.getName());
        }
        return "/system/clue/update_clue";
    }


    @Log(desc = "更新线索", type = Log.LOG_TYPE.ADD)
    @PostMapping(value = "updateClue")
    @ResponseBody
    public JsonUtil updateClue(SysClue sysClue) {
        SysClue oldClue = clueService.selectByPrimaryKey(sysClue.getId());
        BeanUtil.copyNotNullBean(sysClue, oldClue);
        clueService.updateByPrimaryKeySelective(oldClue);
        return JsonUtil.sucess("保存成功");
    }
}
