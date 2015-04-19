# MultiDBs-KeywordSearchR-Server
Keyword Search using relational dbs

1. Open mysql port 3306 to public (enabling remote access)

To check if your mysql port 3306 is open to public, follow these two steps:
(1) Login to the server.
(2) run this command:

sudo lsof -i -P | grep :3306
 
You will probably see this at the end of the line:
 
0t0  TCP localhost:3306 (LISTEN)
 
This means that your mysql is only available to localhost (the server machine), not open to public.
Otherwise, it should be "0t0  TCP *:3306 (LISTEN)".

To make the mysql 3306 port public accessible, follow these commands:
 
#1.
sudo nano /etc/mysql/my.cnf
 
# We need to edit the mysql config file using nano. Use down arrow to scroll down and find "[mysqld]"
# Then try to find a line "bind-address           =127.0.0.1"
# Add a '#' in front of that line to disable it
#start a new line, with content "bind-address             =0.0.0.0"
# Save the file by using ctrl + O.
# Exit by ctrl + X. 



2. Steps to set up the project

(1) Please download the setup.sh first on your local machine.
(Click the download button in the right corner)

(2) In the terminal, input "sudo chmod +x setup.sh"(without double quotation mark) to modify the permission.

(3) run "./setup.sh"(without double quotation mark).

(4) When the MySQL is installing, the username you set should be root, and the password should be root too.

(5) If you run successfully, you can run "lsof -i:7654", then you can see information of the process.

(6) Now you can see our main webpage on your local machine.

(7) If you update, run "ssh stop-server.sh" to stop the server and rebuild the javacode first, then run "ssh start-servers.sh" to restart the server.
