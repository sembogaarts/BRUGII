module.exports = {
    props: ['businessrules'],
    data: function () {
        return {
            templates: [{name:"brg_Gebruiker_cns_ACR", template: "ALTER TABLE suppliers ADD CONSTRAINT check_supplier_name CHECK (supplier_name IN ('IBM', 'Microsoft', 'NVIDIA'));"},
                {name:"brg_Gebruiker_cns_ACR", template: "ALTER TABLE suppliers ADD CONSTRAINT check_supplier_name CHECK (supplier_name IN ('IBM', 'Microsoft', 'NVIDIA'));"}]
        }
    },
    methods: {

    },
    created: function() {
        console.log(this.businessrules);
    }
};
