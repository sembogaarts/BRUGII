module.exports = {
    props: {
        tag: Object,
        tags: Array,
        schema: Array,
        index: Number
    },
    data: function () {
        return {
        }
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

        isBinder(type) {
            return this.isType("BINDER", type);
        },

        getOperatorsForNumber() {
            return [">", "<", ">=", "<=", "=", "!="];
        },

        binders() {
            return ["AND", "OR", "NOT"];
        },

        columns() {
            for (var x = 0; this.tags.length > x; x++) {
                // Check if the tag is a table
                if (this.isTable(this.tags[x].type)) {

                    // Get the selected table
                    var selectedTable = this.tags[x].value;

                    // Return columns for the specific table
                    return isNaN(parseInt(selectedTable)) ? [] : this.schema[selectedTable].columns;
                }
            }
        },

        getOperatorForEarlierField() {

        },
    }
};

