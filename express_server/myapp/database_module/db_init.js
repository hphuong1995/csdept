const pool = require('./dbConnect');
const uuid = require('uuid/v1');
const bcrypt = require('bcrypt');
const initQueue = [];
const fs = require('fs');

const USER_TABLE =
"CREATE TABLE `csdept`.`user` (\
  `uid` VARCHAR(45) NOT NULL,\
  `username` VARCHAR(45) NULL,\
  `password` VARCHAR(100) NULL,\
  `fullName` VARCHAR(45) NULL,\
  `type` INT NULL,\
  PRIMARY KEY (`uid`),\
  UNIQUE INDEX `uid_UNIQUE` (`uid` ASC),\
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) );";

const COURSE_TABLE =
"CREATE TABLE `csdept`.`course` (\
  `cid` INT NOT NULL AUTO_INCREMENT,\
  `course_name` VARCHAR(45) NOT NULL,\
  `user_uid` VARCHAR(45) NOT NULL,\
  PRIMARY KEY (`cid`),\
  UNIQUE INDEX `cid_UNIQUE` (`cid` ASC) ,\
  INDEX `user_uid_idx` (`user_uid` ASC) ,\
  CONSTRAINT `user_uid`\
    FOREIGN KEY (`user_uid`)\
    REFERENCES `csdept`.`user` (`uid`)\
    ON DELETE NO ACTION\
    ON UPDATE NO ACTION);";

const TOPIC_TABLE =
"CREATE TABLE `csdept`.`topic` (\
  `tid` INT NOT NULL AUTO_INCREMENT,\
  `topic_name` VARCHAR(45) NOT NULL,\
  PRIMARY KEY (`tid`),\
  UNIQUE INDEX `tid_UNIQUE` (`tid` ASC));";

const QUESTION_TABLE =
"CREATE TABLE `csdept`.`question` (\
  `qid` INT NOT NULL AUTO_INCREMENT,\
  `content` VARCHAR(10000) NULL,\
  `topic_question_tid` INT NOT NULL,\
  `question_key` VARCHAR(5000) NULL,\
  `type_id` INT NOT NULL,\
  PRIMARY KEY (`qid`),\
  INDEX `topic_question_tid_idx` (`topic_question_tid` ASC) ,\
  UNIQUE INDEX `qid_UNIQUE` (`qid` ASC) ,\
  CONSTRAINT `topic_question_tid`\
    FOREIGN KEY (`topic_question_tid`)\
    REFERENCES `csdept`.`topic` (`tid`)\
    ON DELETE NO ACTION\
    ON UPDATE NO ACTION);";


const OPTIONS_TABLE =
"CREATE TABLE `csdept`.`options` (\
  `question_qid` INT NOT NULL,\
  `opt` VARCHAR(150) NOT NULL,\
  INDEX `question_qid_idx` (`question_qid` ASC) ,\
  CONSTRAINT `question_qid`\
    FOREIGN KEY (`question_qid`)\
    REFERENCES `csdept`.`Question` (`qid`)\
    ON DELETE NO ACTION\
    ON UPDATE NO ACTION);";

const COURSE_TOPIC_TABLE =
"CREATE TABLE `csdept`.`course_topic` (\
  `course_cid` INT NOT NULL,\
  `topic_tid` INT NOT NULL,\
  `date` VARCHAR(100) NULL,\
  INDEX `course_cid_idx` (`course_cid` ASC) ,\
  INDEX `topic_tid_idx` (`topic_tid` ASC) ,\
  CONSTRAINT `course_cid`\
  FOREIGN KEY (`course_cid`)\
  REFERENCES `csdept`.`course` (`cid`)\
  ON DELETE NO ACTION\
  ON UPDATE NO ACTION,\
  CONSTRAINT `topic_tid`\
  FOREIGN KEY (`topic_tid`)\
  REFERENCES `csdept`.`topic` (`tid`)\
  ON DELETE NO ACTION\
  ON UPDATE NO ACTION);";


/*
 * Functions added to the queue will be executed in FIFO order
 */
initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    pool.getConnection((err, connection) => {
        if (err) {
            connection.release();
            console.error("DB initilization failed");
            process.exit(-1);
        }
        next(connection, initQueue);
    });
});

initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    connection.beginTransaction((err) => {
        if (err) {
            throw err;
        }
        next(connection, initQueue);
    });
});

initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    let query = "SET FOREIGN_KEY_CHECKS = 0;";
    connection.query(query, (err, res, fields) => {
        if (err) rollbackAndExit(connection, err);
        next(connection, initQueue);
    });
});


initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    let query = "DROP TABLE IF EXISTS user, question, course, topic, options,course_topic;";
    connection.query(query, (err, res, fields) => {
        if (err) rollbackAndExit(connection, err);
        next(connection, initQueue);
    });
});


initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    let query = USER_TABLE;
    connection.query(query, (err, res, fields) => {
        if (err) rollbackAndExit(connection, err);
        next(connection, initQueue);
    });
});

initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    let query = COURSE_TABLE;
    connection.query(query, (err, res, fields) => {
        if (err) rollbackAndExit(connection, err);
        next(connection, initQueue);
    });
});

initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    let query = TOPIC_TABLE;
    connection.query(query, (err, res, fields) => {
        if (err) rollbackAndExit(connection, err);
        next(connection, initQueue);
    });
});

initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    let query = QUESTION_TABLE;
    connection.query(query, (err, res, fields) => {
        if (err) rollbackAndExit(connection, err);
        next(connection, initQueue);
    });
});

initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    let query = OPTIONS_TABLE;
    connection.query(query, (err, res, fields) => {
        if (err) rollbackAndExit(connection, err);
        next(connection, initQueue);
    });
});

initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    let query = COURSE_TOPIC_TABLE;
    connection.query(query, (err, res, fields) => {
        if (err) rollbackAndExit(connection, err);
        next(connection, initQueue);
    });
});


initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    let query = "SET FOREIGN_KEY_CHECKS = 1;";
    connection.query(query, (err, res, fields) => {
        if (err) rollbackAndExit(connection, err);
        next(connection, initQueue);
    });
});

// START INIT SAMPLE DATA

initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    let query = "INSERT INTO user (uid , username, password, fullName, type) VALUES ?";
    let user_uid = uuid();
    let values = [
        [user_uid, 'admin' , bcrypt.hashSync('admin', 10),'Admin', 1 ],
        [uuid(), 'student', bcrypt.hashSync('student', 10),'Test Student', 0 ]
    ];
    connection.query(query, [values], (err, res, fields) => {
        if (err) rollbackAndExit(connection, err);

        next(connection, initQueue);
    });
});

initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    let query = "INSERT INTO user (uid , username, password, fullName, type) VALUES ?";
    let user_uid = uuid();
    let values = [
        [user_uid,'jsauppe', bcrypt.hashSync('admin', 10),'Jason Sauppe',1]
    ];
    connection.query(query, [values], (err, res, fields) => {
        if (err) rollbackAndExit(connection, err);

        query = "INSERT INTO course (course_name, user_uid) VALUES ?";
        values = [
            ["CS120",user_uid],
            ["CS220",user_uid]
        ];
        connection.query(query, [values], (err, res, fields) => {
            if (err) rollbackAndExit(connection, err);

            next(connection, initQueue);
        });
    });
});

initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    let query = "INSERT INTO user (uid , username, password, fullName, type) VALUES ?";
    let user_uid = uuid();
    let values = [
        [user_uid,'asauppe', bcrypt.hashSync('admin', 10),'Allison Sauppe',1]
    ];
    connection.query(query,[values], (err, res, fields) => {
        if (err) rollbackAndExit(connection, err);

        query = "INSERT INTO course (course_name, user_uid) VALUES ?";
        values = [
            ["CS120",user_uid],
            ["CS220",user_uid]
        ];
        connection.query(query, [values], (err, res, fields) => {
            if (err) rollbackAndExit(connection, err);

            next(connection, initQueue);
        });
    });
});

initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    let query = "INSERT INTO topic  (topic_name) VALUES ?";
    let values = [
        ["Arrays 1D"],
        ["Array Declaration"],
        ["String Method"],
        ["Arrays 2D"],
        ["Recursion"]
    ];
    connection.query(query, [values], (err, res, fields) => {
        if (err) rollbackAndExit(connection, err);

        next(connection, initQueue);
    });
});

initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    let query = "INSERT INTO question  (content, topic_question_tid, question_key, type_id) VALUES ?";
    let values = [
        ['Specify output of this code\n`String test = \"Hello World\";\nSystem.out.println(test.substring(4))`', 3, 'o World', 0],
        ['Specify output of this code\n`String test = \"Test String\";\nSystem.out.println(test.substring(2,5))`', 3, 'st S', 0 ],
        ['Fill in the blank. \n`___ numArray = new int[5];', 1, 'int[]`', 1],
        ['Write a flush function for a String', 3, "", 2]
    ];
    connection.query(query, [values], (err, res, fields) => {
        if (err) rollbackAndExit(connection, err);

        next(connection, initQueue);
    });
});

initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    let query = "INSERT INTO options (question_qid, opt) VALUES ?";
    let values = [
        [3, 'int'],
        [3, 'int[]'],
        [3, 'int[5]'],
        [3, 'new int[5]']
    ];
    connection.query(query, [values], (err, res, fields) => {
        if (err) rollbackAndExit(connection, err);

        next(connection, initQueue);
    });
});

initQueue.unshift((connection, initQueue) => {
    let next = initQueue.pop();
    let query = "INSERT INTO course_topic (course_cid, topic_tid, date) VALUES ?";
    let values = [
      [1, 1, "Tue Jun 04 2019 00:00:00 GMT-0500 (Central Daylight Time)"],
      [1, 2, "Mon Jun 24 2019 00:00:00 GMT-0500 (Central Daylight Time)"],

    ];
    connection.query(query, [values], (err, res, fields) => {
        if (err) rollbackAndExit(connection, err);
        query = "INSERT INTO course_topic (course_cid, topic_tid) VALUES ?";
        values = [
          [1,3],
          [3,1],
          [2,4],
          [4,4]
        ];
        connection.query(query, [values], (err, res, fields) => {
            if (err) rollbackAndExit(connection, err);
            next(connection, initQueue);
          });
    });
});

// ### END TEST_DATA


initQueue.unshift((connection, initQueue) => {
    connection.commit((err) => {
        if (err) rollbackAndExit(connection, err);
        connection.release();
        console.log("Database values initialized");
        process.exit(0);
    });
});

function rollbackAndExit(connection, err) {
    connection.rollback(() => {
        console.error("Error: " + err.message);
        connection.release();
        throw err;
    });
}


let executeQueue = initQueue.pop();
executeQueue(undefined, initQueue);


//
// UPDATE `csdept`.`Question` SET `cid` = '1' WHERE (`qid` = '1');
// UPDATE `csdept`.`Question` SET `cid` = '1' WHERE (`qid` = '2');
