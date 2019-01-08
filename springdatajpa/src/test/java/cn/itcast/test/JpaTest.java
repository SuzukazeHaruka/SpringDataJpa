package cn.itcast.test;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JpaTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void fun(){
        Customer customer=new Customer();
        customer.setCustName("凉风青葉");
        customerDao.save(customer);
    }
    @Test
    public void findOne(){
        Customer one = customerDao.findOne(4l);
        System.out.println(one);
    }
    @Test
    public void update(){
        Customer customer=new Customer();
        customer.setCustName("八神光");
        customer.setCustId(4l);
        customerDao.save(customer);
    }
    @Test
    public void delete(){
        customerDao.delete(3l);
    }
    @Test
    public void findAll(){
        List<Customer> all = customerDao.findAll();
        for (Customer customer : all) {
            System.out.println(customer);
            
        }
    }
    @Test
    public void Count(){
        long count = customerDao.count();
        System.out.println(count);
    }
    @Test
    public void Exists(){
        boolean exists = customerDao.exists(4l);
        System.out.println(exists);
    }
    @Test
    @Transactional
    /**
     * 根据id从数据库查询
     *      @Transactional : 保证getOne正常运行
     *
     *  findOne：
     *      em.find()           :立即加载
     *  getOne：
     *      em.getReference     :延迟加载
     *      * 返回的是一个客户的动态代理对象
     *      * 什么时候用，什么时候查询
     */
    public void  testGetOne() {
        Customer customer=customerDao.getOne(4l);
        System.out.println(customer);
    }
}
