# Nivel 2 🍭

### Ejercicio 1 - Inventario de Productos 

Tienes un array de objetos productos, por ejemplo:
```javascript
"use strict"

let productos = [
  { id: 1, categoria: "bebida", precio: 1.5, cantidad: 100 },
  { id: 2, categoria: "comida",   precio: 3.2, cantidad: 52 },
  { id: 3, categoria: "bebida", precio: 2.0, cantidad: 80 },
  { id: 4, categoria: "bebida", precio: 1.59, cantidad:  96 },
  { id: 5, categoria: "hogar", precio: 5.99, cantidad:  12 }
];
```
Crea:
a) Devuelve el valor total del inventario sumando precio × cantidad de cada producto.
calcularValorInventario(productos)

```javascript
"use strict"

function calcularValorInventario(productos) {
  // Declaro variable
  let valorTotal = 0;
  
  // Recorro el array sumando los precios
  for (let i = 0; i < productos.lenght; i++) {
    valortotal = valorTotal + productos[i].precio;
  }

  // retorno el valorTotal
  return valorTotal;
}
```

b) Devuelve un Map donde la clave es la categoría y el valor es un array de objetos de esa categoría.
grupoPorCategoria(productos)

```javascript
"use strict"

  function grupoPorCategoria(productos) {
    // Declaro el Map
    let map = new Map();
    map = {productos.categoria, }
  }
```

c) Aplica un descuento (por ejemplo, 10 %) sobre el precio de todos los productos de la categoría dada, y devuelve un nuevo array con los precios actualizados (sin mutar el original).

descontarCategoria(productos, categoria, porcentaje)


```javascript
"use strict"

function descontarCategoria(productos, categoria, porcentaje) {
  // Declaro la array
  let arrayDescuento = new Array();

  for (let i = 0; i < productos.length; i++) {

    // Calculo el precio
    let descuento = productos[i].precio * (100 - porcentaje);

    // lo añado a la array
    arrayDescuento.unshift(descuento);
  }

  // retorno el array
  return arrayDescuento;
}

```

d) Devuelve un Set con todas las categorías únicas presentes.
categoriasDisponibles(productos)

```javascript
"use strict"

function categoriasDisponibles(productos) {
  // lo tengo que meter en una forEach pero no se declarar un forEach
  // y dentro tengo que ir jugando añadiendo al set y despues mostrarlo.
  // problema, no se hacer un forEach aqui.

  // No sé si funciona pero mi logica si lo cree.

  // Declaro el Set
  let setCategoria = new Set();

  // Voy añadiendo la cateogria en el set
  for (let i = 0; i < productos.length; i++) {
    setCategoria.add(productos[i].categoria);
  }

  // Retorno el set
  return setCategoria;
}
```

### Ejercicio 2 -  “Bestiario Mágico”
Descripción
Vas a crear distintos “objetos mágicos” (por ejemplo, varitas, pociones y artefactos) empleando varias formas de instanciación en JavaScript. Al final, agruparás todos en un array y usarás métodos de Map y Set para extraer información.

a) Objeto literal

Declara una variable varitaLiteral que represente una varita.

Debe tener propiedades: nombre (string), poder (string), nivel (número).

```javascript
"use strict"

// Creo el objeto
let varitaLiteral = new {nombre: "Bartolomeo", poder: "Fuego", nivel: 2};

```

b) Función fábrica

Crea una función crearPocion(nombre, efecto, cantidad) que devuelva un objeto con esas tres propiedades.

Usa la función para generar al menos dos pociones distintas.

```javascript
"use strict"

// Creo la funcion para ir creando los objetos
function crearPocion(nombre, efecto, cantidad) {
  let pocion = new {nombre: nombre, efecto: efecto, cantidad: cantidad};
  return pocion;
}

```

c) Constructor clásico

Define un constructor function Artefacto(nombre, material, rareza) que inicialice esas propiedades.

Añádele un método llamado describir() que devuelva un string tipo:

"Artefacto: [nombre] (material: [material], rareza: [rareza])".

Instancia dos artefactos usando new Artefacto(...).

```javascript
"use strict"

constructor Artefacto(nombre, material, rareza) {
  this.nombre = nombre;
  this.material = material;
  this.rareza = rareza;
}

function describir() {
  let frase = `Artefacto: ${nombre} (material: ${material}, rareza ${rareza})`;
  return frase;
}
```


d) Clase Reliquia

Define una clase Reliquia con constructor (nombre, origen, nivelMágico) y un método toString() que devuelva:

"Reliquia [nombre] de origen [origen], nivel mágico: [nivelMágico]".

Crea al menos una instancia de Reliquia.

```javascript
"use strict"

class Reliquia {

  // Creo constructor
  constructor Reliquia (nombre, origen, nivelMagico) {
    this.nombre = nombre;
    this.origen = origen;
    this.nivelMagico = nivelMagico;
  }

  // Creo toString
  function toString() {
    let frase = `Reliquia ${nombre} de origen ${origen}, nivel mágico: ${nivelMagico}`;
    return frase;
  }
}
```

### PARA CASA, junto con todo hecho decentemente, si te da tiempo en examen hazlo después de entregar y avisar a tu profesora:

e) Crea un prototipo base let baseMagica = { activar() { return \Activando ${this.nombre}...; } }.

Usa Object.create(baseMagica) para generar un objeto amuleto al que le asignes luego con “dot notation” las propiedades nombre y poder.

Llama a amuleto.activar() y comprueba que funciona.

```javascript

```

f) Colección y análisis
Junta todos los objetos anteriores en un array  bestiario = […].

Usa un Map para construir un mapeo de nombre → objeto (clave: nombre de cada objeto).

Usa un Set para obtener la lista de todos los “niveles” o “rareza” (la propiedad numérica o de texto que indique fuerza/rango) únicos de tu bestiario.

Finalmente, muestra por consola:

Nombre de cada objeto y su tipo de creación (literal, fábrica, constructor, …).

El tamaño del Set (cuántos niveles/rareza distintos hay).

```javascript

```