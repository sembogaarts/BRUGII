var types = require('../../mixins/types');

module.exports = {

    /* Input Properties */
    props: ['tag', 'tags', 'schema', 'index', 'loop', 'value', 'value', 'rowIndex', 'fieldIndex'],

    mixins: [types],

    data: function () {
        return {
            vb: this.value
        }
    },

    methods: {

        onInput(event) {
            this.$emit('update:value', event.target.value);
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

        getEarlierFieldType() {
            // First of all the
            if (this.loop) {
                for (var x = this.index; 0 <= x; x--) {
                    if (this.loop[x].type === 'COLUMN') {
                        if (typeof (this.loop[x].value[this.rowIndex]) != 'undefined') {
                            var table = this.loop[x].value[this.rowIndex].split('.');
                            return this.getColumnType(table[0], table[1]);
                        } else {
                            return '';
                        }
                    }
                }
            }
            for (var x = this.index; 0 <= x; x--) {
                if (this.tags[x].type === 'COLUMN') {
                    if (typeof (this.tags[x].value) != 'undefined') {
                        var table = this.tags[x].value.split('.');
                        return this.getColumnType(table[0], table[1]);
                    } else {
                        return '';
                    }
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

        /**
         * Get the columns for an earlier selected table
         * @returns {*|Array}
         */
        getColumnForEarlierTable() {
            if (this.loop) {
                // Check if the loop contains a table field.
                for (var x = this.fieldIndex; 0 <= x; x--) {
                    if (this.isTable(this.loop[x].type)) {
                        return this.fetchColumnsForTag(this.loop[x], true);
                    }
                }
            }
            // If there is not an table in de loop check for the root scope tags
            for (var x = this.index; 0 <= x; x--) {
                // Check if the tag is a table
                if (this.isTable(this.tags[x].type)) {
                    return this.fetchColumnsForTag(this.tags[x], false);
                }
            }
        },

        fetchColumnsForTag(tag, inLoop) {

            modifiedColumns = [];

            // Get the selected table
            var selectedTable = inLoop ? tag.value[this.rowIndex] : tag.value;

            console.log(selectedTable);

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



};

