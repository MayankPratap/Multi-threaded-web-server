# Multi-threaded-web-server
Multi threaded web server program written in java developed as a part of Computer Networking Course at MNNIT.

## Description 

A web server program which serves a page to multiple clients simulataneously. The web page is saved locally in a folder. And our server fetches the web page from there and serves it to the requesting client. 

This repo has a folder named "root" which contains a scrape of a website. Currently our web server will render index.html of this website.

While running server file we give absolute path of index.html in "root" and the port number we want our server to run at as command line arguments.

Then while running client program we give hostname and port number of our web server as commandline arguments.

## How to run the server ?

- 1) Clone the repo.

- 2) Compile the java file "server.java" using ```javac server.java ```
       
- 3) Run web server using ```java server "Path to index.html file(without quotes)" portnumber``` 
   
- 4) Compile "client.java" file using ```javac client.java```

- 5) Run the  client program which requests our web server process ```java client localhost portnumber```

- 6) The client will recieve index.html from our web server.

  ### Alternate Method to see the server working
  
  - 1) Run the server program.
  - 2) Open browser and fire localhost:portNumber/index.html

## To do 

- Transmitting images and other files to the requesting client.
- Supporting get and head requests. 


        
      
                   


