# splunk-logs-springboot

## Enabling Http Event Collector in Splunk
- Login to Splunk
  <img width="1280" alt="Screenshot 2024-05-22 at 7 01 45 PM" src="https://github.com/Himanshut0012/splunk-logs-springboot/assets/89704266/2fe2d0dd-6de6-46c0-b1fb-5c7137278503">

- Go to Settings -> Data Inputs -> Http Event Collector
  <img width="1280" alt="Screenshot 2024-05-22 at 9 39 42 PM" src="https://github.com/Himanshut0012/splunk-logs-springboot/assets/89704266/68def0bb-ad99-4865-900f-c41e596aee64">

- Click on Global Settings
  <img width="1280" alt="Screenshot 2024-05-23 at 1 51 05 AM" src="https://github.com/Himanshut0012/splunk-logs-springboot/assets/89704266/455091c0-bd76-48ba-a4cc-4fc5d6910d98">
 


- Beside ‘New Tokens’ click on Enable Button and hit Save
 <img width="1280" alt="Screenshot 2024-05-23 at 1 51 22 AM" src="https://github.com/Himanshut0012/splunk-logs-springboot/assets/89704266/5d0e514f-7a74-48ab-938c-423712e60d80">
- Create Data Entry for Http Event
- Go to Settings -> Add Data
- Click Monitor -> Http Event Collector
- Populate name and optional source name, description and click Next
  <img width="1280" alt="Screenshot 2024-05-22 at 9 48 11 PM" src="https://github.com/Himanshut0012/splunk-logs-springboot/assets/89704266/9f277f47-a552-4cb1-b4bc-9a7e5b575a02">
- Select Source Type as Structured -> log4j
- Create a new Index. Enter name and click on Save.
  <img width="1280" alt="Screenshot 2024-05-22 at 9 49 56 PM" src="https://github.com/Himanshut0012/splunk-logs-springboot/assets/89704266/16ccb8ab-1d32-42ea-b848-5559f013310b">

- Select the Index from Available to Selected and click Review
  <img width="1280" alt="Screenshot 2024-05-22 at 9 50 14 PM" src="https://github.com/Himanshut0012/splunk-logs-springboot/assets/89704266/c9d9477f-fe1a-44e2-b5a2-99c12f91be11">
- Hit Submit
- Capture the token value from last page
  <img width="1280" alt="Screenshot 2024-05-22 at 9 51 03 PM" src="https://github.com/Himanshut0012/splunk-logs-springboot/assets/89704266/b56ae937-6026-4b86-9b96-5f80b02dc2fe">
  
- Build the Code
- mvn clean install

## Run the program
```
java -jar target/spring-log4j2-splunk-1.0.0.jar
```

## Validate in Splunk Search/Reporting
- Login to Splunk
- Go to Apps -> Search & Reporting
- Type index="student_sevice" to search
  <img width="1280" alt="Screenshot 2024-05-23 at 1 57 18 AM" src="https://github.com/Himanshut0012/splunk-logs-springboot/assets/89704266/efcf495a-6c6a-4b3f-b052-3e24ac872fda">

# congratulations you successfully configured splunk with springboot
### Thnakyou for reading
