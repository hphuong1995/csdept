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

  db.getAllTopics( req.params.cid, (topics,err)=>{
    if(err){
        res.status(500).send(err);
    }
    else{
      res.status(200).send(topics);
    }
  });
});

router.get('/courses/:cid/topics/:tid/questions', function(req, res, next) {
  db.getAllQuestionByTopicId(req.params.cid, req.params.tid, (questions,err)=>{
    if(err){
        res.status(500).send(err);
    }
    else{
      res.status(200).send(questions);
    }
  });
});

router.get('/questions/:qid/options', function(req, res, next) {
  db.getOptionsOfMultQuestion(req.params.qid, (options,err)=>{
    if(err){
        res.status(500).send(err);
    }
    else{
      res.status(200).send(options);
    }
  });
});

router.get('/topics', function(req, res, next) {
  db.getAllTopicsFiltered(req.query.cid,(topics,err)=>{
    if(err){
        res.status(500).send(err);
    }
    else{
      res.status(200).send(topics);
    }
  });
});


function authenticationMiddleware(){
  return (req,res,next) =>{
    if( req.isAuthenticated()) return next();
    // somehow redirect to login
    res.status(400).send({redirect: "/login"});
  }
}

module.exports = router;
