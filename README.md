# Práctica 3 – Exposición de una API de DiscoService 

## Descripción

Como parte del desarrollo del **Sistema mixup2**, en esta práctica se requiere exponer la funcionalidad para **dar de alta un disco** a través de un **servicio REST**, 
el cual será consumido desde un Front - End.  

El servicio debe ser **interoperable**, permitiendo que clientes externos puedan interactuar con él de forma estándar.

## Referencia a la Práctica 2

La implementación de esta funcionalidad se basa en la clase **`DiscoServiceImpl`** desarrollada en la **Práctica No. 2 (rama `practica2`)**.  

En esta práctica se extiende dicha clase para crear un **recurso REST** que exponga el alta de discos.

## Objetivo

- Crear un endpoint REST para dar de alta un disco.  
- Mantener interoperabilidad con clientes externos.  
- Reutilizar la lógica de negocio ya implementada en `DiscoServiceImpl`.
