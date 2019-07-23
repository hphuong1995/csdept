var express = require('express');
var router = express.Router();
var db = require('./../database_module/db');
var expressValidator = require('express-validator');
var bcrypt = require('bcrypt');
const saltRounds = 10;
var passport = require('passport');



router.post('/api/v1/register', function( req, res, next){
  req.checkBody('username', 'Username field can not be empty').notEmpty();
  req.checkBody('password', 'Username field can not be empty').notEmpty();
  req.checkBody('fullName', 'Username field can not be empty').notEmpty();

  const errors = req.validationErrors();

  if(errors){
    res.status(200).send({'message': errors});
  }

  var username = req.body.username;
  var password = req.body.password;
  var fullName = req.body.fullName;

  bcrypt.hash(password, saltRounds, function(err, hash) {
    // Store hash in your password DB.
    db.userRegister(username, hash ,fullName, 0, (user, error) => {
      if(error) throw error;
      res.status(200).send(user);
    });
  });
});

router.post('/api/v1/login',
  passport.authenticate('local', { failureRedirect: 'login' }),
  function(req, res) {
    delete req.user.password;
    console.log("here");
    req.user.success = true;
    res.status(200).send(req.user);
  });

router.get('/api/v1/logout',function(req, res){
  req.logout();
  req.session.destroy();
  res.status(200).send({'success' : true, 'redirect' : 'login'});
});


passport.serializeUser(function(user_id, done) {
  done(null, user_id);
});

passport.deserializeUser(function(user_id, done) {
  done(null, user_id);
});

module.exports = router;
