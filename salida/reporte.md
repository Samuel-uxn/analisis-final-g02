# Reporte de la corrida

- Fecha: 2026-11-22 11:34
- Spec: `specs/spec_v1.md`
- Origen del modelo: LLM ollama / qwen2.5:7b
- Intentos al LLM: 2
- Duración de la extracción: 1803.2 s

## Revisión de la spec (sin LLM)

- Sin observaciones.

## Validación del modelo generado

Intento 1 fallido:
  - Entidad Personaje no indica req_ids (trazabilidad).
  - Entidad Objeto no indica req_ids (trazabilidad).
  - Entidad Arma no indica req_ids (trazabilidad).
  - Entidad Armadura no indica req_ids (trazabilidad).
  - Entidad Inventario no indica req_ids (trazabilidad).
- ⚠️ La secuencia de CU-09 tiene menos de 2 mensajes.

## Cobertura declarada por el modelo

- Requerimientos con elementos asociados: 13 de 20
- ⚠️ Sin cobertura: RN-03, RN-04, RN-06, RN-08

> Que el modelo *declare* cubrir un requerimiento no significa que lo cubra bien.
> Verifica cada fila de `trazabilidad_generada.csv` contra la spec y los diagramas.
