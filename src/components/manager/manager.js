module.exports = {
    data: function () {
        return {
            project: "Manager",
            businessrules: [],
            createStatus: "",
            loading: false,
            checkedBusinessRules: []
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

        toggleCheckedBusinessRule(id) {
            var index = this.checkedBusinessRules.indexOf(id);
            if(index !== -1){
                console.log('exists');
                this.checkedBusinessRules.splice(index, 1);
            }
            else {
                console.log('does not exist');
                this.checkedBusinessRules.push(id);
            }
            console.log(this.checkedBusinessRules);
        },

        path(br) {
            return '/editor/' + br.id;
        }

    },
    created: function () {
        this.getBusinessRules();
    }

};
