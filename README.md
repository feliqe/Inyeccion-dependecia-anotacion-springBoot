# Proyecto de Ejemplo con Spring Boot: Inyección de Dependencias con anotacion y manejo de proxi

¡Hola! En este proyecto, me gustaría explicarte cómo implementamos la inyección de dependencias en una aplicación Spring Boot, utilizando un archivo de base de datos ejmeplo factura.

Me gustaría aclarar algunos puntos sobre tu consulta:

1. **@Primary**: Se utiliza en la configuración de beans para indicar cuál bean debe ser seleccionado cuando hay múltiples beans del mismo tipo en el contexto de la aplicación. Esto es útil cuando hay más de un bean del mismo tipo y necesitas especificar cuál debería ser el principal o por defecto.

2. **@Qualifier("default")**: Se utiliza junto con la anotación @Autowired para indicar cuál bean específico debe ser inyectado cuando hay varios beans del mismo tipo en el contexto de la aplicación. En tu caso, se está calificando el bean con el alias "default" que se definió en la configuración de beans usando @Bean("default").

3. **@PostConstruct**: Es una anotación que se utiliza en métodos de inicialización para realizar acciones después de que el bean haya sido construido y antes de que sea entregado al solicitante. Es útil para realizar tareas de inicialización que no pueden ser realizadas dentro del constructor.

4. **@PreDestroy**: Es una anotación que se utiliza en métodos de destrucción para realizar acciones justo antes de que el bean sea destruido por el contenedor de Spring. Es útil para liberar recursos o realizar tareas de limpieza antes de que el bean sea eliminado.

5. **@RequestScope**: Se utiliza para indicar que el bean está asociado con el ciclo de vida de una solicitud HTTP. Esto significa que se crea un nuevo bean para cada solicitud HTTP y se destruye una vez que la solicitud ha sido completada.

6. **@JsonIgnoreProperties**: Se utiliza para indicar a Jackson, la biblioteca utilizada para serializar y deserializar objetos JSON en Java, que ignore ciertos campos al serializar un objeto. Esto puede ser útil cuando hay campos en el objeto que no se desean incluir en la representación JSON.

7. **@SessionScope**: Similar a @RequestScope, pero en lugar de estar asociado con una solicitud HTTP individual, el bean está asociado con la sesión HTTP del usuario. Esto significa que el bean persistirá durante toda la sesión del usuario y será destruido cuando la sesión expire.

Espero que esta explicación aclare tus dudas sobre estas anotaciones y cómo se utilizan en el contexto de la configuración y el ciclo de vida de los beans en Spring. Si necesitas más detalles sobre alguno de estos puntos, no dudes en preguntar.
