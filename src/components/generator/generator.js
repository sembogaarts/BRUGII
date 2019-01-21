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
            template: {}
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
        isType(type, compareTo) {
            return type === compareTo;
        },

        isNumber(type) {
            return this.isType("NUMBER", type);
        },

        isString(type) {
            return this.isType("STRING", type);
        },

        isBoolean(type) {
            return this.isType("BOOLEAN", type);
        },

        isTable(type) {
            return this.isType("TABLE", type);
        },

        isColumn(type) {
            return this.isType("COLUMN", type);
        },

        onSubmit() {
            console.log(this.template.tags);
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
        }
    },
    computed: {
        hasTemplate: function () {
            return JSON.stringify(this.template) !== '{}'
        },
        pagename: function() {
            return this.$route.name;
        }
    }
}
