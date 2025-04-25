// 019if.js/.html: ¿Cuáles de estos alerts va a ejecutarse? ¿Cuáles serán los resultados de las expresiones dentro de if(...)?

if (-1 || 0) alert( "primero" );

if (-1 && 0) alert( "segundo" );

if (null || -1 && 1) alert( "tercero" );

// Tercero

// Primero y tercero, no tiene sentido