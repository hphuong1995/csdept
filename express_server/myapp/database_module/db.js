var con = require('./dbConnect');

module.exports.userRegister = (username, password, email, fullName, type, callback) => {
  //console.log(password);
  var query = "INSERT INTO User ( username, email, password, fullName, type) VALUES (?,?,?,?,?)";
  con.query(query,[username, email,password,fullName, type], function(errors, results, field){
    if(errors) throw errors;
    callback({'valid': true}, undefined);
  });
}

exports.getAllTopics = (cid, callback) => {
	var query = "Select * From Topic JOIN course_topic ON tid = topic_tid WHERE course_cid =" + cid;

  con.query(query, (err, results) => {
    if(err) {
        callback(undefined, new Error(err.message, -10));
        return;
    }
    //console.log('passhash: ' + passhash);
    callback(results);
  });
}

exports.getAllQuestionByTopicId = (courseId, topicId, callback) => {
	let query = "Select * From question WHERE topic_question_tid ='" + topicId + "'";

  console.log(query);
  con.query(query, (err, results) => {
    if(err) {
        callback(undefined, new Error(err.message, -10));
        return;
    }
    //console.log('passhash: ' + passhash);
    callback(results);
  });
}

exports.getAllCourses = function(callback){
	var query = "Select cid, course_name, fullName From course JOIN user ON user_uid = uid";
	con.query(query, function(err, res, fields){
    if(err){
      callback(null, err);
    }
    else{
      callback(res);
    }
	});
}

exports.getOptionsOfMultQuestion = function(qid, callback){
	var query = "Select * FROM options WHERE question_qid =" + qid;
	con.query(query, function(err, res, fields){
    if(err){
      callback(null, err);
    }
    else{
      callback(res);
    }
	});
}


module.exports.getUserByLogin = (username, password, callback) => {
  let query = "SELECT * from User WHERE username ='" + username + "'";
    con.query(query, (err, results) => {
      if(err) {
          callback(undefined, new Error(err.message, -10));
          return;
      }

      if(results.length == 0) {
          callback(undefined, new Error("User not found.", -1));
          return;
      }

      const user_id = results[0];
      callback(results[0], null);
    });
}
