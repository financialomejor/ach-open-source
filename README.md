# ACH Service

This project connects to the ACH service to enable online payments. The project can be run directly on any machine or through Docker.

![Architecture](./screenshots/ACHArchitecture.png 'Architecture')

This project is a refactor of the "SamplePPE3_Java_Rampart" project of ACH. In this refactoring it's included:

- **Maven:** Used for managing dependencies.
- **Spring boot:** Used to launch a server expose all the services as REST.
- **Docker**: Used to easy deployment in containers

The **_src_** folder contains the code of the project. Inside this folder there is a _pom.xml_ file. This file specifies all the dependencies.

## Prerrequisites

- VPN Site to Site setup.

- VPC with public and private networks with the architecture mentioned in <a  href="https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Scenario2.html">here</a>

- Eclipse with:

  - Springboot tools installed from the marketplace.

  - Maven installed.

## Project Setup

First you need to clean the project and install the maven dependencies using the following command:

```bash
mvn clean install
```

In Eclipse this can be done doing right-click over the project ->Run As->Maven Clean. Then, right-click over the project ->Run As->Maven Install.

### Keystore

After this, you need to generate a keystore in JKS format using any tool. We recommend using Keystore Explorer for this task. The keystore must have the private/public keypair of your certificate and the ACH certificate. It must look like this:

![keystore](./screenshots/keystore.png 'Keystore configuration with keypair and ACH certificate')

<strong>Note:</strong> the private key must have a password or Rampart will fail. If you want to set a password to an existing key, you can execute the following command:

```bash

openssl rsa -aes256 -in your.key -out your.encrypted.key

```

After generating the keystore you need to place it in the <strong>main>resources > certificate</strong> folder and update the configurations lying in the <strong>main>resources > policies.xml</strong> file.

You also have to specify the private key password in the <strong>com.financialomejor.ach.PWCBHandler</strong> class.

### Endpoint and Entity reference

In order to run the project properly the endpoint reference has to be defined as a Spring boot environment variable. To do this the _pom.xml_ file has to be changed. At the end of this file there is a tag named _plugins_ tag. Here it has to be changed the **ACH_ENDPOINT** tag, the between _environmentVariables_ tag.

Now, to run it from Eclipse this has to be specified doing right-click over the project, then Run As->Run Configurations ->Spring Boot App. In that window it should appear all the run configurations available for all the Spring Boot Apps available in your workspace. You need to have one to run this project. Once you have it, go to _Environment_ tab, add a new variable with name "ACH_ENDPOINT" and in value the endpoint reference.

Also, the entity reference (NIT or PPE_CODE) has to be updated. The same configuration has to be done but under **ENTITY_CODE** tag.

## Running the project

To run the project in eclipse go to the project folder and choose the <strong>"Run As > Spring Boot App"</strong>. If all configurations where done properly the console must show the running project. Also, if you want to run it from command line, run the following command in the _ach_ folder:

```
mvn spring-boot:run
```

Once the project is running, the server will be deployed on the port specified **ach>src>main>resources>application.yml**.
In this same file, at the end, is a the _logging_ tag. This specifies the information that is going to be in the STDOUT. The default value is INFO, and means that the information will be the standard. If you want to see more details, like the SOAP request sent or information received you can set it to DEBUG. Also, if you want to get more information you can set it to TRACE, this will print all the things that the project does.

### Tinyproxy Setup

Remember that the ACH parameters specifies a VPN to get communicate properly. This means that if you run the project in a local environment it won't connect. It has to be deployed on a machine inside the VPN and with an IP whitelisted. In order to test from local environment you can use a proxy on the whitelisted machine.

To bridge requests between your local machine service and the ACH services, you must setup an EC2 instance as follows:

1. Deploy an Ubuntu 20.x EC2 instance within the network that has the VPN

2. SSH into the created instance

3. Install tinyproxy as follows

```bash
sudo apt-get install tinyproxy
```

4. Copy and paste the **tinyproxy > tinyproxy.conf** file into the **/etc/tinyproxy/tinyproxy.conf** file. Be sure to replace the annotated parameters with your own values. Also, at the end of the file whitelist the public IP of your local machine.
5. Restart the service

```bash
sudo systemctl restart tinyproxy.service
```

If you need to access the tinyproxy logs in order to ensure that the service is working as expected, you can execute the following command:

```bash
sudo cat /var/log/tinyproxy/tinyproxy.log
```

## Deploy in Docker

This project can be deployed as a Docker container. In order to do this you need to have Docker and docker-compose installed.

In the root folder are two files: Dockerfile and docker-compose.yml. The first one is used to build the docker image, the second one to deploy the container. In the 6th line of the Dockerfile it's specified a ACH certificate. This is necessary to process HTTPS requests from java. This certificate is added to Java trusted certificates in the 8th line. If you have the certificate with another name is important to change this two lines with the new name.

With all the settings done run the following command to deploy the container:

```
docker-compose up --build -d
```

When the container is up you can check the logs with the following command:

```
docker logs <container_name> --follow
```

If you want to check any change in the container you can deploy again the container and the changes will be done.

The volume configuration in the docker-compose.yml file, the logging configuration in the application.yml and the command run in Dockerfile allows to get a "output.txt" available in the _ach_ folder, in the container and the host. This file contains all the STDOUT of the container.

### Test the Springboot service

You can test that your project is running by using the following command in your machine:

```bash
curl http://localhost/ach/test
```

## Service routes

You can test that your project is running by using the following command in your machine:

```bash
curl http://localhost/ach/test
```

The allowed routes by the service are the following:

| Route                                    | Method | Description                                                |
| ---------------------------------------- | ------ | ---------------------------------------------------------- |
| /ach/test                                | GET    | Testing route to check running service                     |
| /ach/bank-list                           | GET    | Retrieves the bank list from the ACH servers               |
| /ach/transaction-payment                 | POST   | Creates a new payment transaction                          |
| /ach/transaction-information/{id}        | GET    | Retrieves the information for a given transaction          |
| /ach/transaction-information/detail/{id} | GET    | Retrieves the detailed information for a given transaction |
| /ach/finalize-transaction/{id}           | POST   | Ends a given transaction                                   |
| /ach/transaction-information/detail/{id} | GET    | Retrieves the detailed information for a given transaction |

<br/>

## References

[1] Web Service Security with Axis2, https://www.adictosaltrabajo.com/2009/02/09/wss-usertoken/

[2] Web Services with Axis2, https://www.adictosaltrabajo.com/2008/10/24/web-services-axis-2/

[3] Web Services Security Policy Language, http://specs.xmlsoap.org/ws/2005/07/securitypolicy/ws-securitypolicy.pdf
&#169; Fináncialo Mejor 2021, all rights reserved
