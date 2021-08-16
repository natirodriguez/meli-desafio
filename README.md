# Examen de Mercado Libre

<b>Lenguaje:</b> Java v8<br />
<b>Base de datos embebida:</b> h2<br />
<b>Gestor de dependencias:</b> Maven<br />
<b>Test:</b> Junit, Moquito<br />
<b>IDE:</b> Eclipse<br />
<b>Cobertura de test:</b> Jacoco<br />
Postman <br />
Heroku <br />

## Algoritmo de búsqueda
El algoritmo de búsqueda realizado en el siguiente desafio recorre todas las filas, y luego va recorriendo el string. 
La complejidad en el peor de los casos para el algoritmo propuesto es de O(n²).<br>
Mientras no encuentre mutantes, se realiza una búsqueda primero por fila, luego por columna, y por último por diagonal. 

## API
<b>URL: </b> https://meli-mutante.herokuapp.com <br/>
   * /mutante <br/>
        <b>Tipo:</b> Post <br/>
		<b>Respuestas posibles:</b> 200 OK, 403 Forbidden y 400 bad request <br/>
		<b>Formato esperado:</b> Objeto que contiene un array llamado _adn_ <br/>
        <b>Ejemplo del body: </b>`{ "adn": ["ATGCGA","CAGTGC","TTTTGT","AAAAGG","CCCCTA","TCACTG"] }`
   * /stats <br/>
        <b>Tipo:</b> Get <br/>
		<b>Respuestas posibles:</b> 200 OK <br/>

## Test y Cobertura
Para las pruebas se utilizo JUnit y Moquito para simular objetos o resultados. <br/>
Para poder correr los test, es necesario tener maven instalado y bajar las dependencias, realizando la siguiente linea de codigo sobre la consola: 
`mvn clean install`<br/>
Luego de realizado esto, es necesario correr los test: <br/>
`mvn test`<br/>
Para la cobertura de los test, utilice Jacoco. El actual porcentaje de test realizados en todo el ejercicio es de 82%.
Para poder visualizarlo, ir a: _target/site/jacoco_ y abrir el archivo _index.html_.

![Jacoco.png](https://github.com/natirodriguez/meli-desafio/blob/main/jacoco.png)

## Prueba de stress
Para realizar las pruebas de stress utilice la página: https://www.loader.io/ <br/>
<b> URL con un ejemplo de 1000 clients: </b>
https://bit.ly/3AF7b6q

## Mejoras futuras
   * Guardar en memoria cache, el string analizado. Para evitar que se recorran string que ya hayan sido calculados
   * Bajar la complejidad algoritma. Una de las soluciones posibles es separar el string de a 4. Y de ahi ir contando los siguientes o anteriores char para ver si encuentra alguno consecutivo

<b>Autor:</b> Natalia Stefania Rodriguez <br/>
<b>Email:</b> nati.stefania@gmail.com <br/>
<b>Linkedin:</b> https://www.linkedin.com/in/natalia-rodriguez-80029b58/

