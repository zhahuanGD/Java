package cn.itcast.dao;

import cn.itcast.pojo.Orders;

import java.util.List;

public interface OrdersMapper {
    /*
   查询所有订单
    */
    public List<Orders> findAllOrders() throws Exception;

    /*
    根据订单编号查询订单信息
     */
    public Orders findOrdersById(String id) throws Exception;
}
