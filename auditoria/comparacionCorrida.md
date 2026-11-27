# Comparación corrida 1 (`spec_v1.md`) contra corrida 2 (`spec_final.md`)

Insumo para las consecuencias del ADR. Corrida 2: 37 minutos, 2 intentos, 19 de 24 requerimientos con elementos asociados (sin cobertura: RN-01 y RN-06).

## Estado de cada defecto

| Defecto | Corrida 2 | Estado |
|---|---|---|
| D-01 Un personaje con varios inventarios | `Personaje "1" -- "*" Inventario` en clases y `||--o{` en el ER, aunque RN-09 dice "exactamente un inventario" | **Persiste** |
| D-02 Asociaciones erróneas e inventario sin relación con objetos | Ya no hay `Objeto -- Arma` ni `objetos : List`; existe `Inventario -- Objeto : contiene`, pero con la multiplicidad invertida y se perdió la herencia (N-01, N-02) | **Mejoró parcialmente** |
| D-03 Faltan atributos | Aparecen `tipo`, `marca_equipado`, `ataque_total`, `defensa_total`, `arma_equipada`, `armadura_equipada` y la clase `Otro` | **Resuelto** |
| D-04 Operaciones mal asignadas o faltantes | `equipar` ya no está en Objeto; `marcar_protegido` y `desmarcar_protegido` están en Objeto. Siguen sin operación en las clases descartar, comparar y el aviso de lleno | **Mejoró parcialmente** |
| D-05 CU-05 como caso de uso aparte | El aviso de lleno ya no es un caso de uso independiente (RF-05 quedó dentro de RF-01) | **Resuelto** |
| D-06 Comparar se confunde con equipar | CU-07 devuelve bono nuevo, bono equipado y diferencia, sin modificar nada | **Resuelto** |
| D-07 Equipar sin validar nivel ni reemplazo | CU-06 y CU-09 siguen sin validar nivel, sin reemplazo y sin recalcular estadísticas. El mensaje huérfano de Arma desapareció | **Persiste** |
| D-08 Sin ruta de rechazo ni aviso de lleno | CU-01 solo muestra el caso de éxito | **Persiste** |
| D-09 Descartar y desmarcar incompletos | CU-05 no valida protegido ni equipado; CU-08 solo marca | **Persiste** |
| D-10 Responsabilidades mal asignadas | Ya no se envía peso total al Personaje y CU-04 responde al Jugador | **Resuelto** |
| D-11 Filtro solo por tipo | CU-03 filtra por tipo y por nombre; falta el caso "Sin resultados" | **Mejoró parcialmente** |
| D-12 ER con claves y tipos inconsistentes | Todas las claves son `codigo : varchar`, ya no hay `json`. Sin llaves foráneas, Arma, Armadura y Otro aisladas, relación Inventario–Objeto invertida | **Mejoró parcialmente** |
| D-16 CU-01 sin confirmación al jugador | CU-01 responde "Objeto agregado exitosamente" | **Resuelto** |
| D-17 Flecha de retorno sólida | Igual en todos los diagramas (plantilla del pipeline) | **Persiste, fuera de la spec** |
| D-18 Inventario vacío | CU-02 no considera el inventario vacío | **Persiste** |
| D-13 RN-07 enlazada a operaciones que no la usan | RN-07 sigue enlazada a seis casos de uso y a marcar y desmarcar protegido, aunque la spec dice que solo RF-04 y RF-05 la usan | **Persiste** |
| D-14 RF cubiertos solo por un caso de uso | Ahora enlazan entidades y métodos, pero RF-05 y RF-06 no tienen método propio | **Mejoró parcialmente** |
| D-15 Reglas sin cobertura | Pasó de 4 sin cobertura (RN-03, RN-04, RN-06, RN-08) a 2 (RN-01, RN-06); RN-03, RN-04 y RN-08 ya tienen elementos | **Mejoró parcialmente** |

Resumen de los 18 defectos: 5 resueltos, 6 mejoraron parcialmente, 7 persisten.

## Defectos nuevos de la corrida 2

### N-01 · Regresión · `02_clases.puml` y `03_er.puml`
- **Qué generó el modelo:** desapareció la herencia `Objeto <|-- Arma` y `Objeto <|-- Armadura`. Arma, Armadura y Otro son clases sueltas que repiten `codigo` (y Otro también `nombre` y `peso`), mientras que Arma y Armadura no tienen nombre ni peso.
- **Causa raíz:** `spec_final.md` define el objeto con un atributo `tipo` y a la vez describe Arma, Armadura y Otro como entidades aparte. El modelo hizo las dos cosas y no relacionó nada.
- **Corrección en la spec:** elegir una sola forma. Por ejemplo, "Arma, Armadura y Otro son especializaciones de Objeto: heredan código, nombre y peso", y quitar el atributo `tipo`.

### N-02 · Inconsistencia · `02_clases.puml` y `03_er.puml`
- **Qué dice la spec:** RN-10, "un inventario contiene de 0 a muchos objetos y cada objeto pertenece a un solo inventario".
- **Qué generó el modelo:** `Inventario "0..*" -- "1" Objeto` en clases y `Inventario }o--|| Objeto` en el ER, es decir, muchos inventarios para un solo objeto. Tampoco hay llave foránea en Objeto.
- **Causa raíz:** la regla está escrita con claridad, pero el modelo de 7B invirtió la relación. Igual que D-01, es un límite del modelo y no una ambigüedad de la spec.
- **Corrección en la spec:** ninguna segura. Se documenta como límite del modelo.

### N-03 · Omisión · `04_secuencia_CU-04.puml`
- **Qué dice la spec:** RF-04, la consulta muestra capacidad máxima, peso total y capacidad disponible.
- **Qué generó el modelo:** solo devuelve `capacidad_disponible`.
- **Causa raíz:** el diagrama resume el resultado en el dato principal.
- **Corrección en la spec:** ninguna clara; la spec ya lo dice.

### N-04 · Omisión · `04_secuencia_CU-07.puml` y `01_casos_de_uso.puml`
- **Qué dice la spec:** RF-08 compara un arma o una armadura y, si no hay equipo del mismo tipo, muestra el bono actual como 0.
- **Qué generó el modelo:** el caso de uso se llama "Comparar armas" y la secuencia no contempla armaduras ni el caso sin equipo equipado.
- **Causa raíz:** RF-08 junta dos tipos de objeto y un caso especial en una sola oración.
- **Corrección en la spec:** separar la comparación de armas y la de armaduras, y dar el caso del bono 0 como escenario aparte.

### N-05 · Trazabilidad falsa · `trazabilidad_generada.csv` de la corrida 2
- **Qué generó el modelo:** RN-09, RN-10 y RN-11 aparecen enlazadas a los nueve casos de uso y a ocho métodos cada una. Los diagramas contradicen RN-09 (un personaje con varios inventarios) y RN-10 (relación invertida). Además, RN-01 (capacidad máxima de peso) pasó a "sin cobertura" y en la corrida 1 declaraba cobertura.
- **Causa raíz:** las tres reglas nuevas son transversales y el modelo las reparte entre todos los elementos. RN-01 quedó sin enlazar al reescribirse la spec con escenarios separados.
- **Corrección en la spec:** ninguna segura; es un límite del modelo que se documenta.

## Qué se puede concluir para el ADR

- **Lo que se arregló con la spec:** atributos de cada entidad (D-03), responsabilidades (D-10), el aviso de lleno como parte de RF-01 (D-05), que comparar no modifique (D-06) y la confirmación al jugador (D-16). Son defectos cuya causa era una frase ausente o ambigua.
- **Lo que la spec no pudo arreglar:** D-01 y N-02. Las reglas RN-09 y RN-10 están escritas sin ambigüedad y el modelo las ignoró. Es evidencia de un límite de `qwen2.5:7b`.
- **La trazabilidad mejoró en cantidad (de 13 de 20 a 19 de 24) pero no en calidad:** RN-03, RN-04 y RN-08 ya tienen elementos, pero RN-07, RN-09, RN-10 y RN-11 se enlazan con elementos que no corresponden y RN-01 quedó sin cobertura.
- **Lo que quedó pendiente:** los escenarios de error (nivel insuficiente, rechazo por peso, objeto protegido, inventario vacío, "Sin resultados"). El modelo dibuja solo el caso de éxito aunque la spec ahora pide cada escenario.
- **Lo que empeoró:** la herencia (N-01), por una definición doble en la spec.
