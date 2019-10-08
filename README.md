# This is the server application, running on a Spring boot application. 
## Prerequisites 
1. Make sure to have Java jdk installed on your local machine. The application was made using jdk-11.0.1, but later versions or slightly 
  earlier versions should be fine. 
2. Download Intellij 
3. Download Postman to test API endpoints (optional) 
4. Download MYSQL and have it running locally on your machine. https://dev.mysql.com/doc/mysql-osx-excerpt/5.7/en/osx-installation.html
5. Download MYSQL workbench for a visual of the database (optional)

## Import Project
1. Clone this repository into your local machine. 
   - Go to your workplace directory in your terminal 
   - Run the command `git clone https://github.com/markkang98/bbusa-attendance-server.git` 
2. Open Intellij, and select **Import Project**
3. Select your cloned repoistory in your local machine
4. Select Import projects by selecting **maven**, then select next
5. Select  **Search for projects recursively** and **Import Maven projects automatically**, then select next
6. Make sure ** com.bbusa:bbusa:0.0.1-SNAPSHOT ** is selected, and select next. 
7. Make sure that Intellij is using your jdk
8. Your project should open up, and on the top right corner, you should see be able to select run as a spring boot project. 

## MYSQL Workbench 
If you would like to visualize your database, use MYSQL workbench. 

1. Download MYSQL workbench. 
2. Make a new connection, and add a name for that connection (any name should suffice, as long as you will remember it)
3. The host is **bbusa-aws-database.cmzqesgmdg2y.us-east-1.rds.amazonaws.com** and the port is **3306** 
4. The username is **root**
5. When the connection is working correctly, it will ask you to input the password. **please ask me directly for the password** 
6. The default database is titled **innodb** and you should be able to see the tables created and the data populated in it. 
