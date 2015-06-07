package com.nzonly.erp.service;

import com.nzonly.erp.entity.Order;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew
 * Date: 13-4-12
 * Time: 下午10:58
 * To change this template use File | Settings | File Templates.
 */
public interface IOrderService {

    public void save(Order order);

    public List<Order> find();
}
