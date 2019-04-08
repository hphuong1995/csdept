var express = require('express');
var router = express.Router();
var db = require('./../database_module/db');
var expressValidator = require('express-validator');

router.get('/courses', function(req, res, next) {
  //console.log(req.isAuthenticated());
  db.getAllCourses( (courses)=>{
    res.status(200).send(courses);
  });
});

router.get('/courses/:cid/topics', function(req, res, next) {
  console.log("reach");
  db.getAllTopics( (topics)=>{
    console.log(topics);
    res.status(200).send(topics);
  });
});

router.get('/courses/:cid/topics/:tid/questions', function(req, res, next) {
  console.log("reach");
  db.getAllQuestionByTopicId(req.params.cid, req.params.tid, (topics)=>{
    console.log(topics);
    res.status(200).send(topics);
  });
});

function authenticationMiddleware(){
  return (req,res,next) =>{
    console.log( `req.session.passport.user : ${JSON.stringify(req.session.passport)}`);
    if( req.isAuthenticated()) return next();
    // somehow redirect to login
    res.status(400).send({redirect: "/login"});
  }
}

module.exports = router;
