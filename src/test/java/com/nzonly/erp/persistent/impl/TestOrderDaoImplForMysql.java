package com.nzonly.erp.persistent.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nzonly.erp.entity.Order;
import com.nzonly.erp.persistence.BaseDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestOrderDaoImplForMysql extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private BaseDao orderDao;

	@Test
	public void testInsert(){
		Order order = new Order();
		order.setBuyerNick("grubylee");
		order.setBuyerRate("false");

        orderDao.insert("Order.insert", order);

	}

	
}
