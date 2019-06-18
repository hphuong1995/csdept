var express = require('express');
var router = express.Router();
var db = require('./../database_module/db');
var expressValidator = require('express-validator');


router.post('/courses/:cid/topics', function(req, res, next) {
  db.addTopicToCourse(req.body,(topics,err)=>{
    if(err){
        res.status(500).send(err);
    }
    else{
      res.status(200).send(topics);
    }
  });
});

router.put('/courses/:cid/topics/:tid', function(req, res, next) {
  db.updateTopic(req.body, req.params.cid,(topics,err)=>{
    if(err){
        res.status(500).send(err);
    }
    else{
      res.status(200).send(topics);
    }
  });
});

router.delete('/courses/:cid/topics/:tid', function(req, res, next) {
  db.removeTopicFromCourse(req.params.tid , req.params.cid,(topics,err)=>{
    if(err){
        res.status(500).send(err);
    }
    else{
      res.status(200).send(topics);
    }
  });
});

router.delete('/courses/:cid/', function(req, res, next) {
  db.deleteCourse(req.params.cid,(courses,err)=>{
    if(err){
        res.status(500).send(err);
    }
    else{
      res.status(200).send(courses);
    }
  });
});

router.put('/courses/:cid/', function(req, res, next) {
  db.editCourse(req.body,(courses,err)=>{
    if(err){
        res.status(500).send(err);
    }
    else{
      res.status(200).send(courses);
    }
  });
});

router.post('/courses', function(req, res, next) {
  console.log(req.body);
  db.createNewCourse(req.body ,(courses,err)=>{
    if(err){
        res.status(500).send(err);
    }
    else{
      res.status(200).send(courses);
    }
  });
});



module.exports = router;
