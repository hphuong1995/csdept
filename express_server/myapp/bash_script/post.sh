#!/usr/bin/env bash

# Take questions zip file
read -p "Enter question zip file:" ZIP_FILE

# Unzip the input zip file
echo "unzipping $ZIP_FILE"
unzip $ZIP_FILE

# cd into the folder
DIR=$(zipinfo -1 $ZIP_FILE | grep -oE '^[^/]+' | uniq)
cd $DIR
if [ -d "$DIR" ]
then
  echo ""
else
  echo ""
  # echo "can not cd into the unzipped directory. Please try again."
fi

# go through all txt file in unzipped directory

# TODO start transaction
for FILE in ./*.txt; do
  UPLOADED_DIR="../uploaded_question"
  #cp $FILE $UPLOADED_DIR
  echo "Processing $FILE"
  LINE=$(head -n 1 $FILE)
  CODE=$( echo $LINE | cut -d':' -f 1)
  if [ "$CODE" == "type" ]
  then
    TYPE=$( echo $LINE | cut -d':' -f 2)
    if [ "$TYPE" == "mult" ]
    then
      sh ../parse_mult.sh $FILE $DIR
    elif [ "$TYPE" == "shor" ]
    then
      sh ../parse_shor.sh $FILE $DIR
    elif [ "$TYPE" == "code" ]
    then
      sh ../parse_code.sh $FILE $DIR
    else
      echo "FILE $FILE has unrecognizable question type. Please check the question format."
    fi
  else
    echo "File $FILE has incorrect format."
  fi

  echo "$FILE has been uploaded"
done

for file in */ ; do
  if [[ -d "$file" && ! -L "$file" ]]; then
    zip -r code.zip $file
    cp code.zip ./../../codes
    cd ./../../codes
    unzip code.zip
    rm code.zip
    cd ./../bash_script
    cd $DIR
    rm code.zip
  fi;
done

cd ..
rm -r __MACOSX
rm -r $DIR
# Sucessful OF transacetion => commit transaction
