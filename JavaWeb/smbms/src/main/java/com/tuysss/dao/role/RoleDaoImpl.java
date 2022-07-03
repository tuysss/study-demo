package com.tuysss.dao.role;

import com.tuysss.dao.BaseDao;
import com.tuysss.pojo.Role;
import com.tuysss.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao{
    @Override
    public List<Role> getUserRoleList(Connection connection) throws SQLException {
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Role> roleList=new ArrayList<>();
        if(connection!=null){
            String sql="select * from smbms_role";
            rs=BaseDao.excute(connection,ps,sql,new Object[]{},rs);
            while(rs.next()){
                Role _role = new Role();
                _role.setId(rs.getInt("id"));
                _role.setRoleCode(rs.getString("roleCode"));
                _role.setRoleName(rs.getString("roleName"));
                roleList.add(_role);
            }
            BaseDao.closeResource(null,ps,rs);
        }
        return roleList;
    }
}
