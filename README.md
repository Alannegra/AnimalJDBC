#AnimalJDBC
## Práctica JDBC
### Intro
#### Con la utilización JDBC PostgreSQLDriver y la informacion extraída en el proyecto WebScrapping llamado Animal he conseguido diseñar un programa capaz de borrar, crear y poblar tablas, capaz de realizar consultas, gestiónar resultados, modificarlos y procesarlos.
### Code
#### El código empieza con un proyecto como esqueleto llamado PrácticaACB, este nos facilitara la implementación de los controladores. El primer controlador es el más importante se llama BioParcController su nombre es el mismo que el de la base de datos remota que ha sido creada previamente con su usuario y permisos, este controlador nos permite borrar tablas de la base de datos, crear tablas mediante sentencias sql que enviamos incluso poblarlas. Aquí me he visto obligado a añadir la librería Opencsv que es realmente útil para lo que necesitamos para poblar las tablas de nuestros archivos .csv del anterior proyecto. El resto de controladores no son tan considerables, pero nos permiten hacer cosas muy interesantes como consultar datos de la base de datos de la manera que nosotros queramos, yo he intentado replicar la manera visual de PostgreSQL para facilitar la visualización de las consultas.
### Instrucciónes
#### Será necesario alterar los datos en el archivo db.properties para poder conectarnos a la base de datos. Será necesario tener una base de datos. Iniciamos el JDBCMain y ya podemos gozar de un maginífico menú con distintas opciones, las cuales posiblemente nos indiquen de escribir algo concreto.
