var types = require("../../mixins/types");

module.exports = {

    mixins: [types],

    data: function () {
        return {
            // TODO: GET FROM API
            selectedTemplate: null,
            template: {},
            schema: {},
            loading: false
        }
    },
    methods: {
        getBusinessRule(id) {
            this.loading = true;
            // Get the template information
            // this.axios.get('https://brugii-manager.herokuapp.com/businessrule/data?businessrule=' + id)
            this.axios.get('templates/attributeCompareRuleFilled.json')
                .then(response => {
                    this.template = response.data;
                    this.loading = false;
                });
        },
        getSchemaData() {
            this.axios.get('templates/schema.json')
                .then(response => {
                    this.schema = response.data.schema;
                    this.getBusinessRule(this.$route.params['id']);
                });
        },

        onSubmit() {
            this.loading = true;
            this.axios.post('http://localhost:8080/businessrule/create', this.template)
                .then(response => {
                    this.loading = false;
                    alert('De businessrule is toegevoegd');
                    this.template = {};
                });
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
                row = [];
                for (var y = 0; tag.fields.length > y; y++) {
                    var modifiedRow = {};
                    modifiedRow = tag.fields[y];
                    row.push(modifiedRow);
                }
                rows.push(row)
            }
            return rows;
        }

    },
    created: function () {
        this.getSchemaData();
    }
}

