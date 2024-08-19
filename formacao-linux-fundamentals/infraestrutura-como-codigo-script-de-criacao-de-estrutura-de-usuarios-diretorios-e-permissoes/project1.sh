#!/bin/bash


if [ "$(id -u)" -eq 0 ]; then 
    echo "Creating directories..."

	mkdir -p /publico /adm /ven /sec

	echo "Directories \"/public /adm /ven /sec\" created successfully."

	echo ""

	echo "Creating user groups and assigning permissions on directories..."

	groups=("GRP_ADM" "GRP_VEN" "GRP_SEC")

	for group in "${groups[@]}"; do
		groupadd "$grupo"
	done

	chown root:GRP_ADM /adm && chown root:GRP_VEN /ven && chown root:GRP_SEC /sec
	
	chmod 770 /adm /ven /sec && chmod 777 /publico

	echo "User groups \"GRP_ADM, GRP_VEN, GRP_SEC\" created and permissions set successfully."

	echo ""

	echo "Creating group users \"GRP_ADM\"..."

	grpAdm=("carlos" "maria" "joao")

	for user in "${grpAdm[@]}"; do
		useradd "$user" -m -s /bin/bash -p $(openssl passwd -crypt 123) -G GRP_ADM
	done

	echo "Creating group users \"GRP_VEN\"..."

	grpVen=("debora" "sebastiana" "roberto")

	for user in "${grpVen[@]}"; do
		useradd "$user" -m -s /bin/bash -p $(openssl passwd -crypt 123) -G GRP_VEN
	done

	echo "Creating group users \"GRP_VEN\"..."

	grpSec=("josefina" "amanda" "rogerio")

	for user in "${grpSec[@]}"; do
		useradd "$user" -m -s /bin/bash -p $(openssl passwd -crypt 123) -G GRP_SEC
	done

	echo "Users created successfully."

	echo ""

	echo "Script finished."
else
    echo "You must be logged in as a super user (note: you can use \"sudo\")"
fi
