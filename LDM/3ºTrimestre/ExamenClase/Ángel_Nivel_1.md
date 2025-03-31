# Nivel 1 🍼


### 1. Declarar las siguientes variables y asigna un valor que tenga sentido 🧠:
```Javascript  

    // Declaro todas las variables con su tipo correspondiente.
    let firstName = "Angel";
    let lastName = "Jimenez Ragel";
    let country = "España";
    let city = "Córdoba";
    let age = 19;
    let isMarried = false;
    let year = 2025;
    let thisNull = null;
    let thisUndefined = undefined;
    let thisisnotanumber = NaN;

```
            
### Ahora usa el operador typeof como si fuese a verificar diferentes tipos de datos. Y pon al lado qué resultado obtendrías.
Ejemplo:

```Javascript 
    let username = "olga";

    // Visualizo el resultado y pongo el tipo que es de cada dato
    typeof(username) // Resultado: String
    typeof(firstName) // String
    typeof(lastName) // String
    typeof(country) // String
    typeof(city) // String 
    typeof(age) // Integer -- Number 🥚🥚
    typeof(isMarried) // Boolean
    typeof(year) // Integer -- Number 🥚🥚
    typeof(thisNull) // Object
    typeof(thisUndefined) // Undefined
    typeof(thisisnotanumber) // NaN

    // 2 Fallos

```


### 2. Calcular el resultado de la siguientes expresiones de comparación:
```Javascript 
// Pienso 🧠 y Razono (más o menos)
4 > 3  // Resultado: True
4 <= 3 // False
'4' == 4 // True
4 === '4' // False
4 !== 4 // False
4 > 3 && 10 < 12 // True
4 > 3 || 10 < 12 // True
Boolean(" " == !(false)) // False
Boolean(Number(" 3 ") === 3) // True
null == 0 // True -- False
undefined == null // False -- True
(3>2)? (1=='1') : (0!=false) // (1=='1') -> True
null??undefined??0??" " // True -- 0

// 3 fallos

```

### 3. Escribir un script que solicite al usuario que ingrese la base y la altura de un triángulo y calcule el área de un triángulo (área = 0,5 * b * h).

```Javascript 
"use strict"

// Pido al usuario la base y la altura de su triángulo
let base = prompt("Ingresa la base de su triángulo.", 5);  // puse promt en vez de prompt 🥚🥚
let altura = prompt("Ingresa la altura de su triángulo.", 10);  // puse promt en vez de prompt 🥚🥚

// Calculo el área
let area = (base * altura) / 2;

// Muestro por consola el resultado
console.log("El área de su triángulo es: " + area)

```

### 4. Cree un script que determine si un año introducido por el usuario es bisiesto. Utiliza el operador ternario o elvis y el nullish coalescing. Asegúrate de que todo el condicionamiento es correcto. Los años bisiestos se determinan mediante las siguientes reglas:

Los años bisiestos son divisibles por cuatro (como 1984 y 2004). Sin embargo, los años divisibles por 100 no son bisiestos (como 1800 y 1900) a menos que sean divisibles por 400 (como 1600 y 2000, que sí lo fueron).

```JavaScript
"use strict"

// Le pido al usuario el año para averiguarlo
let year = prompt("Introduce el año que quiere saber si es o no biciesto.") ?? 2025; // puse promt en vez de prompt 🥚🥚

// Averiguo si es o no biciesto y lo muestro por consola

// Si el año introducido es divisible entre 100 o si ese mismo año entre 400 no es 0, 
// ese año no es biciesto. 
(year % 100 == 0 && year % 400 != 0) ? console.log("El año introducido no es biciesto.") :

// Si ha pasado el filtro anterior solo queda comprobar si es divisible entre 4
// si lo es, el año es biciesto sino no lo es
(year % 4 == 0) ? console.log("El año introducido si es bisiesto.") : 
console.log("El año introducido no es biciesto.");
```


Diria que teniendo 5 fallos en la lógica de comparaciones y lo de la 'p' en la palabra prompt, minimo un 8.5 tendria, yo me pondria un 9.0 sinceramnete.