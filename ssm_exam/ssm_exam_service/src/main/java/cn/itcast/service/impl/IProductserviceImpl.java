package cn.itcast.service.impl;

import cn.itcast.dao.ProductMapper;
import cn.itcast.pojo.Product;
import cn.itcast.service.IProductservice;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.image.ImageProducer;
import java.util.List;

@Service
@Transactional
public class IProductserviceImpl implements IProductservice {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAllProduct(Integer page, Integer pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        return productMapper.findAllProduct();
    }

    @Override
    public int saveProduct(Product product) throws Exception {
        return productMapper.saveProduct(product);
    }
}
