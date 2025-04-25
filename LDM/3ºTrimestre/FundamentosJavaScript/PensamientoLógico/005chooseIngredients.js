"use strict"

// Definir las recetas posibles según la cantidad de ingredientes.
const LIST_5_INGREDIENTS = "🍕 Con todos los ingredientes, puedes hacer: Pizza casera.";
const LIST_4_INGREDIENTS = "🥗 Puedes preparar: Ensalada completa y Arroz con pollo.";
const LIST_3_INGREDIENTS = "🍝 Además puedes cocinar: Huevos revueltos con jamón y Pasta con queso.";
const LIST_2_INGREDIENTS = "🥚 Y con lo más básico, puedes hacer: Tortilla francesa y Sándwich de jamón.";
const NO_RECIPES = "🛑 No puedes cocinar ninguna receta con esos ingredientes.";

// Solicitar al usuario la cantidad de ingredientes.
let ingredients = +prompt("Introduce cuántos ingredientes tienes (del 0 al 5):", 5);

// Usar un switch para manejar las distintas cantidades de ingredientes y mostrar las recetas posibles.
switch (ingredients) {
    case 5:
        // Si tiene 5 ingredientes, mostrar la receta con todos los ingredientes.
        print(LIST_5_INGREDIENTS);
        break;
    case 4:
        // Si tiene 4 ingredientes, mostrar las recetas de 4 ingredientes y luego las de 3 y 2 ingredientes.
        print(LIST_4_INGREDIENTS);
        // Procedemos a mostrar también las recetas para 3 ingredientes.
        // No hace falta un break aquí porque ya pasaremos al siguiente caso de 3.
    case 3:
        print(LIST_3_INGREDIENTS);
        // Procedemos a mostrar también las recetas para 2 ingredientes.
    case 2:
        print(LIST_2_INGREDIENTS);
        break;
    default:
        // Si el número de ingredientes no está entre 0 y 5, mostrar que no hay recetas posibles.
        print(NO_RECIPES);
        break;
}

// Función para imprimir el mensaje en consola.
function print(msg) {
    console.log(msg);
}
