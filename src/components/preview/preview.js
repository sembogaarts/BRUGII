module.exports = {
    props: ['businessrules'],
    data: function () {
        return {
            templates: [],
            loading:false,
            error: false,
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
        }
    },
    created: function() {
        this.getTemplates();
    }
};
