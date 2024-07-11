#script to start mysql docker container
$1 = "root" # password
$2 = "accounts" # databasename
# -d : start in detach mode
docker run -p 3306:3306 --name accountsdb -e MYSQL_ROOT_PASSWORD=$1 -e MYSQL_DATABASE=$2 -d mysql