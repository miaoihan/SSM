package com.zh.test;

import com.zh.map.UserMapper;
import com.zh.models.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * time: 16-5-11.
 * author: han
 */
public class Test {
    public static void main(String[] args) {
        /**mybatis的配置文件*/
        String resource = "com/zh/map/MyBatisConfig.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
//        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream(resource);
        InputStream inputStream = null; //用Reader也可以
        /**使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）*/
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //没分解的步骤
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(inputStream);
        /**构建sqlSession的工厂,一直存在*/
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        factory.getConfiguration().addMapper(UserMapper.class);//需要注册
        /**创建能执行映射文件中sql的sqlSession，随方法存在*/
        SqlSession session = factory.openSession();
        try {
            /**
             * 映射sql的标识字符串，
             * com.zh.map.userMapper.getUser是userMapper.xml文件中mapper标签的namespace属性的值，
             * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
             */
            String statement = "com.zh.map.userMapper.getUser";//映射sql的标识字符串
            //执行查询返回一个唯一user对象的sql
            /**  XML的方式   */
            //查
            User u1 = session.selectOne("findById",92);
            System.out.println(u1);
            /** 注解的方式 */
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User u2 = userMapper.selectUser(42);
            User u3 = new User("阿aa","汪待","123");
            //增
            session.insert("add",u3);
            //删
            session.delete("delete",u1);
            //改
            User u4 = session.selectOne("findById",78);
            u4.setDel_status(0);
            session.update("update",u4);
            /**  必须提交事务，不然无法写入数据库   */
            session.commit();
            System.out.println(u2);
        } finally {
            session.close();
        }
    }
}
