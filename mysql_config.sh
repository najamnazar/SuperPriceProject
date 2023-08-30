DB_NAME="superprice_db"
DB_USER="superprice_user"
DB_PASS="superpassword" # Choose a strong password in a real scenario

echo "Setting up MySQL database and user..."
mysql -e "CREATE DATABASE $DB_NAME;"
mysql -e "CREATE USER '$DB_USER'@'localhost' IDENTIFIED BY '$DB_PASS';"
mysql -e "GRANT ALL PRIVILEGES ON $DB_NAME.* TO '$DB_USER'@'localhost';"
mysql -e "FLUSH PRIVILEGES;"
