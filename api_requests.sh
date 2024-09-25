#!/bin/bash

echo "Ejecutando api de user-event..."
curl -X POST http://localhost:8080/user-event \
-H "Content-Type: application/json" \
-d '{
    "username": "Michael Tomaylla",
    "email": "michael.tomaylla@pucp.edu.pe"
}'
echo ""