package com.tosad.brg;

import com.tosad.brg.hibernate.HibernateUtils;
import com.tosad.brg.taskSpecific.api.BusinessRuleJSON;
import com.tosad.brg.domain.businessRule.BusinessRule;
import com.tosad.brg.domain.businessRule.BusinessRuleTag;
import com.tosad.brg.domain.template.Template;
import com.tosad.brg.domain.template.TemplateTag;
import com.tosad.brg.taskSpecific.persistence.BusinessRulePersistence;
import com.tosad.brg.taskSpecific.persistence.BusinessRuleTagPersistence;
import com.tosad.brg.taskSpecific.persistence.TemplatePersistence;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.*;
import java.util.HashMap;
import java.util.List;


@Path("/")
public class Generator {

    @POST
    @Path("businessrule")
    @Produces("application/json")
    public String getCreate(String data) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONArray businessRuleIdJsonArray = (JSONArray) parser.parse(data);

        JSONArray jsonArray = new JSONArray();


        businessRuleIdJsonArray.forEach(o -> {

            long businessRuleId = (Long) o;

            BusinessRule businessRule = BusinessRulePersistence.getBusinessRuleById((int) businessRuleId);
            Template template = TemplatePersistence.getTemplateByBusinessRuleType(businessRule.businessRuleType);


            List<BusinessRuleTag> businessRuleTagList = BusinessRuleTagPersistence.getBusinessRuleTagsByBusinessRule(businessRule);
            HashMap<BusinessRuleTag, TemplateTag> businessRuleHashMap = BusinessRuleTagPersistence.getBusinessRuleHashMapByBusinessRuleTags(businessRuleTagList);

            JSONObject jsonObject = BusinessRuleJSON.generateJSON(businessRule, template, businessRuleHashMap);



            jsonArray.add(jsonObject);
        });


        HibernateUtils.close();

        return jsonArray.toJSONString();
    }
}
