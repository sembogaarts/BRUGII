'use strict'

const { VueLoaderPlugin } = require('vue-loader');

module.exports = {
    mode: 'development',
    entry: [
        './src/js/app.js',
        './src/sass/theme.scss'
    ],
    module: {
        rules: [
            {
                test: /\.vue$/,
                use: 'vue-loader'
            },
            {
                test: /\.scss$/,
                use: [
                    "style-loader", // creates style nodes from JS strings
                    "css-loader", // translates CSS into CommonJS
                    "sass-loader" // compiles Sass to CSS, using Node Sass by default
                ]
            },
        ],
    },
    plugins: [
        new VueLoaderPlugin()
    ],
    watch: true
}
