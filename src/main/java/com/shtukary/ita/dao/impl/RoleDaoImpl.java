package com.shtukary.ita.dao.impl;

import com.shtukary.ita.dao.RoleDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.shtukary.ita.model.Role;

@Repository
public class RoleDaoImpl extends AbstractDao<Role, Long> implements RoleDao {

    public Role findByType(String type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Role where type = :type").setParameter("type", type);
        return (Role) query.getSingleResult();
    }

}
