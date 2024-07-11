#(cd ./accounts && gradle jib) &
#(cd ./loans && gradle jib) &
#(cd ./cards && gradle jib) &
#(cd ./aConfigServer && gradle jib) &
#
## wait for all background tasks to complete
#wait
#echo "All tasks are completed"



# List of directories containing Gradle projects
#directories=("aConfigServer" "accounts" "loans" "cards")
## Loop through each directory and run Gradle jib task in a subshell
#for dir in "${directories[@]}"
#do
#  echo "Running Gradle jib for directory: $dir"
#  (cd "./$dir" && ./gradlew jib) &
#done
#
#wait
#
#each "All tasks are completed"



# List of directories containing Gradle projects
#directories=("accounts" )
#directories=("loans" "cards")
directories=("aConfigServer" "accounts" "loans" "cards")
# Array to store background process IDs
declare -a pids=()

create_directories(){
  log_file="$1.log"

  for dir in "${directories[@]}"
  do
    echo "Create log file $log_file"
    touch "$dir/$log_file"
  done
}

# create_directories "jib"
create_directories "jibDockerBuild"

run_gradle_jib() {
  dir=$1
  # create log file for each directory
  echo "Running gradle jib for directory :$dir"
  (cd "./$dir" && nohup ./gradlew jib >/dev/null 2>&1 &)
}

run_gradle_jib_2() {
  dir=$1
  log_file="jibDockerBuild.log"
  echo "Running gradle jib for directory : $dir"
  # Redirecting output to /log_file
  (
    cd "$dir" &&
    nohup ./gradlew jibDockerBuild > "$log_file" 2>&1 &
    pid=$!
    pids+=($pid)
  )
}

# Loop through each directory and run Gradle jib task in a subshell
for dir in "${directories[@]}"
do
  run_gradle_jib_2 "$dir"
done

echo "Processes id ($pids)"

wait

echo "All tasks are completed"
