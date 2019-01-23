module.exports = {
    props: ['tag', 'tags', 'type', 'rowIndex', 'field'],
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

        onInput: function (event) {
            this.$emit('update:field', event.target.value);
        }

    },
    computed: {
        noType: function() {
            return this.type === '' || typeof(this.type) === 'undefined' || this.type === null;
        }
    }
};

