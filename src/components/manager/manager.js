module.exports = {
    data: function () {
        return {
            project: "Manager",
            businessrules: [],
            createStatus: "",
            loading: false,
            checkedBusinessRules: [],
            error: false
        }
    },
    methods: {
        getBusinessRules() {
            this.error = false;
            this.loading = true;
            this.axios.get('https://brugii-manager.herokuapp.com/businessrule/rules')
                .then(response => {
                    this.loading = false;
                    this.businessrules = response.data;
                }, error => {
                    this.loading = false;
                    this.error = true;
                    new window.sw('Ondora is onbereikbaar', 'Herlaad de pagina of probeer het later opnieuw.', 'error');
                });
        },

        isSelected(id) {
            return this.checkedBusinessRules.indexOf(id) != -1;
        },

        toggleAll() {
            if (this.businessrules.length != this.checkedBusinessRules.length) {

                for (var x = 0; this.businessrules.length > x; x++) {
                    if (this.checkedBusinessRules.indexOf(this.businessrules[x].id) == -1) {
                        this.checkedBusinessRules.push(this.businessrules[x].id);
                    }
                }
            } else {
                this.checkedBusinessRules = [];
            }
        },

        generateBusinessRules(data) {
            return {name: 'Preview', params: {businessrules: data}}
        },

        toggleCheckedBusinessRule(id) {
            var index = this.checkedBusinessRules.indexOf(id);
            if (index !== -1) {
                this.checkedBusinessRules.splice(index, 1);
            } else {
                this.checkedBusinessRules.push(id);
            }
        },

        path(br) {
            return '/editor/' + br.id;
        },

        deleteRules() {
            for (var x = 0; this.checkedBusinessRules.length > x; x++) {
                var name = this.checkedBusinessRules[x].name;
                this.axios.get("https://brugii-manager.herokuapp.com/businessrule/delete?businessrule=" + this.checkedBusinessRules[x].id)
                    .then(data => {
                        new window.sw('Businessrule is verwijderd', 'De volgende businessrule is verwijderd: ' + name, 'error');
                    }, error => {
                        new window.sw('Ondora is onbereikbaar', 'We gaan naar de volgende regel om te verwijderen.', 'error');
                    });
            }
        }

    },
    created: function () {
        this.getBusinessRules();
    }

};
