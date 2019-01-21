module.exports = {

    data: function () {
        return {
            // TODO: GET FROM API
            templates: [
                {
                    id: 'attributeCompareRule.json',
                    name: 'Attribute Compare Rule'
                },
                {
                    id: 'attributeRangeRule.json',
                    name: 'Attribute Range Rule'
                },
                {
                    id: "tupleCompareRule.json",
                    name: 'Tuple Compare Rule'
                },
                {
                    id: "InterEntityCompareRule.json",
                    name: 'Inter-Entity Compare Rule'
                }
            ],
            selectedTemplate: null,
            template: {},
            schema: {}
        }
    },
    methods: {
        getTemplateInformation() {
            // Get the template information
            this.axios.get('templates/' + this.selectedTemplate)
                .then(response => {
                    this.template = response.data;
                });
        },
        getSchemaData() {
            this.axios.get('templates/schema.json')
                .then(response => {
                    this.schema = response.data.schema;
                });
        },

        isType(type, compareTo) {
            return type === compareTo;
        },

        isLoop(type) {
            return this.isType("LOOP", type);
        },

        onSubmit() {
            console.log(this.template.tags);
        },

        getOperatorsForNumber() {
            return [">", "<", ">=", "<=", "=", "!="];
        },

        columns() {
            for (var x = 0; this.template.tags.length > x; x++) {
                // Check if the tag is a table
                if (this.isTable(this.template.tags[x].type)) {

                    // Get the selected table
                    var selectedTable = this.template.tags[x].value;

                    // Return columns for the specific table
                    return isNaN(parseInt(selectedTable)) ? [] : this.schema[selectedTable].columns;
                }
            }
        },

        getOperatorForEarlierField() {

        },

        addLoopRow(tag) {
            // Loop door alle velden heen en voeg een lege waarde eraan toe
            for (var x = 0; tag.fields.length > x; x++) {
                tag.fields[x].value.push("");
            }
        },


        getLoopRows(tag) {
            // The actual sorted rows
            rows = [];

            // Check the count of the rows that have to exists
            for (var x = 0; tag.fields[0].value.length > x; x++) {
                row = []
                for (var y = 0; tag.fields.length > y; y++) {
                    var modifiedRow = {};
                    modifiedRow = Object.assign({}, tag.fields[y]);
                    modifiedRow['value'] = tag.fields[y].value[x];
                    row.push(modifiedRow);
                }
                rows.push(row)
            }

            console.log(rows);

            return rows;
        }

    },
    computed: {
        hasTemplate: function () {
            return JSON.stringify(this.template) !== '{}'
        }
    },
    created: function () {
        this.getSchemaData();
    }
}

