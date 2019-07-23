var con = require('./dbConnect');
const uuid = require('uuid/v1');

module.exports.userRegister = (username, password, fullName, type, callback) => {
  //console.log(password);
  var query = "INSERT INTO User (uid, username, password, fullName, type) VALUES (?,?,?,?,?)";
  con.query(query,[uuid(), username ,password,fullName, type], function(errors, results, field){
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


exports.editQuestion = function(editObj, callback){
  console.log(editObj);
  let query = "";
  if(editObj.question_type_id === 0 || editObj.question_type_id === 1){
    query = "UPDATE question SET content = '" + editObj.question_content + "', question_key ='" + editObj.question_key + "' WHERE qid = " + editObj.qid + ";";
  }
  else if( editObj.question_type_id === 2){
      query = "UPDATE question SET content = '" + editObj.question_content + "' WHERE qid = " + editObj.qid +  ";";
  }
	con.query(query, function(err, question, fields){
    if(err){
      callback(null, err);
    }
    else{
      if( editObj.question_type_id === 1){
        query = "DELETE from options WHERE question_qid =" + editObj.qid + ";";
        con.query(query, function(err, question, fields){
          if(err){
            callback(null, err);
          }

          query = "INSERT into options (question_qid, opt) VALUES ?";
          let values = [
            [editObj.qid, editObj.question_options[0]],
            [editObj.qid, editObj.question_options[1]],
            [editObj.qid, editObj.question_options[2]],
            [editObj.qid, editObj.question_options[3]]
          ];

          con.query(query, [values], function(err, newTopic, fields){
            if(err){
              callback(null, err);
            }

            callback({success: 'true'});
          });
        });
      }
      else{
        callback({success: 'true'});
      }
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



exports.createNewCourse = function( newCourse, callback){
	var query = "INSERT INTO course (course_name, user_uid) VALUES ?";
  let values = [
      [newCourse.course_name, newCourse.uid]
  ];
	con.query(query, [values], function(err, newTopic, fields){
    if(err){
      callback(null, err);
    }
    else{
      query = "Select cid, course_name, fullName, uid From course JOIN user ON user_uid = uid";
      con.query(query, function(err, allCourses, fields){
        if(err){
          callback(null, err);
        }
        else{
          callback(allCourses);
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

exports.editCourse = function( newCourseInfo,  callback){
  let query = "UPDATE course SET course_name = '" +  newCourseInfo.course_name + "'" +
            " WHERE cid =" + newCourseInfo.cid;

	con.query(query, function(err, newCourse, fields){
    if(err){
      callback(null, err);
    }
    else{
      query = "Select cid, course_name, fullName, uid From course JOIN user ON user_uid = uid";

      con.query(query, function(err, allCourses, fields){
        if(err){
          callback(null, err);
        }
        else{
          callback(allCourses);
        }
      });
    }
	});
}

exports.addTopicToCourse = function( topicObject, callback){
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

exports.removeTopicFromCourse = function( tid, cid,  callback){
  let query = "DELETE FROM course_topic WHERE course_cid =" + cid + " AND topic_tid = " + tid;

	con.query(query, function(err, newTopic, fields){
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

exports.deleteCourse = function(cid,  callback){
  let query = "DELETE FROM course WHERE cid = " + cid;

	con.query(query, function(err, newTopic, fields){
    if(err){
      callback(null, err);
    }
    else{
      query = "Select cid, course_name, fullName, uid From course JOIN user ON user_uid = uid";

      con.query(query, function(err, allCourses, fields){
        if(err){
          callback(null, err);
        }
        else{
          callback(allCourses);
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
