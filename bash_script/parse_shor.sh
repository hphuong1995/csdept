#! /bin/bash

# Save the file argument.
FILE=$1
DIR=$2

#cd $DIR

TYPE=""
TOPIC=""
QUES=""
OPT=()
KEY=""
CURRENTUSER=$(whoami)

counter=0

while IFS='' read -r line || [[ -n "$line" ]]; do
  #echo "Text read from file: $line"
  CODE=$( echo $line | cut -d':' -f 1)
  echo "$line"

  if [ "$CODE" == "type" ]
  then
    TYPE=${line:5}
  elif [ "$CODE" == "ques" ]
  then
    QUES=${line:5}
  elif [ "$CODE" == "topic" ]
  then
    TOPIC=${line:6}
  elif [ "$CODE" == "key" ]
  then
    KEY=${line:4}
  fi
done < "$FILE"

echo "$QUES"

#CID=$(echo "SELECT cid FROM Course WHERE cid = 1" | mysql "csdept" -u "root" -p"Hphuong131464" -s -N)

TID=$(echo "SELECT tid FROM Topic WHERE tname ='$TOPIC'" | mysql "csdept" -u "root" -p"Hphuong131464" -s -N)

# if this is a new topic, create new Topic
if [ -z "$TID" ]
then
	echo "INSERT INTO Topic (tname) VALUES ('$TOPIC');" | mysql "csdept" -u "root" -p"Hphuong131464" -s -N
fi
TID=$(echo "SELECT tid FROM Topic WHERE tname ='$TOPIC';" | mysql "csdept" -u "root" -p"Hphuong131464" -s -N)
#echo "$TID"


#Insert question into Question table
printf "INSERT INTO Question (content, tid, typeId, qKey) VALUES ('\\n Hello \\n newline', $TID, 1, '$KEY')" | mysql "csdept" -u "root" -p"Hphuong131464" -s -N

#Insert option to Option table


