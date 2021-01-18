## Augen Test backend

![App Screenshot](home.png)

## Environment require:
1. Java 8
2. Maven

## Steps to Setup the Spring Boot Back end app 

1. **Clone the application**

	```bash
	git clone https://github.com/dinhanhvo/augen_test.git
	cd augen_test\augen_beckend
	```
2. **Build the app**
	```bash
		mvn clean package install -DskipTests
	```

3. **Run the app**

	You can run the spring boot app by typing the following command -

	```bash
	mvn spring-boot:run
	```

	The server will start on port 8089.

	You can also package the application in the form of a `jar` file and then run it like so -

	```bash
	mvn package
	java -jar target/augen-0.0.1-SNAPSHOT.jar
	```
