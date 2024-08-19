#!/bin/bash


if [ "$(id -u)" -eq 0 ]; then 
    apt update
    apt upgrade -y
    apt install apache2 -y

    echo "<!DOCTYPE html>
		<html lang=\"en-US\">
		<head>
			<meta charset=\"UTF-8\">
			<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">
			<title>My site</title>
		</head>
		<body>
			<h5>Web server is ready</h5>
		</body>
		</html>" > /var/www/html/index.html

		echo "Server installed and running with a sample index.html file created!"
else
    echo "You must be logged in as a super user (note: you can use \"sudo\")"
fi
