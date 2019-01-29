package com.tosad.brm.web.taskSpecific.persistence;

import com.tosad.brm.web.domain.businessRule.BusinessRuleType;
import com.tosad.brm.web.domain.project.Column;
import com.tosad.brm.web.domain.project.Project;
import com.tosad.brm.web.domain.project.Table;
import com.tosad.brm.web.domain.template.Template;
import com.tosad.brm.web.hibernate.HibernateUtils;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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


    public static List<Table> getAllTables() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Table> criteria = builder.createQuery(Table.class);
        Root<Table> variableRoot = criteria.from(Table.class);
        criteria.select(variableRoot);

        return HibernateUtils.getSession().createQuery(criteria).getResultList();
    }


    public static List<Column> getColumnsByTable(Table table) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        CriteriaBuilder builder = HibernateUtils.getSession().getCriteriaBuilder();

        CriteriaQuery<Column> query = builder.createQuery(Column.class);
        Root<Column> root = query.from(Column.class);

        query.select(root).where(builder.equal(root.get("tables"), table.id));


        return HibernateUtils.getSession().createQuery(query).getResultList();
    }
}
