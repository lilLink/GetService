package com.shtukary.ita.dao;

import com.shtukary.ita.model.Role;

public interface RoleDao extends BaseDao<Role, Long> {

    Role findByType(String type);

}
