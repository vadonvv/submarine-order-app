***
запустить слона к которому коннектится приложение
```bash
ocker run --name submarine-order-db -e POSTGRES_PASSWORD=password -e POSTGRES_DB=submarine-order-db -d -p 5432:5432 postgres
```
