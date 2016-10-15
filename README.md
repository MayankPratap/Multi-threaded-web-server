# Multi-threaded-web-server
Multi threaded web server program written in java.

## Goal 

To make a web server from scratch using java which supports GET,HEAD Requests which supports multiple clients simultaneously. 
Motivation is to learn about socket programming in the process.

## Description 

A web server program which serves a page to multiple clients simulataneously. The web page is saved locally in a folder. And our server fetches the web page from there and serves it to the requesting client. 

This repo has a folder named "root" which contains a scrape of a website. Currently our web server will render index.html of this website.

Directory structure of root folder :-  

                          /
                          - index.html
                          - /reason_package
                          - /global_stock
                          - favicon.ico
                          - farzee.txt
                          - /curricular
                          

Then while running client program we give hostname and port number of our web server as commandline arguments.
After we run client program we can use GET request to fetch any file in "root" folder.

## How to run the server ?

- 1) Clone the repo.

- 2) Compile the java file "server.java" using ```javac server.java ```
       
- 3) Run web server using ```java server portnumber``` 
   
- 4) Compile "client.java" file using ```javac client.java```

- 5) Run the  client program which requests our web server process ```java client localhost portnumber```

- 6) After running client you can access any file using GET Requests.
      - Eg:- GET /index.html HTTP/1.0
      
  ### Testing Web Server Using Browser
  
  - 1) Run the server program.
  - 2) Open browser and fire localhost:portNumber/resourcePath
        - Eg:- localhost:8000/index.html
        
  ### Testing Web Server Using Telnet
  
  - 1) Run the server program.
  - 2) telnet localhost portno
  - 3) Then in telnet use a "GET" request.
        - Eg:- GET /index.html HTTP/1.0
   
 
## To do 

- Transmitting images and other files to the requesting client.
- Supporting get and head requests. 


        
      
                   


