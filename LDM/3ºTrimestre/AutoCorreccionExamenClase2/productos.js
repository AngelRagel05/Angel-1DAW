// Datos de ejemplo
let productos = [
    { id: 1, categoria: "bebidas", precio: 1.5, cantidad: 100 },
    { id: 2, categoria: "comida",   precio: 3.2, cantidad:  50 },
    { id: 3, categoria: "bebidas",  precio: 2.0, cantidad:  80 },
    { id: 4, categoria: "hogar",    precio: 5.0, cantidad:  20 },
    { id: 5, categoria: "comida",   precio: 1.0, cantidad: 200 }
  ];
  
  // 1. Valor total del inventario
  function calcularValorInventario(productos) {
    return productos
      .reduce((acum, { precio, cantidad }) => acum + precio * cantidad, 0);
  }
  
  // 2. Agrupar por categoría en un Map
  function grupoPorCategoria(productos) {
    let mapa = new Map();
    for (let prod of productos) {
      let { categoria } = prod;
      if (!mapa.has(categoria)) {
        mapa.set(categoria, []);
      }
      mapa.get(categoria).push(prod);
    }
    return mapa;
  }
  
  // 3. Descontar una categoría (sin mutar el original)
  function descontarCategoria(productos, categoriaBuscada, porcentaje) {
    let factor = 1 - porcentaje / 100; //por si el porcentaje cambia no se mete a lo bruto
    return productos.map(prod => {
      if (prod.categoria === categoriaBuscada) {
        // devolvemos un nuevo objeto con precio modificado
        return { ...prod, precio: +(prod.precio * factor).toFixed(2) };
      }
      return prod;
    });
  }
  
  // 4. Conjunto de categorías únicas
  function categoriasDisponibles(productos) {
    return new Set(productos.map(p => p.categoria));
  }
  
  // ——— Ejecución de ejemplo ———
  
  console.log("Valor total del inventario:", calcularValorInventario(productos));
  // 1.5*100 + 3.2*50 + 2.0*80 + 5.0*20 + 1.0*200 = 150 + 160 + 160 + 100 + 200 = 770
  
  console.log("\nProductos agrupados por categoría:");
  for (let [cat, lista] of grupoPorCategoria(productos)) {
    console.log(`- ${cat}:`, lista);
  }
  
  console.log("\nInventario con 10% de descuento en 'comida':");
  console.log(descontarCategoria(productos, "comida", 10));
  
  console.log("\nCategorías disponibles:", [...categoriasDisponibles(productos)]);
  // ["bebidas", "comida", "hogar"]