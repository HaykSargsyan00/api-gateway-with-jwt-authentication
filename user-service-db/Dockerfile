FROM postgres:latest
LABEL authors="hayk.sargsyan"

COPY init_db.sh /docker-entrypoint-initdb.d/

RUN chmod +x /docker-entrypoint-initdb.d/init_db.sh
