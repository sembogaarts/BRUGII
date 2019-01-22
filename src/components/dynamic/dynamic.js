module.exports = {
    props: {
        tag: Object,
        tags: Array,
        type: String
    },
    data: function () {
        return {}
    },
    methods: {
        isType(type, compareTo) {
            return type === compareTo;
        },

        isNumber(type) {
            return this.isType("NUMBER", type);
        },

        isString(type) {
            return this.isType("STRING", type);
        },

        isBoolean(type) {
            return this.isType("BOOLEAN", type);
        },
    },
    computed: {
        noType: function() {
            return this.type === '' || typeof(this.type) === 'undefined' || this.type === null;
        }
    }
};

