module.exports = {
    props: ['businessrules'],
    data: function () {
        return {
            templates: [],
            loading:false,
            error: false,
            succesfullDeploy:false
        }
    },
    methods: {
        getTemplates() {
            this.loading = true;
            this.error = false;
            this.axios.post('https://brugii-generator.herokuapp.com/api/businessrule', this.businessrules)
                .then(response => {
                    this.templates = response.data;
                    this.loading = false;
                }, error => {
                    this.error = true;
                    this.loading = false;
                });
        },
        deployBusinessRules() {
            this.axios.post('https://brugii-generator.herokuapp.com/api/execute', this.businessrules)
                .then(response => {
                    new window.sw('Businessrule is uitgevoerd!', 'Er is een businessrule toegevoegd aan de database.', 'success');
                }, error => {
                    new window.sw('Er is iets goed misgegaan.', 'Probeer het anders later even overnieuw.', 'error');
                });
        }
    },
    created: function() {
        this.getTemplates();
    }
};
