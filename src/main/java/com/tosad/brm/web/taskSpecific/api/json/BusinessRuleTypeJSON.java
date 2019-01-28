package com.tosad.brm.web.taskSpecific.api.json;

import com.tosad.brm.web.domain.businessRule.BusinessRuleType;
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
