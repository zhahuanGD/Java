package cn.itcast.dao;

import cn.itcast.pojo.Traveller;

import java.util.List;

/*
旅客操作类
 */
public interface TravellerMapper {
    /*
    根据订单编号查询旅客信息
     */
    public List<Traveller> findTravellerByOrderId(String ordersis);
}
