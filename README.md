Hello everyone 👋🏻

I have ceated this project where DeviceAtlas provides a web service that returns device/os/browser information when passed a HTTP User-Agent. The application reads the URL for web service when provided with user agents and return the response.
The functionalities i have covered includes reading all the user agenst and passing through the URL for web service, storing the response in MySQL database and filtering the tablet devices sorted by their OSversion. 

1. **Starting the application**:
   Navigate to DeviceAtlasApplication.java class and right click to Run it. Nxt go to localhost:8080 to see the response for all user agents when passed with the URL https://region0.deviceatlascloud.com/v1/detect/properties?licencekey=e6ce0b9455cab0e494be4587d016c7c2&useragent=USER_AGENT

   ![image](https://github.com/user-attachments/assets/75b66fb0-ab5a-4346-88f9-f5e4a7daa899)

2. **Storing the response in relational database**:
   Open MySQL workbench and conect to localhost:3306. Once opened go to the table device_atlas under the database DeviceAtlas. Right click and select 'Select rows-Limit 1000' to show the
   entries of the response. Below is a snapshot of how it will look like
   ![image](https://github.com/user-attachments/assets/3bacf597-c6ad-4ce1-bcdd-c10c22e1085c)

3. **Showing Tablet Devices sorted by their OS version**:
    Navigate to the path http://localhost:8080/tablets to see onlt the tablet devices arranged by their OS versions. Below is a snapshot of frontend
   ![image](https://github.com/user-attachments/assets/79d9e91b-64d4-4bdf-9c76-ffe56f3875d7)

4. **Docker Containers**:
   I have created a docker orchestration for this application, Dockerfile and docker-compose.yml file. Run the command _docker-compose up --build_ to run the aplication but beofe that make sure you have the.jar file
   for the project. If the .jar file is not there, run the command _./mvnw clean package_ to place the .jar files in the target folder (Note: Dockerfile, docker-compose.yml and target folder should be under one directory)
   If any ajustments are required in docker-compose.yml file or Dockerfile then implement according to system requirements like port number or database client. Below is a snapshot of container created in docker daemon
    ![image](https://github.com/user-attachments/assets/517c8121-eaca-4b58-b194-a6528ff1614d)
     

