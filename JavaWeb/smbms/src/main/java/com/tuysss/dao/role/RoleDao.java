package com.tuysss.dao.role;

import com.tuysss.pojo.Role;
import com.tuysss.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RoleDao {
    //获取角色列表
    public List<Role> getUserRoleList(Connection connection) throws SQLException;

}
