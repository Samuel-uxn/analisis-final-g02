# Módulo: Inventario y equipamiento

## 1. Contexto y alcance

El RPG Manager es un sistema de consola para administrar personajes de rol. Este módulo permite que el jugador administre el inventario de su personaje: registrar los objetos que recoge, listarlos, filtrarlos, consultar la capacidad disponible, recibir un aviso cuando el inventario está lleno, descartar objetos, proteger objetos, equipar armas y armaduras, y comparar un equipo nuevo con el equipo actual. Queda fuera de alcance la creación de personajes, la compra y venta de objetos, el combate y la gestión de misiones. Se asume que el personaje ya existe y llega al módulo con su código, su nombre, su nivel, su ataque base y su defensa base.

## 2. Actores

- **Jugador**: persona que controla un personaje y administra su inventario. Es el único actor; el inventario y el personaje son entidades del módulo, no actores.

## 3. Requerimientos funcionales

- **RF-01** El jugador puede agregar al inventario un objeto que recogió en la aventura (historia RMIYE-11).
  - Criterio de aceptación: Escenario 1 (cabe): si el peso total más el peso del objeto no supera la capacidad máxima, el inventario agrega el objeto, el objeto aparece en la lista, el peso total aumenta en el peso del objeto y el inventario confirma al jugador que el objeto se agregó. Escenario 2 (no cabe): si la suma supera la capacidad máxima, el inventario no agrega el objeto, no cambia, y muestra el aviso de RF-05 que cita RN-01.
- **RF-02** El jugador puede listar los objetos de su inventario (historia RMIYE-2).
  - Criterio de aceptación: el inventario muestra al jugador, por cada objeto, el nombre, el tipo (Arma, Armadura u Otro), el peso, si está equipado y si está protegido. Si el inventario no tiene objetos, muestra el mensaje "Inventario vacío". El listado no muestra la capacidad disponible.
- **RF-03** El jugador puede filtrar los objetos de su inventario por tipo, por texto en el nombre o por ambos criterios a la vez (historia RMIYE-6).
  - Criterio de aceptación: Escenario 1 (por tipo): el inventario muestra solo los objetos del tipo indicado. Escenario 2 (por texto): muestra solo los objetos cuyo nombre contiene el texto indicado, sin distinguir mayúsculas de minúsculas. Escenario 3 (ambos): muestra solo los objetos que cumplen los dos criterios. Escenario 4 (sin coincidencias): el inventario muestra el mensaje "Sin resultados" y no se modifica. El filtrado no muestra la capacidad disponible.
- **RF-04** El jugador puede consultar la capacidad disponible de su inventario (historia RMIYE-9).
  - Criterio de aceptación: el inventario calcula la capacidad disponible según RN-07 y la muestra al jugador junto con la capacidad máxima y el peso total.
- **RF-05** Cuando el jugador intenta agregar un objeto que no cabe, el inventario le avisa que está lleno (historia RMIYE-8). El aviso no es una operación que el jugador inicie por separado: ocurre dentro de RF-01.
  - Criterio de aceptación: si el peso del objeto supera la capacidad disponible, el inventario muestra un aviso de inventario lleno que cita RN-01 e indica cuántas unidades de peso hay que liberar para que el objeto quepa.
- **RF-06** El jugador puede descartar un objeto de su inventario (historia RMIYE-8, decidir qué descartar).
  - Criterio de aceptación: Escenario 1 (objeto común): si el objeto no está protegido ni equipado, el inventario lo elimina, deja de aparecer en la lista y el peso total disminuye en el peso del objeto. Escenario 2 (protegido): si el objeto está protegido, el inventario no lo elimina y el mensaje de error cita RN-05. Escenario 3 (equipado): si el objeto está equipado y no está protegido, el personaje lo desequipa según RN-06 y después el inventario lo elimina.
- **RF-07** El jugador puede equipar un arma de su inventario (historia RMIYE-3).
  - Criterio de aceptación: Escenario 1 (éxito): si el nivel del personaje es mayor o igual al nivel mínimo del arma, el personaje equipa el arma y su ataque total se recalcula según RN-08. Escenario 2 (reemplazo): si ya había un arma equipada, esta pasa a no equipada sin salir del inventario (RN-03). Escenario 3 (nivel insuficiente): si el nivel del personaje es menor, el personaje no equipa el arma y el mensaje de error cita RN-02.
- **RF-08** El jugador puede comparar un arma o una armadura de su inventario con el equipo que tiene equipado del mismo tipo (historia RMIYE-5).
  - Criterio de aceptación: la comparación muestra al jugador el bono del objeto nuevo, el bono del objeto equipado y la diferencia entre ambos; si no hay un objeto equipado del mismo tipo, el bono actual se muestra como 0. La comparación no modifica el inventario ni las estadísticas del personaje.
- **RF-09** El jugador puede marcar y desmarcar un objeto de su inventario como protegido (historia RMIYE-4).
  - Criterio de aceptación: Escenario 1 (marcar): el objeto pasa a protegido y queda sujeto a RN-05. Escenario 2 (desmarcar): el objeto deja de estar protegido y el inventario confirma el cambio al jugador.
- **RF-10** El jugador puede equipar una armadura de su inventario (historia RMIYE-3).
  - Criterio de aceptación: Escenario 1 (éxito): si el nivel del personaje es mayor o igual al nivel mínimo de la armadura, el personaje equipa la armadura y su defensa total se recalcula según RN-08. Escenario 2 (reemplazo): si ya había una armadura equipada, esta pasa a no equipada sin salir del inventario (RN-04). Escenario 3 (nivel insuficiente): si el nivel del personaje es menor, el personaje no equipa la armadura y el mensaje de error cita RN-02.

## 4. Requerimientos no funcionales

- **RNF-01** Listar y filtrar el inventario responde en menos de 1 segundo con hasta 100 objetos.
- **RNF-02** Las reglas de negocio RN-01 a RN-11 tienen pruebas unitarias con al menos 70 % de cobertura.
- **RNF-03** Cada mensaje de error y cada aviso está en español e incluye el código de la regla de negocio violada (por ejemplo, RN-01).

## 5. Reglas de negocio

- **RN-01** La suma de los pesos de los objetos del inventario no puede superar la capacidad máxima de 50 unidades de peso.
- **RN-02** Un personaje solo puede equipar un arma o una armadura si su nivel es mayor o igual al nivel mínimo del objeto.
- **RN-03** Un personaje tiene como máximo un arma equipada a la vez.
- **RN-04** Un personaje tiene como máximo una armadura equipada a la vez.
- **RN-05** Un objeto protegido no puede descartarse ni perderse por el fallo de una misión.
- **RN-06** Al descartar un objeto equipado, el personaje lo desequipa antes de que el inventario lo elimine.
- **RN-07** La capacidad disponible es la capacidad máxima menos el peso total, y nunca es negativa. Solo RF-04 y RF-05 usan la capacidad disponible.
- **RN-08** El ataque total del personaje es su ataque base más el bono de ataque del arma equipada, y la defensa total es su defensa base más el bono de defensa de la armadura equipada.
- **RN-09** Cada personaje tiene exactamente un inventario y cada inventario pertenece a un solo personaje.
- **RN-10** Un inventario contiene de 0 a muchos objetos y cada objeto pertenece a un solo inventario.
- **RN-11** Solo los objetos de tipo Arma y Armadura se pueden equipar; los objetos de tipo Otro no se equipan.

## 6. Supuestos y glosario

- **Personaje**: tiene código único, nombre, nivel, ataque base, defensa base, ataque total, defensa total, arma equipada (cero o una) y armadura equipada (cero o una). El ataque total y la defensa total son datos calculados según RN-08.
- **Inventario**: tiene código único, capacidad máxima de 50 unidades de peso, peso total y capacidad disponible. Pertenece a un personaje (RN-09) y contiene objetos (RN-10). El inventario calcula el peso total y la capacidad disponible.
- **Objeto**: tiene código único, nombre, peso entero mayor o igual a 1, tipo (Arma, Armadura u Otro), marca de protegido y marca de equipado. Dos objetos pueden tener el mismo nombre, porque se distinguen por su código. Los objetos no se apilan: cada uno ocupa su propio lugar.
- **Arma**: objeto con un bono de ataque y un nivel mínimo de personaje para equiparla.
- **Armadura**: objeto con un bono de defensa y un nivel mínimo de personaje para equiparla.
- **Otro**: objeto sin bonos ni nivel mínimo, que no se puede equipar.
- **Objeto protegido**: objeto marcado por el jugador para que no se descarte ni se pierda al fallar una misión. La pérdida de objetos por fallo de misión ocurre fuera de este módulo, que solo garantiza que los objetos protegidos quedan excluidos.
- **Inventario lleno**: situación en la que la capacidad disponible es menor que el peso del objeto que se intenta agregar.
- **Peso total**: suma de los pesos de todos los objetos del inventario, equipados o no.
- **Equipado**: un arma o una armadura que el personaje tiene en uso; sigue contando en el peso total.
