package com.tosad.brm.web.taskSpecific.persistence;

import com.tosad.brm.web.hibernate.HibernateUtils;
import com.tosad.brm.web.domain.project.Project;
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
