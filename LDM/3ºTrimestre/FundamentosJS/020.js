// 020iniciarSesion.js/.html: Escribe un código que pregunte por el inicio de sesión con propmt. Si el visitante ingresa "Admin", entonces prompt(pregunta) por una contraseña, 
// si la entrada es una línea vacía o Esc – muestra “Cancelado.”, si es otra cadena de texto – entonces muestra “No te conozco”.

// La contraseña se comprueba de la siguiente manera:
// -       Si es igual a “TheBoss”, entonces muestra “Bienvenido a tu reino, jefe”,
// -       Si es otra cadena de texto – muestra “Contraseña incorrecta”,
// -       ”

// Por favor, usa bloques anidados de if. Piensa en la legibilidad general del código.
// Pista: si se le pasa una entrada vacía a un prompt, retorna una cadena de texto vacía ''. Presionando ESC durante un prompt devuelve null.

let user = prompt("Introduce que usuario eres.");
let password;

user == "" || user == null ? alert("Cancelado.") :
user != ("Admin") ? alert("No te conozco.") : 
password = prompt("Introduce su contraseña.");

password == null ? 0 :
password == "TheBoss" ? alert("Bienvenido a tu reino, jefe.") : alert("Contraseña incorrecta.");