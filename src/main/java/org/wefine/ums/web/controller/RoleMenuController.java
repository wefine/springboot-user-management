package org.wefine.ums.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.wefine.ums.utils.ListResult;
import org.wefine.ums.utils.MessageBox;
import org.wefine.ums.utils.StringUtil;
import org.wefine.ums.web.service.RoleMenuService;

import java.util.Collection;

@Controller
@RequestMapping("/admin/rolemenu")
@Scope("prototype")
public class RoleMenuController {


    @Autowired
    @Qualifier("roleMenuService")
    private RoleMenuService roleMenuService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String roleMenuList() {
        return "core/rolemenu/rolemenu_list";
    }

    @RequestMapping(value = "list/{roleId}", method = RequestMethod.POST)
    public
    @ResponseBody
    Object roleMenus(@PathVariable("roleId") String roleId, String id) {
        MessageBox messageBox = new MessageBox();
        if (StringUtil.isNotEmpty(roleId)) {
            ListResult result = roleMenuService.loadRoleMenu(roleId, id);
            if (StringUtil.isNotEmpty(id)) {
                return result.getDataList();
            } else {
                messageBox.setSuccess(true);
                messageBox.setRows(result.getDataList());
            }
        }
        return messageBox;
    }

    @RequestMapping(value = "autocreate/{roleId}")
    public
    @ResponseBody
    MessageBox createRoleMenu(@PathVariable("roleId") String roleId) {
        MessageBox messageBox = new MessageBox();
        if (StringUtil.isNotEmpty(roleId)) {
            if (roleMenuService.createRoleMenu(roleId)) {
                messageBox.setSuccess(true);
            }
        }
        return messageBox;
    }


    @RequestMapping(value = "/moveDown", method = RequestMethod.POST)
    public
    @ResponseBody
    MessageBox moveDown(
            @RequestParam(value = "roleid", required = true) String roleid,
            @RequestParam(value = "menuid", required = true) String menuid
    ) {
        MessageBox messageBox = new MessageBox();
        if (roleMenuService.moveDown(roleid, menuid)) {
            messageBox.setSuccess(true);
        }
        return messageBox;
    }

    @RequestMapping(value = "/moveUp", method = RequestMethod.POST)
    public
    @ResponseBody
    MessageBox moveUp(
            @RequestParam(value = "roleid", required = true) String roleid,
            @RequestParam(value = "menuid", required = true) String menuid
    ) {
        MessageBox messageBox = new MessageBox();
        if (roleMenuService.moveUp(roleid, menuid)) {
            messageBox.setSuccess(true);
        }
        return messageBox;
    }


    @RequestMapping(value = "/load", method = RequestMethod.GET)
    @ResponseBody
    public Collection getRoleMenu(String id) {
        ListResult result = roleMenuService.loadRoleMenu(id);
        if (result != null) {
            return result.getDataList();
        }
        return null;
    }
}
