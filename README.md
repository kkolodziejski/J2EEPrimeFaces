# J2EEPrimeFaces

## Glassfish

Konfiguracja: https://tutorialforlinux.com/2019/06/10/how-to-install-glassfish-5-on-opensuse-tumbleweed-step-by-step/

## Postgres

Init bazy danych poprzez compose albo recznie

```shell
docker run -itd -e POSTGRES_USER=kkolodziejski -e \
POSTGRES_PASSWORD=guest -p 5432:5432 -v /data:/var/lib/postgresql/data \
 --name postgresql postgres

docker exec -it CONTAINER_ID bin/bash

psql -U kkolodziejski
```

```postgresql
\conninfo

\l

CREATE DATABASE j2ee;

\c j2ee

CREATE TABLE IF NOT EXISTS account(id BIGSERIAL PRIMARY KEY, name VARCHAR(20) NOT NULL, phone VARCHAR(15) NOT NULL);

\dt

INSERT INTO account (name, phone) VALUES ('dzelapino', '+37843321432');

SELECT * FROM account;
```