# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  21/22)
Autor/a: Fernando Cobos García   uvus:fercobgar

Aquí debes añadir la descripción del dataset y un enunciado del dominio del proyecto.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.clinico, fp.farmaceutico, fp.vacunas**: Paquetes que contienen los tipos del proyecto.
  * **fp.clinico.test, fp.farmaceutico.test, fp.vacunas.test**: Paquetes que contienen las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **estudio_clinico.csv**: Es un listado con los datos de Paciente Estudio, que son, el id del paciente, el genero, la edad, si tiene o no hipertension, si tiene o no enfermedad en el corazon, el tipo de residencia y el  nivel medio de glucosa
    * **ccaa_vacunas_3.csv**: Es un listado de los datos de Vacunación, que son , las fehcas de publicación de las vacunas, las comunidades autónomas, el numero de vacunas puestas de cada tipo, como son Pfizer, Moderna, AstraZeneca y Janssen y por ultimo el numero de personas con las dosis completas.
    * **medicamentos.csv**: Es un listado con los datos de medicamentos, que son, el nombre del medicamento, el tipo de medicamento, el codigo de la enfermedad, la farmaceutica que lo vende, la puntuacion del medicamento, el indice somatico y la fecha de catalogo.
     
## Estructura del *dataset*

*Dataset 1*

El dataset está compuesto por 7 columnas, con la siguiente descripción:

* **columna 1**: de tipo String, representa el id del paciente
* **columna 2**: de tipo String, representa el genero de cada paciente
* **columna 3**: de tipo Double, representa la edad de cada paciente
* **columna 4**: de tipo Boolean, representa si el paciente tiene o no hipertension
* **columna 5**: de tipo Boolean, representa si el paciente tiene o no enfermedad en el corazon
* **columna 6**: de tipo TipoResidencia, representa el tipo de residencia del paciete, si es rural o urbana
* **columna 7**: de tipo Double, representa el nivel medio de glucosa del paciente

*Dataset 2*

El dataset está compuesto por 7 columnas, con la siguiente descripción:

* **columna 1**: de tipo LocalDate, representa la fecha de publicacion de los datos
* **columna 2**: de tipo String, representa la comunidad autonoma de la que se recopilan los datos
* **columna 3**: de tipo Integer, representa la cantidad de vacunas pfizer puestas
* **columna 4**: de tipo Integer, representa la cantidad de vacunas moderna puestas
* **columna 5**: de tipo Integer, representa la cantidad de vacunas astazeneca puestas
* **columna 6**: de tipo Integer, representa la cantidad de vacunas janssen puestas
* **columna 7**: de tipo Integer, representa el numero de personas con las dosis completas puestas

*Dataset 3*

El dataset está compuesto por 7 columnas, con la siguiente descripción:

* **columna 1**: de tipo String, representa el nombre del medicamento
* **columna 2**: de tipo TipoMedicamento, representa el tipo de medicamento que es
* **columna 3**: de tipo String, representa el codigo de la enfermedad a la que ayuda a curar
* **columna 4**: de tipo String, representa la farmaceutica que lo distribuye
* **columna 5**: de tipo Double, representa la puntuacion dada a dicho medicamento
* **columna 6**: de tipo Integer, representa el indice somatico del medicamento
* **columna 7**: de tipo LocalDate, representa la fecha de catalogo del medicamento

## Tipos implementados

Describe aquí los tipos que usas en tu proyecto.

### Tipo Base
Dentro del tipo base, tenemos los records implementados en el proyecto. Estos son: Persona, Paciente, PacienteEstudio, Vacunacion y Medicamento.

**Persona**
**Propiedades**:

- nombre, de tipo String, consultable. 
- apellido, de tipo String, consultable y modificable. 
- dni, de tipo String, consultable.
- fechaNacimiento, de tipo LocalDate, consultable

**Constructores**: 

- C1: Método static of: recibe nombre, apellidos, dni y fecha de nacimiento y devuelve una persona.
- C2: Método static parse: Recibe una cadena con un formato específico y devuelve una persona.

**Restricciones**:
 
- R1: La fecha de nacimiento debe ser anterior a la fecha actual.
- R2: El dni debe ser una cadena con ocho dígitos y seguidos de una letra. 
- 
**Criterio de igualdad**: por defecto asociado al record. 

**Criterio de ordenación**:  Se ordenara por el dni de la persona.

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...

**Paciente**
**Propiedades**:

- persona, de tipo Persona, consultable. 
- codigoIngreso, de tipo String, consultable. 
- fechaHora, de tipo LocalDateTime, consultable

**Constructores**: 

- C1: Método static of: recibe nombre, apellidos, dni, fecha de nacimiento, código y fecha y hora de ingreso y devuelve un paciente. 
- C2: Método static of: recibe un objeto persona, un código y una fecha y hora de ingreso y devuelve un paciente. 


**Restricciones**:
 
- R1: La fecha y hora de ingreso debe ser anterior o igual a la fecha actual
 
**Criterio de igualdad**: Por defecto asociado al record. 

**Criterio de ordenación**: Por defecto asociado al record.

**PacienteEstudio**
**Propiedades**:

- id, de tipo String, consultable. 
- genero, de tipo String, consultable. 
- edad, de tipo Double, consultable.
- hipertension, se tipo Boolean, consultable.
- enfermedadCorazon, se tipo Boolean, consultable.
- tipoResidencia, se tipo TipoResidencia, consultable.
- nivelMedioGlucosa, de tipo Double, consultable.

**Constructores**: 

- C1: Método static of: recibe valores para cada propiedad básica y devuelve un objeto del tipo 
- C2: Método static parse: recibe una cadena con un formato especificado y y devuelve un objeto del tipo.


**Restricciones**:
 
- R1: La edad tiene que ser mayor o igual que cero y menor o igual que 130. 
- R2: El nivel medio de glucosa tiene que ser mayor o igual que cero.

**Representacion como cadena**: informa del id y la edad del paciente.  
 
**Criterio de igualdad**: Por defecto asociado al record. 

**Criterio de ordenación**: Se ordena segun la edad y el dni.

**Vacunacion**
**Propiedades**:

- fecha, de tipo LocalDate, consultable. 
- comunidad, de tipo String, consultable. 
- pfizer, de tipo Integer, consultable.
- moderna, se tipo Integer, consultable.
- astrazeneca, se tipo Integer, consultable.
- janssen, se tipo Integer, consultable.
- numeroPersonas, de tipo Integer, consultable.

**Constructores**: 

- C1: Método static of: recibe valores para cada propiedad básica y devuelve un objeto del tipo.
- C2: Método static parse: recibe una cadena con un formato específico y devuelve un objeto del tipo.


**Restricciones**:
 
- R1: La fecha de debe ser posterior al 01/02/2021. 

**Representacion como cadena**: Por defecto asociado al record.
 
**Criterio de igualdad**: Por defecto asociado al record. 

**Criterio de ordenación**: Se ordena por comunidad y en caso de igualdad por fecha.

**Medicamento**
**Propiedades**:

- tipoMedicamento, de tipo TipoMedicamento, consultable. 
- codigoEnfermedad, de tipo String, consultable. 
- farmaceutica, de tipo String, consultable.
- puntuacion, se tipo Double, consultable.
- indiceSomatico, se tipo Integer, consultable.
- fechaCatalogo, se tipo LocalDate, consultable y modificable.

**Constructores**: 

- C1:
- C2:

**Restricciones**:
 
- R1: La puntación tiene que ser mayor estricta que cero.
- R2: El índice somático tiene que ser mayor o igual que 1000.
- R3: La fecha de catálogo tiene que ser posterior al 01/01/2015.

**Representacion como cadena**: según el nombre del medicamento y de la farmacéutica
 
**Criterio de igualdad**: Por nombre del medicamento y farmacéutica. 

**Criterio de ordenación**:  Por nombre del medicamento y en caso de igualdad por la farmacéutica.

#### Tipos auxiliares
TipoResidencia, TipoMedicamento, PersonaTest, FactoriaMedicamentoTest, VacunacionTest.

### Factoría
Descripción breve de la factoría.

- FactoriaMedicamento.parseaMedicamento: parsea los datos del tipo medicamento que le entran
-	FactoriaMedicamento.leeFichero: lee el fichero medicamentos.csv
- FactoriaVacunacion.leeFichero: lee el fichero ccaa_vacunas.csv

### Tipo Contenedor

Clase que realiza funciones utilizando el dataset

**Propiedades**:

- lista, de tipo List, consultable. 

 
**Constructores**: 

- C1: Constructor vacío, que construye la lista sin ningún elemento. 
- C2: Constructor que recibe una lista de objetos del tipo PacienteEstudio como parámetro.


**Otras operaciones**:

*Funciones:*
-	numeroPacientes(): nos devuelve el numero de pacientes que hay
-	incluyePaciente(PacienteEstudio paciente): nos permite incluir nuevos pacientes al final de la lista
-	incluyePacientes(Collection<PacienteEstudio> pacientes): nos permite incluir nuevos pacientes donde queramos
-	eliminaPaciente(PacienteEstudio paciente): nos permite eliminar pacientes de la lista
-	Boolean estaPaciente(PacienteEstudio paciente): nos permite ver si un paciente se encuentra en la lista
-	borraEstudio(): nos permite borrar los datos de la lista

*Metodos:*
-	of: devuelve tipo EstudioClinico con los datos de un fichero
-	lee fichero: lee los datos de un fichero y los mete en una lista0