##Time summary: 
• Analise Requirement: 1 hour 
• Preparation: 2 hours 
• Coding: 18 hours (including tests) 
• Styling 30 minutes 
• Building and testing 30 minutes 
	Grand total: 22 hours

## Environment require:
1. Java 8
2. Maven
3. Node

## Sumary to run application 

1. **Clone the application**

	```bash
	git clone https://github.com/dinhanhvo/augen_test.git
	```
2. **Run server
	```bash
	cd augen_test\augen_beckend
	mvn clean package install
	mvnw spring-boot:run
	```
2. **Run client
	```bash	
	cd augen_fontend
	yarn || npm i
	ng serve --port 4300
	```
	
