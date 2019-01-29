package com.tosad.brg.taskSpecific.persistence;

import com.tosad.brg.domain.project.Project;
import com.tosad.brg.hibernate.HibernateUtils;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ProjectPersistence {

    public static Project getLatestProject() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Project> criteria = builder.createQuery(Project.class);
        Root<Project> variableRoot = criteria.from(Project.class);
        criteria.select(variableRoot);

        return HibernateUtils.getSession().createQuery(criteria).getSingleResult();
    }

}
