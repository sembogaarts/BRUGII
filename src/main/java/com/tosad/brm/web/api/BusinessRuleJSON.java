package com.tosad.brm.web.api;

import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRule;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRuleType;
import com.tosad.brm.web.hibernate.taskSpecific.Project;
import com.tosad.brm.web.persistence.BusinessRulePersistence;
import com.tosad.brm.web.persistence.BusinessRuleTypePersistence;
import com.tosad.brm.web.persistence.ProjectPersistence;
import org.json.simple.JSONObject;

import static java.lang.Integer.parseInt;

public class BusinessRuleJSON {

    public static BusinessRule parseBusinessRule(JSONObject jsonObject) {
        String name = (String) jsonObject.get("name");
        int id = ((Long) jsonObject.get("id")).intValue();
        BusinessRuleType businessRuleType = BusinessRuleTypePersistence.getBusinessRuleTypeById(id);

        // @TODO Change
        //  Get latest used project for now.
        Project project = ProjectPersistence.getLatestProject();
        return new BusinessRule(name, businessRuleType, project);
    }
}
