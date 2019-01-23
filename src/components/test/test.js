module.exports = {
    props: ['test', 'type'],
    data: function () {
        return {}
    },
    methods: {
        onChange(event) {
            this.$emit('update:test', event.target.value);
        }
    }
};

