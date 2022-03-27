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
    * **\<dataset1.csv\>**: Añade una descripción genérica del dataset.
    * **\<dataset2.csv\>**: Añade una descripción del resto de datasets que puedas tener.
     
## Estructura del *dataset*

Aquí debes describir la estructura del dataset explicando qué representan los datos que contiene y la descripción de cada una de las columnas. Incluye también la URL del dataset original.

El dataset está compuesto por \<N\> columnas, con la siguiente descripción:

* **\<columna 1>**: de tipo \<tipo\>, representa....
* **\<columna 2>**: de tipo \<tipo\>, representa....
....

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

- _método 1_: Descripción del método 1.
-	_método 2_: Descripción del método 2.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
