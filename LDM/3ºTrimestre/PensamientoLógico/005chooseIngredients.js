"use strict"

// Crear un programa que pregunte por separado si tiene 5 ingredientes. Según los ingredientes que tenga, mostrar 
// un mensaje con todas las comidas que puede cocinar. Debe haber opciones para 5, 4, 3 y 2 ingredientes. Para cada 
// cantidad, debe haber al menos 2 comidas/recetas posibles (excepto para la de 5). Se deben mostrar todas las 
// posibles, incluyendo las que requieran menos ingredientes que las que se tienen (por ejemplo, si se tienen 4 
// ingredientes, se pueden hacer las de 3 y 2). Si no hay ninguna que pueda hacerse también debe mostrarse un mensaje.

const LIST_5_INGREDIENTS = "🍕 Con todos los ingredientes, puedes hacer: Pizza casera.";
const LIST_4_INGREDIENTS = "🥗 Puedes preparar: Ensalada completa y Arroz con pollo.";
const LIST_3_INGREDIENTS = "🍝 Además puedes cocinar: Huevos revueltos con jamón y Pasta con queso.";
const LIST_2_INGREDIENTS = "🥚 Y con lo más básico, puedes hacer: Tortilla francesa y Sándwich de jamón.";
const NO_RECIPES = "🛑 No puedes cocinar ninguna receta con esos ingredientes.";

let ingredients = +prompt("Introduce cuántos ingredientes tienes (del 0 al 5):", 5);

switch (ingredients) {
    case 5:
        print(LIST_5_INGREDIENTS);
        break;
    case 4:
        print(LIST_4_INGREDIENTS);
        ingredients = 3;
    case 3:
        print(LIST_3_INGREDIENTS);
        ingredients = 2;
    case 3,2:
        print(LIST_2_INGREDIENTS);
        break;
    default:
        print(NO_RECIPES)
        break;
}

function print(msg) {
    console.log(msg);
}