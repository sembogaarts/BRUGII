module.exports = {
    data: function() {
        return {
            project: "Manager",
            businessrules : [],
            createStatus : ""
        }
    },
    methods: {
        getBusinessRules() {
            this.axios.get('http://localhost:8080/businessrule/rules')
                .then(response => {
                    this.businessrules = response.data;
                });
        },

        generateBusinessRule(id) {
            this.axios.get('http://localhost:8080/businessrule/generate?businessrule=' + id)
                .then(response => {
                    this.createStatus = response.data;
                });
        }

    }
};
