# Template application

* Secured using a database security domain
* 



## Startup instructions
Clean up and start new containers. 

Note. upon startup the postgres databases will be loaded. This will take a minute.
Note: you can ignore the 'Mount point not found' messages. See <https://issues.jboss.org/browse/WFCORE-2301>

	docker-compose down
	docker-compose up -d --build
	
	mvn clean install wildfly:deploy -DskipTests=true
	

## Application endpoints
### Admin site
<http://localhost:8180/jee-template-webapp/admin/>

* user: admin
* password: admin

### Public site

<http://localhost:8180/jee-template-webapp/>


### JSF Gallery (admin/admin)
http://localhost:8180/jee-template-webapp/gallery/

### Rest interface
<http://localhost:8180/jee-template-webapp/rest/financial/product/>

### SOAP interface
<http://localhost:8180/jee-template-webapp/soap/FinanciaSOAPPService?wsdl>

		<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:fin="http://local/FinancialService/">
		   <soapenv:Header/>
		   <soapenv:Body>
		      <fin:GetProducts/>
		   </soapenv:Body>
		</soapenv:Envelope>

		<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
   <soap:Body>
      <ns2:GetProductsResponse xmlns:ns2="http://local/FinancialService/">
         <product productid="1" symboltype="Type1" symbol="$" cuisp="cuisp"/>
         <product productid="2" symboltype="Type1" symbol="$" cuisp="cuisp"/>
      </ns2:GetProductsResponse>
   </soap:Body>
</soap:Envelope>

## Backend endpoints
### Postgres server
host:localhost port:5532 login:postgres/postgres


