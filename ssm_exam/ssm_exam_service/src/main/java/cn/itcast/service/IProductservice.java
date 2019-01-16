package cn.itcast.service;

import cn.itcast.pojo.Product;

import java.util.List;

public interface IProductservice {
    /*
    查询所有
     */
    public List<Product> findAllProduct(Integer page, Integer pageSize) throws Exception;

    /*
    添加产品
     */
    public int saveProduct(Product product) throws Exception;

}
