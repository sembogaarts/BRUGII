module.exports = {
    props: ['businessrules'],
    data: function () {
        return {
            templates: []
        }
    },
    methods: {

    },
    created: function() {
        console.log(this.businessrules);
    }
};
