package org.wefine.ums.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wefine.ums.dao.impl.Pager;
import org.wefine.ums.model.SysResources;
import org.wefine.ums.utils.ListResult;
import org.wefine.ums.utils.MessageBox;
import org.wefine.ums.utils.StringUtil;
import org.wefine.ums.web.service.ResManService;

@Controller
@RequestMapping("/admin/resouces")
@Scope(value = "prototype")
public class ResManController {
    @Autowired
    @Qualifier("resouceService")
    private ResManService resManService;

    @RequestMapping(value = "/{view}", method = RequestMethod.GET)
    public String loadResList(@PathVariable("view") String view) {
        if (StringUtil.isNotEmpty(view)) {
            if ("list".equals(view)) {
                return "core/resouces/res_list";
            } else if ("add".equals(view)) {
                return "core/resouces/res_add";
            } else if ("edit".equals(view)) {
                return "core/resouces/res_edit";
            }
        }
        return "page_not_found_error";
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public MessageBox getGroupList(Pager pager) {
        MessageBox messageBox = new MessageBox();
        if (pager != null) {
            ListResult listResult = resManService.getGroupList(pager);
            if (listResult != null) {
                messageBox.setSuccess(true);
                messageBox.setTotal(listResult.getCount());
                messageBox.setRows(listResult.getDataList());
            }
        }
        return messageBox;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public MessageBox addRes(SysResources resources) {
        MessageBox messageBox = new MessageBox();
        if (resources != null) {
            if (resManService.addRes(resources)) {
                messageBox.setSuccess(true);
            }
        }
        return messageBox;
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public MessageBox delRes(String resid) {
        MessageBox messageBox = new MessageBox();
        if (StringUtil.isNotEmpty(resid)) {
            if (resManService.delRes(resid)) {
                messageBox.setSuccess(true);
            }
        }
        return messageBox;
    }

}
