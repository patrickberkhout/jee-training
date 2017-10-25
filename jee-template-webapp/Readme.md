## Deploy to local running EAP
	mvn widlfly:deploy -DskipTests=true


## Docker compose

# Clean up and start new containers
# You can ignore the 'Mount point not found' messages. See https://issues.jboss.org/browse/WFCORE-2301

	docker-compose down
	docker-compose up --build
	
# Main user interface
<http://localhost:8180/jee-template-webapp/>

# Admin user interface (admin/admin)
http://localhost:8180/jee-template-webapp/admin/

# JSF Gallery (admin/admin)
http://localhost:8180/jee-template-webapp/gallery/

# SOAP interface
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

# Postgres server
host:localhost port:5532 login:postgres/postgres


