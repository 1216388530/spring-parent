package com.myself.spring.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myself.spring.mybatis.mbg.mapper.DepartmentMapper;
import com.myself.spring.mybatis.mbg.pojo.Department;
import com.myself.spring.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/***
 * 用于测试逆向功能和分页插件
 */
public class MBGTest {
    @Test
    public void testInsert() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession("mybatis-config-MBG.xml");
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = new Department();
        for(int i = 0;i<20;i++){
            department.setDeptName("i="+i+"部");
            mapper.insert(department);
        }

    }
    @Test
    public void testSelectPage() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession("mybatis-config-MBG.xml");
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        //开启分页功能，并获取简易的分页信息
        Page<Object> page = PageHelper.startPage(3, 4);
        //注意：这里的方法的返回值类型实际上是Page，因为 Page<E> extends ArrayList<E>
        List<Department> departments = mapper.selectAll();
        //获取详细的分页信息,参数1是List（内部会变成Page），参数2是导航页码的长度
        PageInfo<Department> pageInfo = new PageInfo<>(departments,5);
        System.out.println(page);
        System.out.println(pageInfo);
        departments.forEach(department-> System.out.println(department));
    }
}
