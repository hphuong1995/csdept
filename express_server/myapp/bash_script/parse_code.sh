#! /bin/bash

# Save the file argument.
FILE=$1
DIR=$2

#cd $DIR

TYPE=""
TOPIC=""
QUES=""
CURRENTUSER=$(whoami)

counter=0

while IFS='' read -r line || [[ -n "$line" ]]; do
  #echo "Text read from file: $line"
  CODE=$( echo $line | cut -d':' -f 1)
  if [ "$CODE" == "type" ]
  then
    TYPE=${line:5}
  elif [ "$CODE" == "ques" ]
  then
    QUES=${line:5}
  elif [ "$CODE" == "topic" ]
  then
    TOPIC=${line:6}
  fi
done < "$FILE"


#CID=$(echo "SELECT cid FROM Course WHERE cid = 1" | mysql "csdept" -u "root" -p"Hphuong131464" -s -N)

TID=$(echo "SELECT tid FROM topic WHERE topic_name ='$TOPIC'" | mysql "csdept" -u "root" -p"Hphuong131464" -s -N)

# if this is a new topic, create new Topic
if [ -z "$TID" ]
then
	echo "INSERT INTO topic (topic_name) VALUES ('$TOPIC');" | mysql "csdept" -u "root" -p"Hphuong131464" -s -N
fi
TID=$(echo "SELECT tid FROM topic WHERE topic_name ='$TOPIC';" | mysql "csdept" -u "root" -p"Hphuong131464" -s -N)
#echo "$TID"


#Insert question into Question table
printf "INSERT INTO question (content, topic_question_tid, type_id) VALUES ('$QUES', $TID, 2)" | mysql "csdept" -u "root" -p"Hphuong131464" -s -N

#Insert option to Option table
