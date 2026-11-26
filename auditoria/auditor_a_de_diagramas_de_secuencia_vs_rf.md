# Auditoría de Diagramas de Secuencia (`spec2code`) vs. Requerimientos Funcionales

Este documento presenta el análisis comparativo entre la primera versión propuesta de los diagramas de secuencia (`CU-01`, `CU-02`, `CU-03`) y su segunda iteración, evaluados frente a los Requerimientos Funcionales (`RF-01`, `RF-02`, `RF-03`).

---

## Resumen de Requerimientos Evaluados

* **RF-01 (Historia RMIYE-11):** El jugador puede agregar al inventario un objeto que recogió en la aventura.
* **RF-02 (Historia RMIYE-2):** El jugador puede listar los objetos de su inventario.
* **RF-03 (Historia RMIYE-6):** El jugador puede filtrar los objetos de su inventario por tipo, por texto en el nombre o por ambos criterios a la vez.

---

## 1. Qué mejoró

* **Generalización del modelo de datos:** Se eliminaron los valores quemados (*hardcoded*) de ejemplo (como `'Espada'`, `Arma`, `peso=5`) y se reemplazaron por estructuras genéricas (`{nombre, peso, tipo}`, `[{nombre, tipo, peso, equipado, protegido}]`), logrando un diseño más limpio y alineado con la arquitectura.
* **Cierre del flujo en `CU-01` (`RF-01`):** Ahora el `Inventario` sí responde al `Jugador` confirmando la operación (`Objeto agregado exitosamente`), cerrando el ciclo de interacción que anteriormente quedaba inconcluso.
* **Cobertura de parámetros en `CU-03` (`RF-03`):** La llamada dejó de estar limitada únicamente al filtro por `tipo` y ahora contempla ambos parámetros requeridos (`{tipo, nombre}`).
* **Representación de colecciones en `CU-02` y `CU-03`:** Las respuestas pasaron de devolver un único objeto aislado a retornar explícitamente colecciones (`Lista de objetos: [...]` y `Lista filtrada de objetos: [...]`).

---

## 2. Qué sigue mal

* **Ambigüedad en las combinaciones de filtro del `CU-03` (`RF-03`):** El requerimiento exige explícitamente filtrar *"por tipo, por texto en el nombre o por ambos criterios a la vez"*. El diagrama nuevo agrupa `{tipo, nombre}` en un único mensaje genérico sin modelar (mediante bloques `alt` o parámetros opcionales) que ambos filtros funcionan de manera independiente además de combinada.
* **Omisión del contexto de origen en `CU-01` (`RF-01`):** El `RF-01` especifica que el objeto fue *"recogido en la aventura"*; el diagrama sigue tratando la acción como una inserción directa sin reflejar esa precondición o origen.
* **Ausencia de flujos alternativos / excepciones:** Ninguno de los tres diagramas contempla casos borde básicos esperables en estos casos de uso (por ejemplo: qué ocurre en `CU-02` o `CU-03` si el inventario está vacío o no hay coincidencias, o en `CU-01` si existen restricciones de capacidad/peso).
* **Notación UML de retorno:** En los tres diagramas se mantienen flechas síncronas continuas (`->`) para las respuestas del `Inventario` hacia el `Jugador`, cuando en PlantUML/UML estándar las respuestas deben representarse con flecha punteada (`-->`).

---

## 3. Qué apareció nuevo

* **Eliminación del participante `Personaje` en `CU-01`:** En la primera versión existía el participante `Personaje` y una actualización de peso total (`Peso total actualizado a 10`). En esta iteración ese participante desapareció, dejando la interacción estrictamente entre `Jugador` e `Inventario` (lo cual lo alinea mejor con el texto literal del `RF-01`, que no menciona al personaje ni el cálculo de peso).
* **Eliminación del atributo `nivel_minimo` en `CU-01`:** El campo `nivel_minimo=2` que aparecía en el primer diagrama fue removido, quedando únicamente `{nombre, peso, tipo}` al agregar el objeto.
* **Consistencia estructural de los objetos devueltos:** Se introduce un esquema unificado de propiedades (`nombre`, `tipo`, `peso`, `equipado`, `protegido`) tanto en la salida de listar (`CU-02`) como en la de filtrar (`CU-03`).