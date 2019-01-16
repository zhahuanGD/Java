package cn.itcast.service;

import cn.itcast.pojo.Orders;

import java.util.List;

public interface IOrdersService {
    /*
    查询所有订单
     */
    public List<Orders> findAllOrders(Integer page, Integer pageSize) throws Exception;

    /*
   根据订单编号查询订单信息
    */
    public Orders findOrdersById(String id) throws Exception;
}
