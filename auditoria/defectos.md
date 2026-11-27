# Defectos encontrados en la corrida 1 (spec_v1.md)

Borrador para verificar. Cada defecto se contrasta contra `specs/spec_v1.md` y contra los archivos de `salida/diagramas/`. Tipos: omisión, invención, mala interpretación, inconsistencia, trazabilidad falsa.

## Verificación del equipo

Los compañeros revisaron los diagramas de la corrida 1 contra `spec_v1.md`. Esta tabla muestra qué defectos confirmó cada revisión y cuáles aportó el equipo.

| Defecto | Confirmado por |
|---|---|
| D-01 (un personaje con varios inventarios) | Paula |
| D-02 (lista de objetos sin tipo, sin relación con Inventario) | Paula |
| D-03 (no hay forma de identificar los equipados) | Paula |
| D-04 (`equipar` en Objeto aunque los de tipo Otro no se equipan) | Paula |
| D-05 (CU-05 sin relación con CU-01) | Paula |
| D-06 (comparar se ve como equipar) | Paula, Santiago |
| D-07 (RF-07 sin el caso de nivel insuficiente) | Paula, Santiago |
| D-08 (CU-01 sin ruta de rechazo) | Paula, revisión de RF-01 a RF-03 |
| D-11 (CU-03 solo filtra por tipo) | Revisión de RF-01 a RF-03 |
| D-12 (ER: objetos como registros, Arma y Armadura, clave de Objeto) | Paula |
| D-16, D-17, D-18 | Revisión de RF-01 a RF-03 |

### Observaciones del equipo que se descartaron o se matizan
- **"CU-01: el jugador no cumple con `nivel_minimo=2`"**: se descarta. El nivel mínimo se valida al equipar (RF-07, RN-02), no al agregar un objeto (RF-01).
- **"El diagrama de casos de uso debería representar solo agregar objetos"**: se descarta. Ese diagrama debe cubrir todos los RF del módulo, y los nueve casos de uso generados son correctos.
- **"RF-09 no necesita cambios"**: se matiza. El título de CU-09 dice "Marcar y desmarcar", pero el diagrama solo tiene un mensaje (marcar) y el reporte del pipeline advierte que tiene menos de 2 mensajes (D-09).

## D-01 · Mala interpretación · `02_clases.puml`
- **Qué dice la spec:** glosario, "Cada personaje tiene un único inventario".
- **Qué generó el modelo:** `Personaje "1" -- "*" Inventario` (un personaje con muchos inventarios).
- **Causa raíz:** la unicidad del inventario está escondida en una frase del glosario y no en una regla de negocio.
- **Corrección en la spec:** agregar la regla "Cada personaje tiene exactamente un inventario y cada inventario pertenece a un solo personaje".

## D-02 · Inconsistencia · `02_clases.puml`
- **Qué dice la spec:** glosario, el inventario es un "conjunto de objetos"; Arma y Armadura son tipos de objeto.
- **Qué generó el modelo:** además de la herencia `Objeto <|-- Arma`, dibujó `Objeto "0..*" -- "1" Arma` y lo mismo con Armadura (contradice la herencia). No hay asociación entre Inventario y Objeto: usó `objetos : List` y `personaje : int` como atributos.
- **Causa raíz:** la spec nunca dice cómo se relacionan Inventario y Objeto (multiplicidad, pertenencia).
- **Corrección en la spec:** agregar "Un inventario contiene de 0 a muchos objetos y cada objeto pertenece a un solo inventario".

## D-03 · Omisión · `02_clases.puml`
- **Qué dice la spec:** RF-02 (tipo, equipado, protegido), RN-08 (ataque y defensa totales), glosario (tipo Otro, peso total, arma y armadura equipadas).
- **Qué generó el modelo:** no hay atributo `equipado` ni `tipo`, no existe el tipo Otro, no hay `peso_total`, `ataque_total`, `defensa_total` ni arma y armadura equipadas en Personaje. Los diagramas de secuencia sí usan `equipado=True`, ataque total y peso total.
- **Causa raíz:** el glosario define Personaje solo con valores base y describe "equipado" y "peso total" como conceptos sueltos, sin decir de qué entidad son atributos.
- **Corrección en la spec:** listar en el glosario los atributos de cada entidad, incluidos los derivados y el tipo Otro.

## D-04 · Omisión y mala asignación de responsabilidad · `02_clases.puml`
- **Qué dice la spec:** RF-05, RF-06, RF-08, RF-09 (avisar, descartar, comparar, proteger).
- **Qué generó el modelo:** Inventario solo tiene agregar, listar, filtrar y consultar capacidad. `descartar()` quedó en Objeto, no hay operaciones de comparar ni de proteger, y `equipar()` aparece repetida en Objeto, Arma y Armadura además de Personaje.
- **Causa raíz:** los RF dicen "El jugador puede..." sin indicar sobre qué entidad se ejecuta cada operación.
- **Corrección en la spec:** redactar los criterios de aceptación diciendo qué entidad actúa (por ejemplo, "el inventario descarta...", "el personaje equipa...").

## D-05 · Mala interpretación · `01_casos_de_uso.puml`
- **Qué dice la spec:** RF-05, "El sistema avisa al jugador cuando el inventario está lleno al intentar agregar un objeto".
- **Qué generó el modelo:** CU-05 como un caso de uso que el Jugador inicia por su cuenta, sin relación con CU-01.
- **Causa raíz:** RF-05 está escrito como una función independiente, pero en realidad es una consecuencia de RF-01.
- **Corrección en la spec:** reescribir RF-05 como parte del flujo alterno de RF-01 (extensión de agregar objeto).

## D-06 · Mala interpretación · `04_secuencia_CU-08.puml`
- **Qué dice la spec:** RF-08, la comparación muestra el bono nuevo, el bono actual y la diferencia.
- **Qué generó el modelo:** un mensaje "Defensa total actualizado a 7", es decir, la comparación modifica las estadísticas. No muestra bono actual ni diferencia.
- **Causa raíz:** la spec no dice que comparar no cambia nada, y el modelo lo confundió con equipar.
- **Corrección en la spec:** agregar "La comparación no modifica el inventario ni las estadísticas del personaje".

## D-07 · Omisión y flujo roto · `04_secuencia_CU-07.puml`
- **Qué dice la spec:** RF-07, RN-02, RN-03, RN-04 (nivel mínimo, un arma, una armadura, reemplazo).
- **Qué generó el modelo:** solo el caso feliz de un arma; ningún mensaje valida el nivel ni reemplaza el equipo anterior. Además, `Arma -> Personaje` aparece sin que nadie le haya enviado un mensaje a Arma. No hay variante de armadura.
- **Causa raíz:** el criterio de aceptación de RF-07 mezcla en una sola oración tres escenarios (éxito, reemplazo y fallo por nivel) y dos tipos de objeto.
- **Corrección en la spec:** separar RF-07 en equipar arma y equipar armadura, y escribir un criterio por escenario.

## D-08 · Omisión · `04_secuencia_CU-05.puml` y `CU-01`
- **Qué dice la spec:** RF-05 y RNF-03, el mensaje de error cita RN-01 (RF-05 además pide indicar cuánto peso liberar).
- **Qué generó el modelo:** el aviso no cita RN-01. CU-01 solo muestra agregar con éxito, sin la ruta de rechazo.
- **Causa raíz:** el requisito de citar la regla está repartido entre RF-05 y RNF-03, y el diagrama se queda solo con el texto del mensaje.
- **Corrección en la spec:** poner la cita de la regla dentro del criterio de aceptación de RF-01 y RF-05.

## D-09 · Omisión · `04_secuencia_CU-06.puml` y `CU-09`
- **Qué dice la spec:** RF-06 (no descartar si está protegido, RN-05; descartar equipado, RN-06) y RF-09 (marcar y desmarcar).
- **Qué generó el modelo:** CU-06 no verifica la protección ni desequipa; CU-09 solo marca, nunca desmarca ni muestra respuesta.
- **Causa raíz:** cada criterio junta dos ramas en una sola oración con punto y coma, y el modelo dibujó solo la primera.
- **Corrección en la spec:** un criterio por rama, con el resultado esperado de cada una.

## D-10 · Mala asignación de responsabilidad · `04_secuencia_CU-01`, `CU-04`, `CU-06`
- **Qué dice la spec:** glosario, "Peso total: suma de los pesos de todos los objetos del inventario"; RF-04, la consulta muestra capacidad máxima, peso total y disponible.
- **Qué generó el modelo:** el Inventario le envía "peso total" y "capacidad disponible" al Personaje. En CU-04 la respuesta nunca llega al Jugador.
- **Causa raíz:** la spec no dice quién calcula y quién responde cada dato.
- **Corrección en la spec:** "El inventario calcula el peso total y la capacidad disponible y se los muestra al jugador".

## D-11 · Omisión · `04_secuencia_CU-03.puml`
- **Qué dice la spec:** RF-03, filtrar por tipo, por texto, o por ambos, y mostrar "Sin resultados" si nada coincide.
- **Qué generó el modelo:** solo filtra por tipo y siempre devuelve un resultado.
- **Causa raíz:** RF-03 empaqueta tres modos de filtrado y una excepción en una sola oración.
- **Corrección en la spec:** un criterio por modo de filtrado y otro para "Sin resultados".

## D-12 · Invención e inconsistencia · `03_er.puml` y `02_clases.puml`
- **Qué dice la spec:** glosario, los objetos "no se apilan: cada uno ocupa su propio lugar"; no se define ningún identificador.
- **Qué generó el modelo:** `nombre` como clave primaria de Personaje y de Objeto (dos objetos llamados "Espada" chocarían). `Inventario.personaje : int` es clave primaria, pero Personaje se identifica por `nombre : varchar`. `objetos : json` en vez de una relación. Arma y Armadura sin clave ni llave foránea, y `Objeto }o--|| Arma` apunta al revés.
- **Causa raíz:** la spec no define identificadores y el modelo inventó los suyos.
- **Corrección en la spec:** agregar "Cada personaje y cada objeto tiene un identificador único" y la relación entre inventario y objetos (ver D-02).

## D-13 · Trazabilidad falsa · `trazabilidad_generada.csv`, fila RN-07
- **Qué dice la spec:** RN-07, la capacidad disponible es la capacidad máxima menos el peso total. Solo RF-04 la muestra; RF-02 y RF-03 no la mencionan.
- **Qué generó el modelo:** vinculó RN-07 con `Inventario.listar_objetos` y `Inventario.filtrar_objetos`, además de `consultar_capacidad_disponible`.
- **Causa raíz:** en la spec "capacidad disponible" aparece en RF-04, RF-05 y RN-07, pero ninguna frase dice qué operaciones la calculan.
- **Corrección en la spec:** indicar que solo RF-04 y RF-05 usan la capacidad disponible.

## D-14 · Trazabilidad débil · `trazabilidad_generada.csv`, filas RF-01 a RF-09
- **Qué dice la spec:** cada RF tiene criterio de aceptación con comportamiento verificable.
- **Qué generó el modelo:** cada RF figura como "cubierto" solo por el actor Jugador y un caso de uso. Ninguna clase ni método aparece vinculado, aunque RF-05, RF-06, RF-08 y RF-09 no tienen operación en el diagrama de clases (D-04).
- **Causa raíz:** los RF no nombran la entidad que ejecuta la operación, así que el modelo solo pudo enlazarlos con el caso de uso.
- **Corrección en la spec:** la misma de D-04 (indicar qué entidad actúa en cada criterio).

## D-15 · Omisión · `reporte.md`
- **Qué dice el reporte:** 13 de 20 requerimientos con elementos asociados; sin cobertura RN-03, RN-04, RN-06 y RN-08.
- **Qué generó el modelo:** ningún diagrama ni clase refleja el límite de un arma, el límite de una armadura, el desequipado al descartar ni el cálculo de ataque y defensa totales.
- **Causa raíz:** son reglas de cálculo y de estado que dependen de atributos que la spec no define para Personaje (D-03).
- **Corrección en la spec:** definir en el glosario `arma_equipada`, `armadura_equipada`, `ataque_total` y `defensa_total` de Personaje.

## D-16 · Omisión · `04_secuencia_CU-01.puml`
- **Qué dice la spec:** RF-01 (en `spec_final`, el inventario confirma al jugador que el objeto se agregó).
- **Qué generó el modelo:** el flujo termina con un mensaje del Inventario al Personaje y nunca responde al Jugador.
- **Causa raíz:** el criterio de `spec_v1.md` solo dice qué cambia en el inventario y no qué ve el jugador.
- **Corrección en la spec:** en `spec_final.md`, RF-01 escenario 1 incluye la confirmación al jugador.

## D-17 · Inconsistencia con UML · `04_secuencia_CU-02.puml`
- **Qué dice la spec:** nada; es un asunto de notación.
- **Qué generó el modelo:** la respuesta del Inventario al Jugador usa flecha continua (`->`), cuando en UML un mensaje de retorno va con flecha punteada (`-->`).
- **Causa raíz:** la plantilla del pipeline, que está congelada. No depende de la spec.
- **Corrección en la spec:** ninguna. Se documenta en el ADR como límite del pipeline.

## D-18 · Omisión en la spec · RF-02
- **Qué dice la spec:** RF-02 solo describe el caso con objetos en el inventario.
- **Qué generó el modelo:** CU-02 solo muestra un objeto y no considera el inventario vacío.
- **Causa raíz:** la spec no define qué pasa si el inventario no tiene objetos.
- **Corrección en la spec:** en `spec_final.md`, RF-02 muestra el mensaje "Inventario vacío".
