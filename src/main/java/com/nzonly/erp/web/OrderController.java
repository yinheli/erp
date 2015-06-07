package com.nzonly.erp.web;

import com.nzonly.erp.service.IOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew
 * Date: 13-4-12
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("order")
public class OrderController {

    private IOrderService orderService;

    public IOrderService getOrderService(){
        return orderService;
    }

    @Resource
    public void setOrderService(IOrderService orderService){
        this.orderService = orderService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("orders", orderService.find());
        return "order/list";
    }

}
