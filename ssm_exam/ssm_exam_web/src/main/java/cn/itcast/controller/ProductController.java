package cn.itcast.controller;


import cn.itcast.pojo.Product;
import cn.itcast.service.IProductservice;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductservice productservice;

    @RequestMapping("/findAllProduct")
    public String findAllProduct(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") Integer pageSize) throws Exception {
        List<Product> productList = productservice.findAllProduct(page, pageSize);
        PageInfo pageInfo = new PageInfo(productList);
        model.addAttribute("productList", pageInfo);
        return "product-list";

    }

    @RequestMapping("/saveProduct")
    public String saveProduct(Product product) {
        try {
            int n = productservice.saveProduct(product);
            if (n > 0) {
                return "redirect:/product/findAllProduct";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "product-add";
    }


}
