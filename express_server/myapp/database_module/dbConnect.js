
const fs = require("fs");
const mysql = require('mysql');
const { MysqlError, PoolConnection } = require('mysql');
const { FieldInfo, GeometryType, Pool, PoolConfig } = require("mysql");
let pool = null;

if (fs.existsSync("./.dbtoken")) {
    console.log("attempting to connect...");
    const connectionObject = JSON.parse(fs.readFileSync("./.dbtoken").toString());
    connectionObject.connectionLimit = 10;
    connectionObject.typeCast = customCaster;
    pool = mysql.createPool( connectionObject );
} else {
    console.log(".dbtoken file not found, creating .dbtoken");
    const connectionObject = {
      host: "localhost",
      user: "root",
      password: "Hphuong131464",
      database: "csdept",
      insecureAuth : true
    };
    fs.writeFileSync("./.dbtoken", JSON.stringify(connectionObject, null, 4));
    console.log("Please fill out .dbtoken with the database connection info");
    process.exit(0);
}

pool.getConnection((err, connection) => {
    if (err) {
        console.error(err);
    }
    if (connection) {
        console.log("Established connection with database");
        connection.release();
    }
});

function customCaster( field, next){
    if (field.type === "BIT") {
        // convert the field into a list of bits, least significant at index 0
        const bytes = field.buffer();
        return bytes[0] === 1;
    }
    return next();
}

module.exports = pool; // here for javascript compatibility
