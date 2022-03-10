FILES:
DataBean.java
StudentBean.java
DataProcessor.java
StudentDAO.java
Mainservlet.java
Course.html
feedback.html
script.js
NoStudent.jsp
SimpleAcknowledge.jsp
StudentJSP.jsp
WinnerAcknowledge.jsp


Table Creation query in database:
tableQuery.txt has the table creation query in Oracle SQL database hosted on Zeus.


Software and jar files Required:
1) Eclipse IDE for Java EE Developers 
2) Apache Tomcat 9
3) Cisco AnyConnect VPN 
4) ojdbc8.jar 


Procedure to SETUP:
1) Extract Eclipse and start 
2) Extract Apache Tomcat and configure with eclipse
3) Install Cisco AnyConnect VPN and use this "vpn.gmu.edu" VPN id
4) Create a table (students) in SQL.
5) Unzip the 'rar' file: it contains
 - ReadMe file
 - 'war' file(created using Export) 
 - 'zip' file 
6)  Import the 'war' file to eclipse
 -> file -> import -> filter with 'war' and click next
 -> browse for this 'war' file -> click finish
7) Run this project
 -> Right click on this project -> 'Run as' -> select 'Run on server'
8) Type the url in the browser (http://localhost:8080/swe3/feedback.html)
