package com.nzonly.erp.service;

import com.nzonly.erp.persistence.BaseDao;
import com.nzonly.erp.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew
 * Date: 13-4-7
 * Time: 上午12:40
 * To change this template use File | Settings | File Templates.
 */
@Component
@Transactional(readOnly = true)
public class OrderService implements IOrderService {

    @Autowired
    private BaseDao dao;

    public Page<Order> getByPage(PageRequest pageRequest){
        return dao.getByPage("Order.getByPage", pageRequest);
    }

    public Order getByOid(Long oid){
        return null;
    }

    public void save( Order order){
        dao.insert("Order.insertSelective", order);
    }

    public List<Order> find(){
        return dao.getList("Order.list");
    }

}
