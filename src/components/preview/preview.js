module.exports = {
    data: function () {
        return {
            project: "Manager",
            businessrules: [],
            createStatus: "",
            loading: false
        }
    },
    methods: {
        getBusinessRules() {
            this.loading = true;
            this.axios.get('https://brugii-manager.herokuapp.com/businessrule/rules')
                .then(response => {
                    this.loading = false;
                    this.businessrules = response.data;
                }, error => {
                    new window.sw('Ondora is onbereikbaar', 'Herlaad de pagina of probeer het later opnieuw.', 'error');
                });
        },

        generateBusinessRule(id) {
            this.axios.get('http://localhost:8080/businessrule/generate?businessrule=' + id)
                .then(response => {
                    this.createStatus = response.data;
                });
        },

        path(br) {
            return '/editor/' + br.id;
        }

    },
    created: function () {
        this.getBusinessRules();
    }
};
