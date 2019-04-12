var mysql = require('mysql');
var passport = require('passport');
var bcrypt = require('bcrypt');

var con = mysql.createConnection({
  host: "138.49.184.135",
  user: "root",
  password: "Hphuong131464",
  database: "csdept",
  insecureAuth : true
});

con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
});

module.exports = con;
