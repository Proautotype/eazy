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
directories=("aConfigServer" "accounts" "loans" "cards")

# if param is available then reassign directories
if [  $# -lt 0 ]; then
#  directories=("$@")
  exit 1
fi

run_gradle_jib() {
  dir=$1
  echo "Running gradle jib for directory :$dir"
  (cd "$dir" && nohup ./gradlew jib >/dev/null 2>&1 &) # Redirecting output to /dev/null
}

# Loop through each directory and run Gradle jib task in a subshell
for dir in "${directories[@]}"
do
  run_gradle_jib "$dir"
done

wait

each "All tasks are completed"