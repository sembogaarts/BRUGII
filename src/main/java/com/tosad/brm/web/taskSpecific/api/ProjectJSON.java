package com.tosad.brm.web.taskSpecific.api;

import com.tosad.brm.web.domain.project.Column;
import com.tosad.brm.web.domain.project.Table;
import com.tosad.brm.web.domain.template.Template;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

import static com.tosad.brm.web.taskSpecific.persistence.ProjectPersistence.getColumnsByTable;

public class ProjectJSON implements ApiJSON {
    public static JSONArray generateFromList(List<Table> tables) {
        JSONArray jsonArray = new JSONArray();
        tables.forEach(table -> {
            jsonArray.add(generateTable(table));
        });

        return jsonArray;
    }

    public static JSONObject generateTable(Table table) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", table.name);
        jsonObject.put("columns", generateColumns(getColumnsByTable(table)));
        return jsonObject;
    }

    private static JSONArray generateColumns(List<Column> columns) {
        JSONArray jsonArray = new JSONArray();
        columns.forEach(column -> jsonArray.add(generateColumn(column)));
        return jsonArray;
    }

    private static JSONObject generateColumn(Column column) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", column.name);
        jsonObject.put("type", column.type);
        return jsonObject;
    }
}
