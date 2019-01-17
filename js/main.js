require([
    'js/attributeRangeRule',
    'js/attributeCompareRule',
], function (attributeRangeRule, attributeCompareRule) {


    var app = new Vue({
        el: '#app',
        data: {

            schema: [
                {
                    name: "Gebruiker",
                    columns: [
                        {
                            name: "Leeftijd",
                            type: "NUMBER"
                        }
                    ]
                }
            ],

            template: attributeCompareRule

        },

        methods: {

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
    })


});
