package cn.itcast.service.impl;

import cn.itcast.dao.OrdersMapper;
import cn.itcast.pojo.Orders;
import cn.itcast.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IOrdersServiceImpl implements IOrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    /*
    查询所有订单
     */
    @Override
    public List<Orders> findAllOrders(Integer page, Integer pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        return ordersMapper.findAllOrders();
    }

    /*
    根据订单编号查询订单信息
     */
    @Override
    public Orders findOrdersById(String id) throws Exception {
        return ordersMapper.findOrdersById(id);
    }
}
