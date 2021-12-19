# PersonAPI
A Java API Rest created using Java 11, SpringBoot and JPA to management people

<strong>REQUISITES:</strong>

JAVA 11 installed

POSTMAN

IntelliJ IDE or SpringTools

# Testing

Open the application Postman

<strong>POST PEOPLE</strong>


1* Create a new tab and choose the type POST

2* Copy and Paste this address: http://localhost:8081/api/v1/people 

3* Copy and Paste the JSON in the 1º exemple in the body and click in SEND

Body:

Example 1: 

<br />


    {
        "firstName": "Manoel Henrique",
        "lastName": "Amorim dos Santos",
        "cpf": "123.456.789-09",
        "birthDate": "1998-10-29",
        "phones": [
  	        {
  		    "type": "MOBILE",
  		    "number": "(82)99999-9999"
	        }
        ]  
    }

<strong>GETTING ALL PEOPLE</strong>

1* Create a new tab and choose the type GET

2* Copy and Paste this address: http://localhost:8081/api/v1/people/

3* Click in the SEND button

<strong>GET PERSON BY ID</strong>

1* Create a new tab and choose the type GET

2* Copy and Paste this address: http://localhost:8081/api/v1/people/{id}

3* Replace the text "{id}" for the value "1" or other id that was saved

3* Click in the SEND button

<strong>DELETE PERSON BY ID</strong>

1* Create a new tab and choose the type DELETE

2* Copy and Paste this address: http://localhost:8081/api/v1/people/{id}

3* Replace the text "{id}" for the value "1" or other id that was saved

3* Click in the SEND button

<strong>PUT PEOPLE</strong>

1* Create a new tab and choose the type PUT

2* Copy and Paste this address: http://localhost:8081/api/v1/people/{id} 

3* Replace the text "{id}" for the value "1" or other id that was saved

4* Copy and Paste the JSON  in the 2º exemple in the body replacing the ids for the ids you are using and click in SEND

Body:

Example 2:

<br />


    {
        "id": "1",
        "firstName": "Manoel Henriq",
        "lastName": "Amorim dos Santos",
        "cpf": "123.456.789-19",
        "birthDate": "1998-10-29",
        "phones": [
  	        {
  	        "id": "1",
  		    "type": "MOBILE",
  		    "number": "(82)99999-8888"
	        }
        ]  
    }