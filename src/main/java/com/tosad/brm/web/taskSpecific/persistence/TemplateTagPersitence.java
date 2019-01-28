package com.tosad.brm.web.taskSpecific.persistence;

import com.tosad.brm.web.hibernate.HibernateUtils;
import com.tosad.brm.web.domain.template.TemplateTag;
import org.hibernate.SessionFactory;

public class TemplateTagPersitence {

    public static TemplateTag getById(int id) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        return HibernateUtils.getSession().get(TemplateTag.class, id);
    }
}
