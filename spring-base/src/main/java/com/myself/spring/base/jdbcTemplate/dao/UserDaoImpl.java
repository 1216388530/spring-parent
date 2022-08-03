package com.myself.spring.base.jdbcTemplate.dao;

import com.myself.spring.base.jdbcTemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //更新操作
    @Override
    public void addUser(User user) {
        String sql="INSERT INTO `t_user`  VALUES(?,?,?)";
        //利用jdbcTemplate.update(sql,可变参数)，来实现数据库的更新操作（增、删、改），返回影响的记录条数
        int update = jdbcTemplate.update(sql, user.getUserId(), user.getUsername(), user.getStatus());
        System.out.println("addUser "+update);
        //不需用手动去关闭资源
    }

    @Override
    public int countUser() {
        String sql="SELECT COUNT(1) FROM t_user;";
        //参数2：数据的返回值类型（java中对应的）
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public User findOne(int id) {
        String sql = "SELECT user_id,username,tstatus status FROM t_user where user_id=?";
        /**
         *参数2：是一个RowMapper，根据参数，自动将数据库中查询到的记录封装成指定对象
         *      转换规则
         *          1.字段名=属性名，则将记录中的数据填入属性
         *          2.字段名单词间使用_做间隔 = 属性名驼峰写法，则将记录中的数据填入属性
         *参数3：输入sql中的参数，为可变参数列表
         */
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
        return user;
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT user_id,username,tstatus status FROM t_user";
        /**
         *参数2：是一个RowMapper，根据参数，自动将数据库中查询到的记录封装成指定对象
         *      转换规则
         *          1.字段名=属性名，则将记录中的数据填入属性
         *          2.字段名单词间使用_做间隔 = 属性名驼峰写法，则将记录中的数据填入属性
         *参数3：输入sql中的参数，为可变参数列表
         */
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return query;
    }

    @Override
    public void batchAddUser(List<User> users) {
        String sql = "INSERT INTO `t_user`  VALUES(?,?,?)";

        List<Object[]> objsList = new ArrayList<>();
        for(User user: users){
            Object[] objects = new Object[]{user.getUserId(),user.getUsername(),user.getStatus()};
            objsList.add(objects);
        }
        /**
         * 参数2  List<Object[]> objsList：list中的每一个元素都填充入sql语句中，都可以得到一个完整的sql。每一个完整的sql都会执行一次，
         * 但是会以优化过的方式来执行
         */
        int[] ints = jdbcTemplate.batchUpdate(sql, objsList);
        for(int i=0;i<ints.length;i++){
            System.out.println("第"+i+"条完整的sql影响的记录数："+ints[i]);
            //批量添加的影响的记录数为-2时，表示成功，不会正常的返回影响的记录数
        }
    }

    @Override
    public void batchDeleteUserById(List<Object[]> integersList) {
        String sql = "DELETE FROM t_user WHERE `user_id` BETWEEN ? AND ?;";
        int[] ints = jdbcTemplate.batchUpdate(sql, integersList);
        for(int i=0;i<ints.length;i++){
            System.out.println("第"+i+"条完整的sql影响的记录数："+ints[i]);
            //会正常的返回影响的记录数
        }
    }


}
