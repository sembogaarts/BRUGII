var gulp = require('gulp');
var sass = require('gulp-sass');
var concat = require('gulp-concat');

sass.compiler = require('node-sass');

gulp.task('sass', function () {
    return gulp.src('./sass/theme.scss')
        .pipe(sass({outputStyle: 'compressed'}).on('error', sass.logError))
        .pipe(gulp.dest('./css'));
});

gulp.task('default', function () {
    gulp.watch('./sass/**/*.scss', gulp.series('sass'));
});
