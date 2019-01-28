package com.tosad.brm.web.taskSpecific.api;

import com.tosad.brm.web.domain.businessRule.BusinessRule;
import com.tosad.brm.web.domain.businessRule.BusinessRuleType;
import com.tosad.brm.web.domain.project.Project;
import com.tosad.brm.web.taskSpecific.persistence.BusinessRuleTypePersistence;
import com.tosad.brm.web.taskSpecific.persistence.ProjectPersistence;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

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

    public static JSONArray parseBusinessRules(List<BusinessRule> businessRuleList) {
        JSONArray jsonArray = new JSONArray();

        businessRuleList.forEach(businessRule -> jsonArray.add(generateJSONObject(businessRule)));
        return jsonArray;
    }

    private static JSONObject generateJSONObject(BusinessRule businessRule) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", businessRule.id);
        jsonObject.put("name", businessRule.name);
        return jsonObject;
    }
}
