var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var expressValidator = require('express-validator');

var db = require('./database_module/dbConnect');

// Authentication packages
var session = require('express-session');

var passport = require('passport'),
    LocalStrategy = require('passport-local').Strategy;
var bcrypt = require('bcrypt');


var MySQLStore = require('express-mysql-session')(session);

var auth = require('./routes/authenticate');
var route = require('./routes/route');
var admin_route = require('./routes/admin_route');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

// uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());

function root( req, res, next ) {
  res.sendFile(path.join(__dirname, 'public', 'index.html'));
}

app.use("/",express.static(path.join(__dirname, 'public')));


var options = {
  host: "localhost",
  user: "root",
  password: "Hphuong131464",
  database: "csdept",
  insecureAuth : true
};

var sessionStore = new MySQLStore(options);

app.use( session( {
    cookie: {
        httpOnly: false,
        maxAge: 10 * 60 * 1000,
    },
    resave: false,
    secret: "csdept2019",
    store: sessionStore,
    saveUninitialized: false
} ) );

app.use(passport.initialize());
app.use(passport.session());

app.use(function (req, res, next){
    res.locals.isAuthenticated = req.isAuthenticated();
    next();
});

app.use(expressValidator());

const checkAdmRole = function(req, res, next) {
  if(req.user && req.user.type === 1){
    next();
  }
  else{
    res.status(403).send({message: 'Forbidden'});
  }
}

//Route
app.use('/', auth);
app.use('/api/v1/',  route);
app.use('/api/v1/admin', checkAdmRole, admin_route);
app.use("/**", (req, res, next) => {
  root( req, res, next );
});


// passport strategy
passport.use(new LocalStrategy(
  function(username, password, done) {
    db.query('SELECT * FROM User WHERE username = ?', [username] , (err, results, fields)=>{

      if(err) done(err);

      if(results && results.length === 0){
        done(null,false);
      }
      else{
        const hash = results[0].password.toString();
        const user = results[0];
        bcrypt.compare( password, hash, (err, response) =>{
          if( response === true){
            done(null, user);
          }
          else{
            done(null, false);
          }
        });
      }
    });
  }
));

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

console.log("now running");
module.exports = app;
