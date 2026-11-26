# Reporte de la corrida

- Fecha: 2026-11-26 16:24
- Spec: `specs/spec_final.md`
- Origen del modelo: LLM ollama / qwen2.5:7b
- Intentos al LLM: 2
- Duración de la extracción: 2213.9 s

## Revisión de la spec (sin LLM)

- Sin observaciones.

## Validación del modelo generado

Intento 1 fallido:
  - Entidad Personaje no indica req_ids (trazabilidad).
  - Entidad Inventario no indica req_ids (trazabilidad).
  - Entidad Objeto no indica req_ids (trazabilidad).
  - Entidad Arma no indica req_ids (trazabilidad).
  - Entidad Armadura no indica req_ids (trazabilidad).
  - Entidad Otro no indica req_ids (trazabilidad).

## Cobertura declarada por el modelo

- Requerimientos con elementos asociados: 19 de 24
- ⚠️ Sin cobertura: RN-01, RN-06

> Que el modelo *declare* cubrir un requerimiento no significa que lo cubra bien.
> Verifica cada fila de `trazabilidad_generada.csv` contra la spec y los diagramas.
