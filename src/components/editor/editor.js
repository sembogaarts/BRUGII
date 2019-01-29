var types = require("../../mixins/types");

module.exports = {

    mixins: [types],

    data: function () {
        return {
            // TODO: GET FROM API
            selectedTemplate: null,
            template: {},
            schema: {},
            loading: false,
            error: false,
            id: Number
        }
    },
    methods: {
        getBusinessRule() {
            this.loading = true;
            this.error = false;
            // Get the template information
            this.axios.get('https://brugii-manager.herokuapp.com/businessrule/data?businessrule=' + this.id)
                .then(response => {
                    this.template = response.data;
                    this.loading = false;
                }, error => {
                    this.error = true;
                    this.loading = false;
                    new window.sw('Ondora is onbereikbaar', 'Herlaad de pagina of probeer het later opnieuw.', 'error');
                });
        },
        getSchemaData() {
            this.axios.get('https://brugii-manager.herokuapp.com/businessrule/schema')
                .then(response => {
                    this.schema = response.data;
                    this.getBusinessRule();
                });
        },
        onSubmit() {
            this.loading = true;
            this.axios.post('https://brugii-manager.herokuapp.com/businessrule/update?id=' + this.id, this.template)
                .then(response => {
                    this.loading = false;
                    new window.sw('Businessrule is bijgewerkt', 'Deploy de businessrule opnieuw.', 'success');
                }, error => {
                    this.loading = false;
                    new window.sw('Ondora is onbereikbaar', 'Herlaad de pagina of probeer het later opnieuw.', 'error');
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
        this.id = this.$route.params['id'];
        this.getSchemaData();
    }
}

