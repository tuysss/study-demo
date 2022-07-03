package com.tuysss.service.role;

import com.tuysss.dao.BaseDao;
import com.tuysss.dao.role.RoleDao;
import com.tuysss.dao.role.RoleDaoImpl;
import com.tuysss.pojo.Role;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleServiceImpl implements RoleService{
    private RoleDao roleDao;

    public RoleServiceImpl(){
        this.roleDao=new RoleDaoImpl();
    }

    @Override
    public List<Role> getRoleList() {
        Connection connection=null;
        List<Role> roleList=new ArrayList<>();
        try {
            connection=BaseDao.getConnection();
            roleList=roleDao.getUserRoleList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection,null,null);
        }
        return roleList;
    }

    @Test
    public void test(){
        List<Role> roleList = getRoleList();
        for (Role role : roleList) {
            System.out.println(role.getRoleName());
        }
    }
}
