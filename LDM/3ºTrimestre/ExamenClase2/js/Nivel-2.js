"use strict"

let productos = [
    { id: 1, categoria: "bebida", precio: 1.5, cantidad: 100 },
    { id: 2, categoria: "comida", precio: 3.2, cantidad: 52 },
    { id: 3, categoria: "bebida", precio: 2.0, cantidad: 80 },
    { id: 4, categoria: "bebida", precio: 1.59, cantidad: 96 },
    { id: 5, categoria: "hogar", precio: 5.99, cantidad: 12 }
];

function calcularValorInventario(productos) {
    // Declaro variable
    let valorTotal = 0;

    // Recorro el array sumando los precios
    productos.forEach(producto => {
        valorTotal = valorTotal + (producto.precio * producto.cantidad);
    });

    // retorno el valorTotal
    return valorTotal;
}

function grupoPorCategoria(productos) {
    // Declaro el Map
    let map = new Map();

    // Recorro productos 
    productos.forEach(producto => {
        // Si el map no tiene la categoria meto la array vacia
        if (!map.has(producto.categoria)) {
            map.set(producto.categoria, []);
        }
        // accedo a la array y añado el producto
        map.get(producto.categoria).push(producto);
    });

    return map;
}

function descontarCategoria(productos, categoria, porcentaje) {
    // Declaro la array
    let arrayDescuento = [];

    // Recorro productos
    productos.forEach(producto => {
        // si el producto tiene la misma categoria que la dada
        if (producto.categoria === categoria) {

            // Copio el objeto
            let productoDescontado = { ...producto };

            // calculo el nuevo precio
            productoDescontado.precio = parseFloat(producto.precio * (1 - porcentaje / 100));

            // Añado el precio actualizado
            arrayDescuento.push(productoDescontado);
        }
    });

    // retorno el array
    return arrayDescuento;
}

function categoriasDisponibles(productos) {
    // Declaro el Set
    let setCategoria = new Set();

    // Voy añadiendo la cateogria en el set
    productos.forEach(producto => {
        setCategoria.add(producto.categoria);
    });

    // Retorno el set
    return setCategoria;
}

// Creo la varita
let varitaLiteral = {
    nombre: "Bartolomeo",
    poder: "Fuego",
    nivel: 6
};

// creo al función 
function crearPocion (nombre, efecto, cantidad) {
    return {
        nombre: nombre,
        efecto: efecto,
        cantidad: cantidad
    };
}

let pocion1 = crearPocion("Curación", "Recupera vida", 3);
let pocion2 = crearPocion("Invisibilidad", "Te oculta", 1);

// Creo la funcion para crear el objeto
function Artefacto (nombre, material, rareza) {
    this.nombre = nombre;
    this.material = material;
    this.rareza = rareza;

    this.descripcion = function() {
        let frase = `Artefacto: ${this.nombre} (material: ${this.material}, rareza: ${this.rareza})`;
        return frase;
    }
}

// Creo los objetos
let artefacto1 = new Artefacto("Orbe de Luz", "Cristal", "raro");
let artefacto2 = new Artefacto("Daga Sombría", "Acero negro", "épico");

// Creo la clase Reliquia
class Reliquia {
    constructor (nombre, origen, nivelMagico) {
        this.nombre = nombre;
        this.origen = origen;
        this.nivelMagico = nivelMagico;
    }

    toString() {
        let frase = `Reliquia ${this.nombre} de origen ${this.origen}, nivel mágico: ${this.nivelMagico}`;
        return frase;
    }
}

// Creo una reliquia
let reliquia1 = new Reliquia("Corona de los antiguos", "Atlántida", 7);

// Creo la baseMagica
let baseMagica = {
    activar() {
        return `Activando ${this.nombre}...`
    }
}

// Creo un amuleto
let amuleto = Object.create(baseMagica);

// añado el nombre y el poder
amuleto.nombre = "Amuleto del Alba";
amuleto.poder = "Luz Sagrada";

// Creo la array y añado los objetos
let bestiario = [
    varitaLiteral,
    pocion1,
    pocion2,
    artefacto1,
    artefacto2,
    reliquia1,
    amuleto
]

// Creo el mapa
let mapaObjetos = new Map();

bestiario.forEach(obj => {
    if (obj.nombre) {
        mapaObjetos.set(obj.nombre, obj);
    }
});

let niveles = new Set();

bestiario.forEach(obj => {
    if (obj.nivel !== undefined) niveles.add(obj.nivel);
    if (obj.nivelMagico !== undefined) niveles.add(obj.nivelMagico);
    if (obj.rareza !== undefined) niveles.add(obj.rareza);
});

// 5. Mostrar en consola con que he ido creando / instanciando los objetos
console.log("📜 Bestiario mágico:");
bestiario.forEach(obj => {
  let tipo = "desconocido";
  if (obj === varitaLiteral) tipo = "objeto literal";
  else if (obj === pocion1 || obj === pocion2) tipo = "función fábrica";
  else if (obj instanceof Artefacto) tipo = "constructor clásico";
  else if (obj instanceof Reliquia) tipo = "clase";
  else if (obj === amuleto) tipo = "Object.create";

  console.log(`- ${obj.nombre} → creado con: ${tipo}`);
});