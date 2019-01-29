package com.tosad.brm.web.taskSpecific.api;

import com.tosad.brm.web.domain.businessRule.BusinessRule;
import com.tosad.brm.web.domain.businessRule.BusinessRuleTag;
import com.tosad.brm.web.domain.businessRule.BusinessRuleType;
import com.tosad.brm.web.domain.project.Project;
import com.tosad.brm.web.domain.template.Template;
import com.tosad.brm.web.domain.type.TemplateTagType;
import com.tosad.brm.web.taskSpecific.persistence.BusinessRuleTypePersistence;
import com.tosad.brm.web.taskSpecific.persistence.ProjectPersistence;
import org.apache.tomcat.util.buf.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.tosad.brm.web.taskSpecific.persistence.TemplatePersistence.getTemplateByBusinessRuleType;
import static java.lang.Integer.parseInt;

public class BusinessRuleJSON {

    public static BusinessRule parseBusinessRule(JSONObject jsonObject) {
        String name = (String) jsonObject.get("name");
        int id = ((Long) jsonObject.get("id")).intValue();
        BusinessRuleType businessRuleType = BusinessRuleTypePersistence.getBusinessRuleTypeById(id);

        // @TODO Change
        //  Get latest used project for now.
        Project project = ProjectPersistence.getLatestProject();
        return new BusinessRule(name, businessRuleType, project, false);
    }

    public static JSONArray parseBusinessRules(List<BusinessRule> businessRuleList) {
        JSONArray jsonArray = new JSONArray();

        businessRuleList.forEach(businessRule -> jsonArray.add(generateJSONObject(businessRule)));
        return jsonArray;
    }

    private static JSONObject generateJSONObject(BusinessRule businessRule) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", businessRule.id);
        jsonObject.put("active", businessRule.active);
        jsonObject.put("name", businessRule.name);
        return jsonObject;
    }

    public static String generateBusinessRuleName(BusinessRule businessRule, List<BusinessRuleTag> businessRuleTags, Template template) {
        // brg_gebruiker_cns_arng_01
        ArrayList name = new ArrayList();
        name.add("brg");
        businessRuleTags.forEach(businessRuleTag -> {
            if (businessRuleTag.templateTag.getTemplateTagType() == TemplateTagType.TABLE) {
                name.add(businessRuleTag.value);
            }
        });

        name.add(getCategorieTypeByTemplate(template));
        name.add(businessRule.getPrefix());

        return String.join("_", name).toLowerCase();
    }

    private static String getCategorieTypeByTemplate(Template template) {
        return template.script.contains("TRIGGER") ? "trg" : "cns";
    }
}
