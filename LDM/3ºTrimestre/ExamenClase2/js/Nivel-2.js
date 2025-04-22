"use strict"

let productos = [
    { id: 1, categoria: "bebida", precio: 1.5, cantidad: 100 },
    { id: 2, categoria: "comida",   precio: 3.2, cantidad: 52 },
    { id: 3, categoria: "bebida", precio: 2.0, cantidad: 80 },
    { id: 4, categoria: "bebida", precio: 1.59, cantidad:  96 },
    { id: 5, categoria: "hogar", precio: 5.99, cantidad:  12 }
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

    productos.forEach(producto => {
        if (!map.has(producto.categoria)) {
            map.set(producto.categoria, []);
        }
        map.get(producto.categoria).push(producto);
    });

    return map;
  }