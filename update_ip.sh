#!/bin/bash

IP_ADDRESS=$(terraform output -raw server_ip)
SED_REPLACE="s/REPLACE_WITH_IP_ADDRESS/$IP_ADDRESS/g"

# Create a temporary file with the replaced content
sed "$SED_REPLACE" /home/ubuntu/Medicure-Project/test-script.java > /tmp/temp_script.java

# Move the temporary file back to the original script location
sudo mv /tmp/temp_script.java /home/ubuntu/Medicure-Project/test-script.java
