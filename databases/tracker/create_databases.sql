DROP DATABASE IF EXISTS tracker_dev;
DROP DATABASE IF EXISTS tracker_test;

CREATE DATABASE tracker_dev;
CREATE DATABASE tracker_test;

CREATE USER IF NOT EXISTS 'root'@'%'
  IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON tracker_dev.* TO 'root' @'%';
GRANT ALL PRIVILEGES ON tracker_test.* TO 'root' @'%';