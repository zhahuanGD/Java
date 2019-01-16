package cn.itcast.controller;

import cn.itcast.pojo.Orders;
import cn.itcast.service.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/findAllOrders")
    public String findAllOrders(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") Integer pageSize) throws Exception {
        List<Orders> ordersList = ordersService.findAllOrders(page, pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        model.addAttribute("ordersList", pageInfo);
        return "orders-list";
    }

    @RequestMapping("/findOrdersById")
    public ModelAndView findOrdersById(String id) throws Exception {
        Orders orders = ordersService.findOrdersById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-show");
        mv.addObject("orders", orders);
        return mv;
    }

}
