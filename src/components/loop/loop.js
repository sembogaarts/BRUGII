module.exports = {
    props: {
        tag: Object,
        tags: Array,
        schema: Array,
        index: Number,
        loop: Array,
        rowIndex: Number
    },
    data: function () {
        return {}
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

        isDynamic(type) {
            return this.isType("DYNAMIC", type);
        },

        isBinder(type) {
            return this.isType("BINDER", type);
        },

        isOperator(type) {
            return this.isType("OPERATOR", type);
        },

        getOperatorsForNumber() {
            return [">", "<", ">=", "<=", "=", "!="];
        },

        getOperatorsForString() {
            return ["=", "!="];
        },

        binders() {
            return ["AND", "OR", "NOT"];
        },

        columns() {
            // Check if the loop contains a table field.
            for (var x = 0; this.loop.length > x; x++) {
                if (this.isTable(this.loop[x].type)) {
                    return this.fetchColumnsForTag(this.loop[x]);
                }
            }
            // If there is not an table in de loop check for the root scope tags
            for (var x = 0; this.tags.length > x; x++) {
                // Check if the tag is a table
                if (this.isTable(this.tags[x].type)) {
                    return this.fetchColumnsForTag(this.tags[x]);
                }
            }
        },

        fetchColumnsForTag(tag) {

            modifiedColumns = [];

            // Get the selected table
            var selectedTable = tag.value;

            if (selectedTable !== null && selectedTable !== '' && typeof (selectedTable) != 'undefined') {

                var table = {};

                for (let z = 0; this.schema.length > z; z++) {
                    if (this.schema[z].name == selectedTable) {
                        table = this.schema[z];
                    }
                }

                for (var y = 0; table.columns.length > y; y++) {
                    modifiedColumns.push({
                        name: table.name + '.' + table.columns[y].name,
                        type: table.columns[y].type
                    });
                }

            }

            // Return columns for the specific table
            return modifiedColumns;

        },

        getEarlierFieldType() {
            for (var x = this.index; 0 <= x; x--) {
                if (this.loop[x].type == 'COLUMN') {
                    var table = this.loop[x].value[this.rowIndex].split('.');
                    return this.getColumnType(table[0], table[1]);
                }
            }
        },

        getOperatorsForEarlierField() {

            var type = this.getEarlierFieldType();

            if (this.isNumber(type)) {
                return this.getOperatorsForNumber();
            } else if (this.isString(type)) {
                return this.getOperatorsForString();
            }

            return [];
        },

        getColumnType(table, column) {
            for (let z = 0; this.schema.length > z; z++) {
                if (this.schema[z].name == table) {
                    for (let x = 0; this.schema[z].columns.length > x; x++) {
                        if (this.schema[z].columns[x].name == column) {
                            return this.schema[z].columns[x].type;
                        }
                    }
                }
            }
        }
    }

}
;

