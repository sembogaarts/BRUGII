package com.tosad.brm.web.api;

import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRule;
import com.tosad.brm.web.hibernate.domain.businessRule.BusinessRuleType;
import org.json.simple.JSONObject;

public class BusinessRuleTypeJSON implements ApiJSON {
    BusinessRuleType businessRuleType;

    public BusinessRuleTypeJSON(BusinessRuleType businessRuleType) {
        this.businessRuleType = businessRuleType;
    }

    public static JSONObject generate(BusinessRuleType businessRuleType) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", businessRuleType.id);
        jsonObject.put("name", businessRuleType.name);
        return jsonObject;
    }
}
