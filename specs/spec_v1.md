# Módulo: Inventario y equipamiento
 
## 1. Contexto y alcance
 
El RPG Manager es un sistema de consola para administrar personajes de rol. Este módulo permite que el jugador administre el inventario de su personaje: registrar los objetos que recoge, listarlos, filtrarlos, consultar la capacidad disponible, recibir un aviso cuando el inventario está lleno, descartar objetos, proteger objetos, equipar armas y armaduras, y comparar un equipo nuevo con el equipo actual. Queda fuera de alcance la creación de personajes, la compra y venta de objetos, el combate y la gestión de misiones. Se asume que el personaje ya existe y llega al módulo con su nombre, su nivel, su ataque base y su defensa base.
 
## 2. Actores
 
- **Jugador**: persona que controla un personaje y administra su inventario.
## 3. Requerimientos funcionales
 
- **RF-01** El jugador puede agregar al inventario un objeto que recogió en la aventura (historia RMIYE-11).
  - Criterio de aceptación: dado un inventario cuyo peso total más el peso del objeto no supera la capacidad máxima, al agregar el objeto este aparece en el inventario y el peso total aumenta en el peso del objeto; si la suma supera la capacidad máxima, el objeto no se agrega, el inventario queda sin cambios y se aplica RF-05.
- **RF-02** El jugador puede listar los objetos de su inventario (historia RMIYE-2).
  - Criterio de aceptación: la lista muestra el nombre, el tipo (Arma, Armadura u Otro) y el peso de cada objeto, e indica cuáles están equipados y cuáles están protegidos.
- **RF-03** El jugador puede filtrar los objetos de su inventario por tipo, por texto en el nombre o por ambos criterios a la vez (historia RMIYE-6).
  - Criterio de aceptación: la lista filtrada contiene solo los objetos que cumplen todos los criterios indicados, y si ningún objeto cumple se muestra el mensaje "Sin resultados" sin modificar el inventario.
- **RF-04** El jugador puede consultar la capacidad disponible de su inventario (historia RMIYE-9).
  - Criterio de aceptación: la consulta muestra la capacidad máxima, el peso total y la capacidad disponible calculada según RN-07.
- **RF-05** El sistema avisa al jugador cuando el inventario está lleno al intentar agregar un objeto (historia RMIYE-8).
  - Criterio de aceptación: si el peso del objeto supera la capacidad disponible, el sistema muestra un aviso de inventario lleno que cita RN-01 e indica cuántas unidades de peso hay que liberar para que el objeto quepa.
- **RF-06** El jugador puede descartar un objeto de su inventario (historia RMIYE-8, decidir qué descartar).
  - Criterio de aceptación: tras descartar un objeto no protegido, este deja de aparecer en el inventario y el peso total disminuye en el peso del objeto; si el objeto está protegido, no se descarta y el mensaje de error cita RN-05.
- **RF-07** El jugador puede equipar un arma o una armadura de su inventario (historia RMIYE-3).
  - Criterio de aceptación: si el nivel del personaje es mayor o igual al nivel mínimo del objeto, el objeto queda equipado, cualquier objeto del mismo tipo que estaba equipado pasa a no equipado sin salir del inventario, y el ataque total o la defensa total del personaje se recalculan según RN-08; si el nivel es menor, el objeto no se equipa y el mensaje de error cita RN-02.
- **RF-08** El jugador puede comparar un arma o una armadura de su inventario con el equipo que tiene equipado del mismo tipo (historia RMIYE-5).
  - Criterio de aceptación: la comparación muestra el bono del objeto nuevo, el bono del objeto equipado y la diferencia entre ambos; si no hay un objeto equipado del mismo tipo, el bono actual se muestra como 0.
- **RF-09** El jugador puede marcar y desmarcar un objeto de su inventario como protegido (historia RMIYE-4).
  - Criterio de aceptación: un objeto marcado aparece como protegido en el listado y queda sujeto a RN-05; al desmarcarlo deja de estar protegido.
## 4. Requerimientos no funcionales
 
- **RNF-01** Listar y filtrar el inventario responde en menos de 1 segundo con hasta 100 objetos.
- **RNF-02** Las reglas de negocio RN-01 a RN-08 tienen pruebas unitarias con al menos 70 % de cobertura.
- **RNF-03** Cada mensaje de error está en español e incluye el código de la regla de negocio violada (por ejemplo, RN-01).
## 5. Reglas de negocio
 
- **RN-01** La suma de los pesos de los objetos del inventario no puede superar la capacidad máxima de 50 unidades de peso.
- **RN-02** Un personaje solo puede equipar un arma o una armadura si su nivel es mayor o igual al nivel mínimo del objeto.
- **RN-03** Un personaje tiene como máximo un arma equipada a la vez.
- **RN-04** Un personaje tiene como máximo una armadura equipada a la vez.
- **RN-05** Un objeto protegido no puede descartarse ni perderse por el fallo de una misión.
- **RN-06** Al descartar un objeto equipado, el objeto se desequipa antes de eliminarse del inventario.
- **RN-07** La capacidad disponible es la capacidad máxima menos el peso total, y nunca es negativa.
- **RN-08** El ataque total del personaje es su ataque base más el bono de ataque del arma equipada, y la defensa total es su defensa base más el bono de defensa de la armadura equipada.
## 6. Supuestos y glosario
 
- **Personaje**: versión mínima de este módulo, con nombre, nivel, ataque base y defensa base. Cada personaje tiene un único inventario.
- **Inventario**: conjunto de objetos que lleva un personaje, con una capacidad máxima de 50 unidades de peso.
- **Objeto**: elemento con nombre, peso entero mayor o igual a 1 y marca de protegido. Los tipos de objeto son Arma, Armadura y Otro. Los objetos no se apilan: cada uno ocupa su propio lugar.
- **Arma**: objeto con un bono de ataque y un nivel mínimo de personaje para equiparla.
- **Armadura**: objeto con un bono de defensa y un nivel mínimo de personaje para equiparla.
- **Objeto protegido**: objeto marcado por el jugador para que no se descarte ni se pierda al fallar una misión. La pérdida de objetos por fallo de misión ocurre fuera de este módulo, que solo garantiza que los objetos protegidos quedan excluidos.
- **Inventario lleno**: situación en la que la capacidad disponible es menor que el peso del objeto que se intenta agregar.
- **Peso total**: suma de los pesos de todos los objetos del inventario, equipados o no.
- **Equipado**: un arma o una armadura que el personaje tiene en uso; sigue contando en el peso total.
 
