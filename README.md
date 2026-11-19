# 🛒 CRUD DummyJSON — Práctica de consumo de API REST

Aplicación Android desarrollada con **Jetpack Compose** que consume la API pública de [DummyJSON](https://dummyjson.com/docs/products) para gestionar un catálogo de productos. El usuario puede listar, consultar, crear, editar y eliminar productos. El objetivo de la práctica es aplicar una arquitectura por capas (**data → domain → ui**) con inyección de dependencias, consumo de API REST y navegación entre pantallas.

## Funcionalidades

- Pantalla de inicio con acceso al catálogo.
- Lista de productos con imagen, categoría, precio y botón para ver el detalle.
- Detalle del producto recibido como parámetro (`id`) desde la lista.
- Creación de productos mediante formulario.
- Edición de productos con el formulario precargado.
- Eliminación de productos con diálogo de confirmación.
- Mensajes de éxito y error después de cada operación.

## Flujo de navegación

```
Inicio → Lista de Productos → Detalle del Producto → Editar Producto
                │                      ↓ (Eliminar)
                │               Lista de Productos
                ↓
          Nuevo Producto → Lista de Productos
```

## Parámetros que viajan entre pantallas

| Parámetro | Descripción |
|---|---|
| `id` | Identificador del producto seleccionado (Detalle y Editar) |

## Endpoints consumidos

| Operación | Método | Endpoint |
|---|---|---|
| Listar productos | `GET` | `/products` |
| Obtener producto | `GET` | `/products/{id}` |
| Crear producto | `POST` | `/products/add` |
| Actualizar producto | `PUT` | `/products/{id}` |
| Eliminar producto | `DELETE` | `/products/{id}` |

> **Nota:** DummyJSON es una API de prueba. Las operaciones de crear, editar y eliminar responden correctamente, pero **no se guardan en el servidor**. Los cambios se mantienen en pantalla mientras la app está abierta gracias a un `ViewModel` compartido entre todas las pantallas.

## Tecnologías

- Kotlin
- Jetpack Compose + Material 3
- Navigation Compose con rutas type-safe (`@Serializable`)
- Retrofit + Moshi para el consumo de la API
- Hilt para la inyección de dependencias
- Coroutines + StateFlow para el manejo de estado
- Coil para la carga de imágenes

## Arquitectura

El proyecto está organizado en capas siguiendo **Clean Architecture** y respeta la jerarquía **NavHost → Screen → Section → Composable** en la interfaz:

```
com.myapplication.crud_dummyjson
├── data
│   ├── mapper        → conversión de DTO a modelo de dominio
│   ├── remote
│   │   ├── api       → interfaz de Retrofit (ProductService)
│   │   └── dto       → modelos de la respuesta de la API
│   └── repository    → implementación del repositorio
├── di                → módulos de Hilt (red y repositorio)
├── domain
│   ├── model         → modelo ProductModel
│   ├── repository    → contrato del repositorio
│   └── useCase       → casos de uso (listar, crear, editar, eliminar)
├── navigation        → rutas y NavHost
└── ui
    ├── screen        → pantallas (solo llaman secciones)
    ├── section       → bloques de cada pantalla
    ├── composable    → componentes reutilizables
    ├── state         → estado de la UI (ProductUIState)
    ├── viewModel     → ProductViewModel
    └── theme         → colores y tema
```

### Flujo de datos

```
Screen → ViewModel → UseCase → Repository → ProductService (Retrofit) → DummyJSON
```

## Flujo de trabajo (Gitflow)

- `main` → versiones estables
- `develop` → integración
- `feat/*` → nuevas funcionalidades

### Ramas del proyecto

- `feat/network-layer` → capa de red, DTOs e inyección con Hilt
- `feat/repository-layer` → repositorio, casos de uso y ViewModel
- `feat/frontend-crud-productos` → pantallas, navegación y CRUD completo

## Versiones

- **v1.0.0** — CRUD completo de productos con DummyJSON: inicio, lista, detalle, creación, edición y eliminación.

## Requisitos

- Android Studio (versión reciente)
- SDK mínimo: Android 11 (API 30)
- Conexión a internet

## Ejecución

1. Clonar el repositorio.
2. Abrir el proyecto en Android Studio.
3. Sincronizar Gradle y ejecutar en un emulador o dispositivo.
