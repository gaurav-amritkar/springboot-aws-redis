# spring-boot-aws-redis
1. Created Redis Cluster with default security group and vpc
2. Created EC2 instance with same security group and vpc and use existing keypair or create new. Download key2.pem file.
3. Created Elastic IPs and associated it with EC2 instance
4. Created S3 bucket and uploaded generated jar for the Springboot-Redis application. Provided public access to object.
5. Connect to EC2 instance using ==> ssh -i key2.pem ec2-user@PUBLIC-ELASTIC-IP
6. Download the Springboot-Redis jar file in the instance using wget
7. Run the java application using ==> java -jar Springboot-Redis.jar
8. Now try sending requests to the application using Public IPv4 DNS from EC2 instance