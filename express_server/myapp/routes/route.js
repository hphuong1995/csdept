var express = require('express');
var router = express.Router();
var db = require('./../database_module/db');
var expressValidator = require('express-validator');
var multer = require('multer');

const exec = require('child_process').exec;


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

var currentDirectory = '';

var store = multer.diskStorage({
    destination:function(req,file,cb){
      currentDirectory = file.originalname.substr(0,file.originalname.length -5);
      console.log('./codes/' + file.originalname.substr(0,file.originalname.length -5) + '/src/student');
        cb(null, './codes/' + file.originalname.substr(0,file.originalname.length -5) + '/src/student');
    },
    filename:function(req,file,cb){
        cb(null, file.originalname);
    }
});

var upload = multer({storage:store}).single('file');

router.post('/questions/uploadAnswer', function(req, res, next) {
  upload(req,res,function(err){
    if(err){
      return res.status(501).json({error: err});
    }

    var yourscript = exec('sh ./codes/test.sh /codes/' + currentDirectory + '/src', (error, stdout, stderr) => {
        console.log(stdout);
        console.log(stderr);
        if (error !== null) {
            console.log(`exec error: ${error}`);
        }
        res.json({output: stdout});
    });
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
