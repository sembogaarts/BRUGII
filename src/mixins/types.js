module.exports =  {
    methods: {
        isType(type, compareTo) {
            return type.toLowerCase() === compareTo;
        },
        isNumber(type) {
            return this.isType("NUMBER", type);
        },
        isState(type) {
            return this.isType("STATE", type);
        },
        isEvent(type) {
            return this.isType("EVENT", type);
        },
        isString(type) {
            return this.isType("STRING", type);
        },
        isBoolean(type) {
            return this.isType("BOOLEAN", type);
        },
        isTable(type) {
            return this.isType("TABLE", type);
        },
        isColumn(type) {
            return this.isType("COLUMN", type);
        },
        isDynamic(type) {
            return this.isType("DYNAMIC", type);
        },
        isBinder(type) {
            return this.isType("BINDER", type);
        },
        isOperator(type) {
            return this.isType("OPERATOR", type);
        },
        isList(type) {
            return this.isType("LIST", type);
        },
        isLoop(type) {
            return this.isType("LOOP", type);
        },
        getOperatorsForNumber() {
            return [">", "<", ">=", "<=", "=", "!="];
        },
        getOperatorsForString() {
            return ["=", "!="];
        },
        binders() {
            return ["AND", "OR", "NOT"];
        }
    }
}
