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
	var query = "Select cid, course_name, fullName, uid From course JOIN user ON user_uid = uid";
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

exports.getAllTopicsFiltered = function(cid, callback){
	var query = "Select tid From Topic JOIN course_topic ON tid = topic_tid WHERE course_cid =" + cid;
	con.query(query, function(err, topicToFiler, fields){
    if(err){
      callback(null, err);
    }
    else{
      query = "Select * from topic";
      con.query(query, function(err, allTopics, fields){
        if(err){
          callback(null, err);
        }
        else{
          let arrayTid = [];
          topicToFiler.forEach(topic =>{
            arrayTid.push(topic.tid);
          });
          allTopics = allTopics.filter( topic => !arrayTid.includes(topic.tid));
          callback(allTopics);
        }
      });
    }
	});
}

exports.addTopicToCourse = function( topicObject, callback){
  console.log(topicObject);
	var query = "INSERT INTO course_topic (topic_tid, course_cid) VALUES ?";
  let values = [
      [topicObject.tid, topicObject.cid]
  ];
	con.query(query, [values], function(err, newTopic, fields){
    if(err){
      callback(null, err);
    }
    else{
      query = "Select * From Topic JOIN course_topic ON tid = topic_tid WHERE course_cid =" + topicObject.cid;
      con.query(query, function(err, allTopics, fields){
        if(err){
          callback(null, err);
        }
        else{
          callback(allTopics);
        }
      });
    }
	});
}

exports.updateTopic = function( topicObject, cid,  callback){
  topicObject.date = new Date(topicObject.date).toString();
  let query = "UPDATE course_topic SET date = '" +  topicObject.date + "'" +
            " WHERE topic_tid =" + topicObject.tid + " AND course_cid=" + cid;

	con.query(query, function(err, newTopic, fields){
    if(err){
      callback(null, err);
    }
    else{
      let query = "UPDATE topic SET topic_name = '" +  topicObject.topic_name + "'" +
                " WHERE tid =" + topicObject.tid;

      con.query(query, function(err, allTopics, fields){
        if(err){
          callback(null, err);
        }
        else{
          query = "Select * From Topic JOIN course_topic ON tid = topic_tid WHERE course_cid =" + cid;

          con.query(query, function(err, allTopics, fields){
            if(err){
              callback(null, err);
            }
            else{
              callback(allTopics);
            }
          });
        }
      });
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
