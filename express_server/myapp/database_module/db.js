var con = require('./dbConnect');

module.exports.userRegister = (username, password, email, fullName, type, callback) => {
  //console.log(password);
  var query = "INSERT INTO USER ( username, email, password, fullName, type) VALUES (?,?,?,?,?)";
  con.query(query,[username, email,password,fullName, type], function(errors, results, field){
    if(errors) throw errors;
    callback({'valid': true}, undefined);
  });
}

exports.getAllTopics = (callback) => {
	var query = "Select * From Topic";

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
	let query = "Select * From Question Where cid ='" + courseId + "'" + " AND tid ='" + topicId + "'";

  console.log(query);
  con.query(query, (err, results) => {
    if(err) {
        callback(undefined, new Error(err.message, -10));
        return;
    }
    console.log(results);
    //console.log('passhash: ' + passhash);
    callback(results);
  });
}

exports.getAllCourses = function(cb){
	var query = "Select * From Course";
	con.query(query, function(err, res, fields){
    console.log(res);
	  cb(res);
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
