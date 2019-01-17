define(function (require, exports, module) {

    module.exports = {

        raw: "ALTER TABLE {{ TABLE }} ADD CONSTRAINT {{ NAME }} CHECK ( {{ COLUMN }} [[ NOT ]] BETWEEN {{ NUMBER_1 }} AND {{ NUMBER_2 }} )",

        tags: [
            {
                name: "TABLE",
                type: "TABLE",
                value: ""
            },
            {
                name: "NAME",
                type: "STRING"
            },
            {
                name: "COLUMN",
                type: "COLUMN"
            },
            {
                name: "NUMBER_1",
                type: "NUMBER"
            },
            {
                name: "NUMBER_2",
                type: "NUMBER"
            },
            {
                name: "NOT",
                type: "BOOLEAN"
            }
        ]

    };

});
