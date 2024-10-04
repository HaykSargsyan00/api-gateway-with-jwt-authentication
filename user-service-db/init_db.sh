#!/bin/bash
set -e

# Create a read-only user
psql -U user-service -d user_service -c "CREATE USER auth_service WITH PASSWORD 'auth_pass';"
psql -U user-service -d user_service -c "GRANT CONNECT ON DATABASE user_service TO auth_service;"
psql -U user-service -d user_service -c "GRANT USAGE ON SCHEMA public TO auth_service;"
psql -U user-service -d user_service -c "GRANT SELECT ON ALL TABLES IN SCHEMA public TO auth_service;"
psql -U user-service -d user_service -c "ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT ON TABLES TO auth_service;"
