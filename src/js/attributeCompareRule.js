

    module.exports = {

        raw: "ALTER TABLE {{ TABLE }} ADD CONSTRAINT {{ NAME }} CHECK ( {{ COLUMN }} {{ OPERATOR }} {{ VALUE }} )",

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
                name: "OPERATOR",
                type: "OPERATOR"
            },
            {
                name: "VALUE",
                type: "STRING"
            }
        ]

    };

