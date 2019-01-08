package cn.itcast.test;


import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JpqlTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void  testFindJPQL() {
        Customer customer = customerDao.findJpql("小糸侑");
        System.out.println(customer);
    }
    @Test
    public void  testFindJPQLById() {
        Customer customer = customerDao.findCustNameAndId("小糸侑", 2l);
        System.out.println(customer);
    }
    @Test
    @Transactional
    @Rollback(value = false)
    public void  testUpdate() {
        customerDao.updateCustomer(2l,"小仓朝日");
    }
    @Test
    public void  testFindByName() {
        Customer customer=customerDao.findByCustName("小仓朝日");
        System.out.println(customer);
    }
    @Test
    public void  testFindByNameLikeforSql() {
        List<Object[]> sql = customerDao.findSql("%凉%");
        for (Object[] customers : sql) {
            System.out.println(Arrays.toString(customers));
        }
    }
    @Test
    public void  testFindByNameLike() {
        List<Customer> customers=customerDao.findByCustNameLike("%凉%");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
    @Test
    public void  findByCustNameLikeAndCustIndustry() {
        List<Customer> customers = customerDao.findByCustNameLikeAndCustIndustry("%凉%", "美工");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
