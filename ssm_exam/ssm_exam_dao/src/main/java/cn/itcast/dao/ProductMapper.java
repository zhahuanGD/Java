package cn.itcast.dao;

import cn.itcast.pojo.Product;

import java.util.List;

public interface ProductMapper {
    /*
    查询所有
     */
    public List<Product> findAllProduct() throws Exception;

    /*
    添加产品
     */
    public int saveProduct(Product product) throws Exception;
    /*
    根据产品编号查询产品信息
     */
    public Product findProductById(String id) throws Exception;
}
