CREATE USER timekeeper_db_admin WITH PASSWORD 'ZppNw_5HKAqF1xg_4QFzQXgI_ACfbQRl';
SELECT pg_terminate_backend(pg_stat_activity.pid)
FROM pg_stat_activity
WHERE pg_stat_activity.datname = 'timekeeper'
  AND pid <> pg_backend_pid();
DROP DATABASE IF EXISTS timekeeper;
CREATE DATABASE timekeeper
     WITH  OWNER = timekeeper_db_admin
     ENCODING = 'UTF8';
GRANT ALL PRIVILEGES ON DATABASE "timekeeper" to timekeeper_db_admin;
CREATE USER keycloak_admin WITH PASSWORD '_QH0rg9iDNK1_wU89VRK6-E02IjCeNGH';
SELECT pg_terminate_backend(pg_stat_activity.pid)
FROM pg_stat_activity
WHERE pg_stat_activity.datname = 'keycloak'
  AND pid <> pg_backend_pid();
DROP DATABASE IF EXISTS keycloak;
CREATE DATABASE keycloak
     WITH  OWNER = keycloak_admin
     ENCODING = 'UTF8';
GRANT ALL PRIVILEGES ON DATABASE "keycloak" to keycloak_admin;