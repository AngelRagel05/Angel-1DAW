// 1. Objeto literal
let varitaLiteral = {
    nombre: "Varita de Sauco",
    poder: "Destrucción",
    nivel: 10
  };
  
  // 2. Función crear Pocion
  function crearPocion(nombre, efecto, cantidad) {
    return {
      nombre,
      efecto,
      cantidad
    };
  }
  let pocionCurativa = crearPocion("Poción Curativa", "Recuperas salud", 3);
  let pocionInvisibilidad = crearPocion("Poción de Invisibilidad", "Te vuelve invisible", 1);
  
  // 3. constructor clásico 
  function Artefacto(nombre, material, rareza) {
    this.nombre = nombre;
    this.material = material;
    this.rareza = rareza;
    this.describir = function() {
    return `Artefacto: ${this.nombre} (material: ${this.material}, rareza: ${this.rareza})`;
  };
}
  let artefacto1 = new Artefacto("Anillo de poder", "oro", "épico");
  let artefacto2 = new Artefacto("Colgante cristal de lágrimas", "plata", "raro");
  

  // 3. Constructor clásico + prototype
/*function Artefacto(nombre, material, rareza) {
  this.nombre = nombre;
  this.material = material;
  this.rareza = rareza;
}
Artefacto.prototype.describir = function() {
  return `Artefacto: ${this.nombre} (material: ${this.material}, rareza: ${this.rareza})`;
};
const artefacto1 = new Artefacto("Corona de Camelot", "oro", "épico");
const artefacto2 = new Artefacto("Espada del Rey Arturo", "acero", "épico");
*/
  
  // 4. Clase Reliquia
  class Reliquia {
    constructor(nombre, origen, nivelMágico) {
      this.nombre = nombre;
      this.origen = origen;
      this.nivelMágico = nivelMágico;
    }
    toString() {
      return `Reliquia ${this.nombre} de origen ${this.origen}, nivel mágico: ${this.nivelMágico}`;
    }
  }
  let reliquia1 = new Reliquia("Corona del Rey Midas", "El Mito del Rey Midas", 8);
  


  // 5. Object.create con prototipo base
  let baseMagica = {
    activar() {
      return `Activando ${this.nombre}...`;
    }
  };
  let amuleto = Object.create(baseMagica);
  amuleto.nombre = "Amuleto de Protección";
  amuleto.poder = "Escudo mágico";
  // amuleto.activar() → "Activando Amuleto de Protección..."

  // 6. Colección y análisis
  let bestiario = [
    { tipo: "literal",    obj: varitaLiteral },
    { tipo: "fábrica",    obj: pocionCurativa },
    { tipo: "fábrica",    obj: pocionInvisibilidad },
    { tipo: "constructor",obj: artefacto1 },
    { tipo: "constructor",obj: artefacto2 },
    { tipo: "Object.create", obj: amuleto },
    { tipo: "clase",      obj: reliquia1 }
  ];
  
  // Map: nombre → objeto
  let mapaPorNombre = new Map();
  for (let { obj } of bestiario) {
    mapaPorNombre.set(obj.nombre, obj);
  }
  
  // Set: niveles/rareza únicos
  let nivelesUnicos = new Set();
  for (let { tipo, obj } of bestiario) {
    // extraemos la propiedad numérica o textual de "nivel" o "rareza"
    if ("nivel" in obj) {
      nivelesUnicos.add(obj.nivel);
    }
    if ("nivelMágico" in obj) {
      nivelesUnicos.add(obj.nivelMágico);
    }
    if ("rareza" in obj) {
      nivelesUnicos.add(obj.rareza);
    }
  }
  
  // Salidas por consola
  console.log("=== Bestiario Mágico ===");
  for (let { tipo, obj } of bestiario) {
    let desc;
    // Si tiene método describir o toString, invocarlo
    if (typeof obj.describir === "function") {
      desc = obj.describir();
    } else if (typeof obj.toString === "function" && obj.toString !== Object.prototype.toString) {
      desc = obj.toString();
    } else {
      desc = JSON.stringify(obj);
    }
    console.log(`${obj.nombre} — creado por: ${tipo}`);
    console.log(`  → ${desc}`);
  }
  
  console.log(`\nNiveles/Rarezas únicos en el bestiario: ${[...nivelesUnicos].join(", ")}`);
  console.log(`Total niveles/rarezas distintos: ${nivelesUnicos.size}`);
  
//Ahora usando Map
  console.log("\nObtener objeto por nombre usando Map:");
  console.log("Mapa.get('Varita de Sauco'):", mapaPorNombre.get("Varita de Sauco"));
  