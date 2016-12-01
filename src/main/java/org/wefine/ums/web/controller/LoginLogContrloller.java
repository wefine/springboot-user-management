package org.wefine.ums.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wefine.ums.dao.impl.Pager;
import org.wefine.ums.utils.ListResult;
import org.wefine.ums.utils.MessageBox;
import org.wefine.ums.web.service.LoginLogService;

@Controller
@RequestMapping("/admin/loginlog")
public class LoginLogContrloller {

    @Autowired
    @Qualifier("loginLogService")
    private LoginLogService loginLogService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage() {
        return "core/loginlog/loginlog_list";
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public
    @ResponseBody
    MessageBox list(Pager pager) {
        MessageBox messageBox = new MessageBox();
        if (pager != null && pager.getLimit() != null && pager.getStart() != null) {
            ListResult result = loginLogService.list(pager);
            if (result != null && result.getCount() != null) {
                messageBox.setSuccess(true);
                messageBox.setRows(result.getDataList());
                messageBox.setTotal(result.getCount());
            }
        }
        return messageBox;
    }
}
