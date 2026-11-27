# Diagrama de casos de uso

**Autor:** Paula Camila Hurtado Ramirez

## ¿Qué mejoró?

En el primer diagrama se el equipaje y armadura se agrupaban en un solo caso (el CU-07) ahora se pueden separar. También se dividieron correctamente en CU-06 Equipar arma (RF-07) y CU-09 Equipar armadura (RF-10). Igualmente se corrigió el actor en el aviso de inventario lleno, eliminando la asociación directa del Jugador con CU-05 y avisa cuando el inventario está lleno (RF-05).

## ¿Qué sigue mal?

Sigue faltando la relación con el aviso de inventario lleno, aunque quitaron CU-05 como aviso; no lo conectaron con CU-01 Agregar objeto al inventario.

## ¿Qué apareció de nuevo?

En la primera imagen, CU-08 decía "Comparar equipo con objeto nuevo" (cubriendo armas y armaduras según RF-08). En la segunda imagen lo cambiaron a CU-07 Comparar armas en el inventario, dejando por fuera la comparación de armaduras.

Tiene funcionalidad incompleta al proteger objetos ya que en el primer diagrama, CU-09 decía "Marcar y desmarcar objeto como protegido" (cubriendo ambos escenarios de RF-09). En el segundo lo redujeron a CU-08 Marcar objeto como protegido, omitiendo la acción de desmarcar y redundancia en los nombres.







# Diagrama de clases

&#x20;

## ¿Qué mejoró?

Las mejoras en el nuevo diagrama se vieron en relación entre Personaje e Inventario mejoro, eliminando la ambigüedad anterior, se agregó el atributo booleano -marca\_equipado en Objeto y -arma\_equipada y -armadura\_equipada en Personajes además de quitar +equipar() de la clase padre Objeto y se dejarlo únicamente en Arma y Armadura. Tambien se añadieron atributos y métodos (+calcular\_ataque\_total() y +calcular\_defensa\_total()) en Personaje para gestionar sus valores totales.

## ¿Qué sigue mal?

En el diagrama original -objetos: List no especificaba el tipo de dato, pero en el nuevo desapareció por completo como atributo de Inventario. También se perdió el método descartar que estaba en Objeto fue eliminado sin reemplazo en Inventario ni en Objeto. En Personaje -arma\_equipada y -armadura\_equipada son de tipo String en lugar de referenciar directamente objetos de tipo Arma y Armadura.

## ¿Qué apareció de nuevo?

El diagrama tiene algunas clases huérfanas como Arma y Armadura y se creó una nueva clase Otro que también está aislada y repite atributos que ya existen en Objeto (codigo, nombre y peso). Si hereda de Objeto, no necesita volver a declarar esos atributos. Tambien se agregaron -ataque\_total, -defensa\_total, -peso\_total y -capacidad\_disponible como atributos fijos, aunque ya existen métodos para calcularlos dinámicamente.



# Diagrama ER

&#x20;

## ¿Qué mejoró?

En el nuevo diagrama se reemplazó nombre por código, mejorando la normalización en Personaje y Objeto, y se corrigió personaje en Inventario garantizando identificadores únicos. Se quitaron objetos json de Inventario y se conectó directamente con la tabla Objeto.

## ¿Qué sigue mal?

En el primer diagrama se criticó el uso de asociaciones para Arma y Armadura. En esta segunda imagen se eliminaron las líneas, pero no se creó la relación de especialización (jerarquía) ni se usaron llaves foráneas (FK) compartidas con Objeto.

• Cardinalidad invertida en inventario - objeto y ninguna tabla muestra las columnas de llave foránea necesarias para materializar las relaciones (por ejemplo, inventario\_codigo en Objeto o personaje\_codigo en Inventario).

## ¿Qué apareció de nuevo?

Guardar arma\_equipada y armadura\_equipada como varchar en Personaje al mismo tiempo que existe marca\_equipado en Objeto genera duplicidad de información y riesgo de datos contradictorios.

