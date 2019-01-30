var types = require("../../mixins/types");

module.exports = {

    mixins: [types],

    data: function () {
        return {
            // TODO: GET FROM API
            templates: [],
            selectedTemplate: null,
            template: {},
            schema: {},
            loading: false,
            error: false,
            loadingMain: false,
            errorMain: false
        }
    },

    methods: {
        getTemplates() {
            // Get the template information
            this.axios.get('https://brugii-manager.herokuapp.com/businessrule/types')
                .then(response => {
                    this.loadingMain = false;
                    if(response.data.length > 0) {
                        this.errorMain = true;
                    } else {
                        this.templates = response.data;
                    }
                });
        },

        getTemplateInformation() {
            this.loading = true;
            // Get the template information
            this.axios.get('https://brugii-manager.herokuapp.com/businessrule/type?id=' + this.selectedTemplate)
                .then(response => {
                    this.template = response.data;
                    this.loading = false;
                }, error => {
                    alert('Kan niet verbinden met ondora.');
                });
        },

        getSchemaData() {
            this.loadingMain = true;
            this.errorMain = false;
            this.axios.get('https://brugii-manager.herokuapp.com/businessrule/schema')
                .then(response => {
                    this.schema = response.data;
                    this.getTemplates();
                });
        },

        onSubmit() {
            this.loading = true;
            this.axios.post('https://brugii-manager.herokuapp.com/businessrule/create', JSON.stringify(this.template), {
                headers: {'Content-Type': "application/json"}
            })
                .then(response => {
                    this.loading = false;
                    new window.sw('Businessrule is toegevoegd', 'Navigeer naar de manager om hem te bekijken.', 'success');
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
    computed: {
        hasTemplate: function () {
            return JSON.stringify(this.template) !== '{}'
        }
    },
    created: function () {
        this.getSchemaData();
    }
}

