create USER timekeeper_db_admin with PASSWORD 'ZppNw_5HKAqF1xg_4QFzQXgI_ACfbQRl';
select pg_terminate_backend(pg_stat_activity.pid)
from pg_stat_activity
where pg_stat_activity.datname = 'timekeeper'
  and pid <> pg_backend_pid();
drop database IF EXISTS timekeeper;
create DATABASE timekeeper
     with  OWNER = timekeeper_db_admin
     ENCODING = 'UTF8';
grant all privileges on DATABASE "timekeeper" to timekeeper_db_admin;
create USER keycloak_admin with PASSWORD '_QH0rg9iDNK1_wU89VRK6-E02IjCeNGH';
select pg_terminate_backend(pg_stat_activity.pid)
from pg_stat_activity
where pg_stat_activity.datname = 'keycloak'
  and pid <> pg_backend_pid();
drop database IF EXISTS keycloak;
create DATABASE keycloak
     with  OWNER = keycloak_admin
     ENCODING = 'UTF8';
grant all privileges on DATABASE "keycloak" to keycloak_admin;