# Manual Técnico LifeDog App

![Grupo 671](https://github.com/UCASV/proyecto-lifedog/blob/master/RES/logo.png) 

## Índice
 - [Manual Técnico](#Manualtécnico) 
- [Usuarios de prueba](#Usuariosdeprueba) 
- [Enlace de video](#Enlacedevideo) 
-  [Licencia de código](#Licenciadecódigo) 
-  [Enlace de ClickUp](#clic)


# Manual Técnico <a name="Manualtécnico"></a>

- [Aspectos generales](#Aspectosgenerales) 
	- [Objetivos del documento](#objetivos)
	- [Descripción general](#desc)
	- [Requerimientos del Sistema](#req)
	- [Software utilizado](#soft)
 - [Modelos utilizados](#modelosu) 
	 - [Patrón de diseño MVVM](#mvvm)
	 - [Diagrama Relacional Normalizado de Base de Datos](#diagrama)
-  [Página web para administrar usuarios y perros](#web)
- [Conceptos técnicos y tipos de error](#error) 
	- [Implementación de Base de Datos](#bdimp)
	 - [Implementación de MVVM](#mvvmimp)
	 - [Implementación de API](#apiimp)
	 - [Navegación](#nav)
	 - [Plataforma base](#base)
	 - [Tipos de error](#error1)
- [Nomenclaturas](#Nomenclaturas) 
- [Forma de uso](#Formadeuso)
	- [CRUD Usuario en API](#crudUser)
	- [CRUD Perro en API](#crudApi)
	- [Iniciar Sesión](#login)
	- [Agregar Perro](#agregar)
	- [Sección de consejos](#consejo)
	- [Cerrar Sesión](#logout)
	
		

 
 ## Aspectos generales <a name="Aspectosgenerales"></a>
 
**Objetivos del documento**  <a name="objetivos"></a>
  
  El objetivo del documento es presentar y explicar de manera detallada los distintos aspectos y herramientas que se tomaron en cuenta para el desarrollo de la interfaz gráfica, base de datos y funcionalidades de la aplicación. Además de explicar al usuario final los requerimientos, estructura y conformación de la aplicación.

**Descripción general**  <a name="desc"></a>
 
 LifeDog es una aplicación pensada para todo lo que necesitas recordar y organizar a diario acerca de tu canino. Con esta aplicación podrás hacer un correcto seguimiento de las necesidades diarias de tu mascota, como; recordatorios de paseo, recordatorios de alimentación, citas con el veterinario, seguimientos, control de enfermedades, control de gastos, entre otras cosas que permiten hacer del cuido de tú mascota, una tarea mucho más fácil y organizada.
  
La aplicación fue desarrollada bajo el modelo Model-View-View-Model (MVVM), que puede ser consultado de manera más detallada en este enlace [MVVM](#mvvm)
 
**Requisitos del Sistema** <a name="req"></a>

* **Requerimientos de Hardware**
  - Equipo, Teclado, Mouse, Monitor, Emulador o Dispositivo Móvil.
  - 8 GB de RAM recomendados (2 GB mínimo).
  - 4 GB de espacio en disco duro (2 GB mínimo).
  - Tarjeta de red LAN y/o Wireless.

* **Requerimientos de Software**
  - Microsoft Windows 7/8/10 (32-64 bits).
  - Java 8.0.
  - Sistema operativo móvil (Android 7.0 en adelante).
  - Conexión internet local y móvil. 
 
 **Software utilizado** <a name="soft"></a>
 
 Para la creación de la aplicación se utilizó el entorno oficial de Android Studio basado en IntelliJ IDEA,  disponible para las plataformas Microsoft Windows, macOS y GNU/Linux en su versión *`Android Studio Versión 4.1.1`*.
Android Studio, a parte de brindar un editor de código y componentes para desarrollo, también brinda aumentar mucho la productividad, por lo que es una herramienta muy recomendada para el desarrollo de aplicaciones móviles.

 Para la creación de la API se utilizó Visual Studio Code que es un editor de texto plano desarrollado por Microsoft totalmente gratuito y de código abierto. 
Además, para probar las rutas de la API, se utilizó Insomnia, que es un potente cliente de API REST con administración de cookies, variables de entorno, generación de código y autenticación para Mac, Window y Linux.
También, para subir la página web a un servidor, se utilizó Heroku, que es una plataforma en la nube que permite construir, entregar, supervisar aplicaciones y alojarlas en la nube.

 Adicionalmente, se utilizarón los componentes de arquitectura:
 - *Fragment:* 
   Permite segmentar la aplicación en varias pantallas independientes alojadas en un objeto Activity.
 - *Activity:*
   Accede a las API que admiten composición compiladas sobre Activity.
 - *Lifecycle:*
   Optimiza componentes con ciclos de vida que ayudan a crear un código mejor organizado, y a menudo más liviano.
 - *Navigation:*
   Permite navegar entre "destinos" dentro de una aplicación para Android que proporciona una API.
 - *Room:*
   Brinda una capa de abstracción para SQLite que permite acceder a la base de datos y, al mismo tiempo, aprovechar toda la potencia de SQLite.
   
También se utilizaron las tecnologías:
 - *NodeJS:*
   Es un entorno en tiempo de ejecución multiplataforma, de código abierto, para la capa del servidor basado en el lenguaje JavaScript.
 - *Express:*
   Es un framework web transigente, escrito en JavaScript y alojado dentro del entorno de ejecución NodeJS. 
 - *MongoDB Atlas:*
   Es la base de datos como servicio que permite implementar, utilizar y escalar una base de datos de MongoDB.
## Modelos utilizados <a name="modelosu"></a>

**Patrón de diseño MVVM**  <a name="mvvm"></a>

Los patrones de diseño nos ofrecen una arquitectura y un conjunto de reglas definidas previamente que deben de ser cumplidos en nuestra aplicación.
En el desarrollo de la aplicación se implementó el patrón de diseño MVVM (Modelo-Vista-Vista-Modelo). Este tipo de patrón de diseño nos ayuda para  separar la lógica de negocios de la interfaz de usuario, logrando que la parte visual sea totalmente independiente, esto hace que se facilite el mantenimiento de los proyectos. 
Algunas de las ventajas que se obtiene al ocupar dicho patrón, son las siguientes:

-   Código más limpio y organizado.
-   Mayor claridad y mejor comprensión del proyecto frente a otros desarrolladores.
-   Reutilización de código.
-   Mantenimiento más rápido.
-   Aplicación escalable.

 **Diagrama Relacional Normalizado de Base de Datos**  <a name="diagrama"></a>
 
 ![Base de datos Life Dog](https://github.com/UCASV/proyecto-lifedog/blob/master/RES/Base%20de%20datos%20Life%20Dog.jpeg)

## Página web para administrar usuarios y perros  <a name="web"></a>

Para poder administrar a los usuarios y los caninos de forma sencilla, se realizó una página web en dónde se utilizó un menú en la parte superior para poder cambiar de pestaña cómodamente entre **Usuarios** y **Perros**. 
Este sitio permite agregar, modificar y eliminar los registros deseados.

*Administrar Usuarios:*

En la siguiente imagen se puede observar la interfaz de la página web que se utiliza para agregar usuarios, donde se cuenta con campos para ingresar:
 - Nombre
 - Contraseña
 - Correo electrónico 

![usuarios](https://github.com/UCASV/proyecto-lifedog/blob/master/RES/web%20usuario.jpeg)

Cuenta con la opción de visualizar los registros agregados y poder eliminar o editar cualquiera de los registros.

*Administrar Perros:*

En esta imagen se puede ver la interfaz de la página que se utiliza para agregar Perros, donde se cuenta con campos para ingresar:
 - Nombre
 - Color
 - Fecha de nacimiento
 - Raza
 - Peso en kg
 - Tamaño  

También cuenta con un checkbox donde se utiliza para marcar si el canino esta esterilizado/a. Y un radio button que se utiliza para saber si el perro a ingresar es macho o hembra.
 
![perros](https://github.com/UCASV/proyecto-lifedog/blob/master/RES/web%20perritos.jpeg)

Cuenta con la opción de visualizar los registros agregados y poder eliminar o editar cualquiera de los registros.

*Página Web:*

Si se desea entrar a la página web completa, [clic aquí](https://life-dog.herokuapp.com/) 

## Conceptos técnicos y tipos de error <a name="error"></a>

**Implementación de Base de Datos:** <a name="bdimp"></a>

La implementación de la Base de Datos, consiste en la estructuración de diferentes paquetes que contienen elementos necesarios para el correcto funcionamiento de nuestra base.
Los paquetes se dividen de la siguiente manera:

* **Data**
  - **Dao**
  - **Entity**  
* **Repository**

Dentro del paquete *Data* se crea una clase llamada *LifeDogDatabase*, que realiza la instancia de la base de datos además de autocompletar ciertos valores dentro de la base sin necesidad que sean agregados por el usuario.

El paquete *DAO* permite acceder a los datos de la aplicación, ya que cada DAO incluye métodos que ofrecen acceso abstracta a la base de datos de la app.

El paquete *Entity* permite crear una tabla dentro del objeto Database asociado con el fin de retener los elementos.

El paquere *Repository* permite crea una clase que abstrae el acceso a varios orígenes de datos.

Fuera de los dos paquetes se crea una clase llamada *LifeDogApplication* que permite que el repositorio sea accesible de forma global.

**Implementación de MVVM** <a name="mvvmimp"></a>

La implementación del modelo Model-View-View-Model consiste en la estructuración de diferentes clases que contienen elementos necesarios para el correcto funcionamiento del modelo.
Los paqutes se dividen de la siguiente manera:

* **Fragment**
* **ViewModel**
* **ViewModelFactory**

La clase *Fragment* representa un comportamiento o una parte de la interfaz de usuario.

La clase *ViewModel* almacena y administra datos relacionados con la IU de manera optimizada para los ciclos de vida.

La clase *ViewModelFactory* crea una instancia y devuelve el objeto ViewModel.

**Implementación de API** <a name="apiimp"></a>

Se crea un paquete *Network* que contiene dos clases:

* **API**
* **Webservice**

La clase *API* crea una instancia de la API de Retrofit para hacer las peticiones usando el servicio.

La interfaz *Webservice* brinda un servicio recopilación de los métodos de las peticiones HTTP.

**Implementación de Navegación** <a name="nav"></a>  
 
La navegación se divide en 5 archivos .xml:

* **expenses_nav_fragment:**
  Navega entre las pantallas que pertenecen a los gastos de los perros del usuario.
* **home_nav:**
  Navega entre la creación del perro y el perfil del mismo.
* **main_profile_nav:**
  Navega entre el perfil del perro y las acciones que puede realizar. Como las pantallas de agregar recordatorios o ver la información del mismo.
* **navigation_graph**
  Navega entre las pantallas de inicio, inicio de sesión y las de reestablecimiento de contraseña. 
* **settings_nav**
  Navega entre las pantallas de configuración de la aplicación.
 
**Plataforma base**  <a name="base"></a>

||  |
-|-|
| Sistema Operativo |Windows |
|Tecnologías|Android Studio 4.1.1|
|  Lenguaje| Kotlin  |

**Tipos de error**   <a name="error1"></a>  

Un error es un fallo que desencadena un resultado no deseado, si este no se corrige, el usuario no podría ejecutar el programa de una manera idónea. Por lo que se crearon excepciones personalizadas para que el programa funcionara correctamente y el usuario tuviese una mejor experiencia. Los tipos de errores que se detectaron son los siguientes:

 - Nombre de usuario que posea una longitud mayor a 20 caracteres.
 - Dejar el campo de "Usuario" vacío.
 
 ## Nomenclaturas   <a name="Nomenclaturas"></a>
 
 Las abreviaturas utilizadas a lo largo del programa se basan en las letras iniciales del elemento en cuestión, y otras se basan en letras significativas que permites asociarlas con el nombre original del elemento. Dentro del programa siguen la normativa de nombramiento:
 
*`<Abreviatura de tipo> Nombre`*  

Se presentan a continuación:
|  |  |
|--|--|
|Button  | btn  |
|  TextView | tv |
|  ImageButton | ib|
|  ImageButton | ib|
|  EditText | ed|

## Forma de uso <a name="Formadeuso"></a>

**CRUD Usuario en API** <a name="crudUser"></a>

Permite Crear, Editar y Eliminar los datos de un usuario dentro de la API, además de mostrarse los registros con los usuarios agregados.

**CRUD Perro en API** <a name="crudApi"></a>

Permite Crear, Editar y Eliminar los datos de un perro dentro de la API, además de mostrarse los registros con los perros agregados.

**Iniciar Sesión** <a name="login"></a>

Para iniciar sesión, solo debes introducir el correo de tú cuenta y la contraseña pertienente. Estos mismos datos son los que utilizaste para crear tú cuenta.


**Agregar Perro** <a name="agregar"></a>

Debes dirigirte a la Cruz que muestra la pantalla y hacer click en ella, te redirigirá a una pantalla en la cual se ingresarán los datos; Nombre, Raza, Género, Tamaño, Peso, Cumpleaños, Color, si esta Esterilizado, Enfermedades y Alergias.
Clickeas en el botón, y listo, se agregara el perro según tú usuario.

**Sección de consejos** <a name="consejo"></a>

Sabemos que es de vital importancia el cuidado de tu amigo perruno, por esa razón pensamos en la utilidad de una sección exclusivamente para consejos, donde encontrarás un poco de ayuda para el cuidado de tu amigo peludo; desde consejos del cuidado de sus uñas hasta consejos sobre su peso. 
Esta sección se encuentra en una tarjeta de colores, ubicada en la pantalla principal de nuestra aplicación.
    
**Cerrar Sesión** <a name="logout"></a>

Si quieres iniciar sesión con otra cuenta o simplemente salir de la tuya, dirígite a configuraciones y en el apartado final, aparecerá la opciónn con la cual podrás salir de tú cuenta.  



# Usuarios de prueba  <a name="Usuariosdeprueba"></a>

Para iniciar sesión correctamente en nuestra aplicación y verificar que todo este en orden, se mostrara a continuación una pequeña prueba de 2 usuarios.

- Credenciales para **usuario1**:

|  |  |
|--|--|
|  Correo     | usuarioprueba1@lifedog.com  |
|  Contraseña | 1234     |

![Pagina de Usuarios1, LifeDog](https://github.com/UCASV/proyecto-lifedog/blob/master/RES/usuario1.jpg)

Se muestra como inicia sesión correctamente el **usuario1**:

![Pagina de Usuarios, LifeDog](https://github.com/UCASV/proyecto-lifedog/blob/master/RES/usuario1.1.jpeg)

- Credenciales para **usuario2**:

|  |  |
|--|--|
|  Correo     | usuarioprueba2@lifedog.com |
|  Contraseña | 12345      |

![Pagina de Usuarios1, LifeDog](https://github.com/UCASV/proyecto-lifedog/blob/master/RES/usuario2.jpeg)

Se muestra como inicia sesión correctamente el **usuario2**:

![Pagina de Usuarios1, LifeDog](https://github.com/UCASV/proyecto-lifedog/blob/master/RES/usuario2.1.jpeg)

Como podemos observar, se ingresan todos los datos correspondientes para el inicio de sesión y se ingresa correctamente a la aplicación.

# Enlace del video <a name="Enlacedevideo"></a>


Si se desea observar nuestro video de trabajo de la aplicación: 

[https://youtu.be/Jh7apiskwcI](https://youtu.be/Jh7apiskwcI "https://youtu.be/Jh7apiskwcI") 

# Licencia de código <a name="Licenciadecódigo"></a>

*GNU General Public License v3.0*

# Enlace de ClickUp <a name="clic"></a>  

  Para tener una visualización de como se manejo la distribución de tareas realizadas en la aplicación, fue de mucha utilidad la herramienta "ClickUp" , la cual nos ayudo de gran manera a organizarnos para desarrolar nuestra aplicación.

Si se desea observar nuestro espacio de trabajo en ClickUp: [clic aquí](https://sharing.clickup.com/l/h/4-14923438-1/e74bfa159f1c094) 

