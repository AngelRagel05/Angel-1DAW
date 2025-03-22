# 📌 Planificación de las Pruebas

## 🚀 ¿Por qué son necesarias?
Las pruebas aseguran que el software es correcto y cumple con las características impuestas por el cliente.

---

## 🛠️ Organización de las pruebas
Las pruebas se organizan siguiendo estrategias como el **Modelo en Espiral**, con el siguiente orden:

1️⃣ **Pruebas unitarias** 🧩
2️⃣ **Pruebas de integración** 🔄
3️⃣ **Pruebas de validación** ✅
4️⃣ **Pruebas de sistema** 💻

📌 **Ejemplo de modelo en espiral:**

![Modelo en Espiral](/img/Modelo_Espiral.png)

---

## 🔍 Tipos de pruebas

### 📦 Pruebas de Caja Negra
➡️ Se centran en comprobar que las salidas sean correctas sin analizar la lógica interna.

### 🔎 Pruebas de Caja Blanca
➡️ Evalúan la estructura interna del código, verificando el flujo lógico.

### ⚡ Pruebas de Carga
📌 Analizan cómo se comporta el software con alto tráfico:

- **Prueba de estrés** 💥: Límite máximo antes de fallar.
- **Prueba de estabilidad** 🔄: Soporte de carga sostenida.
- **Prueba de picos** 📈: Cambios drásticos en la carga.

📊 **Ejemplo de prueba de carga:**

![Pruebas de carga](/img/Pruebas_Carga.png)

### 🔄 Pruebas de Regresión
Verifican que los cambios no introduzcan nuevos errores.

### ✅ Pruebas Funcionales
Evalúan si el software cumple con los requisitos especificados.

### 🏗️ Pruebas Estructurales
Analizan la arquitectura interna del software.

---

## 📝 Procedimientos y casos de prueba
Para diseñar y aplicar pruebas se siguen varios enfoques:

- **Caja Negra**: Validar los resultados esperados.
- **Caja Blanca**: Verificar la estructura interna.
- **Aleatorio**: Generar casos de prueba con entradas variadas.

---

## 🛠️ Herramientas de depuración
### 🐞 Tipos de errores y cómo detectarlos:
- **Errores de compilación** ❌: Fallos de sintaxis detectados por el entorno de desarrollo.
- **Errores lógicos (bugs)** 🐛: No impiden la ejecución, pero generan resultados incorrectos.

📌 **Ejemplo de depuración en un IDE:**

![Depuración](/img/Depuración.png)

Los depuradores permiten seguir la ejecución y encontrar errores fácilmente.

---

## 🏆 Validaciones: Importancia del Cliente
El cliente juega un papel clave en la evaluación final del software. La validación se realiza mediante pruebas de caja negra y análisis de conformidad con los requisitos.

📌 **Posibles resultados:**
- ✅ Cumple con las especificaciones.
- ⚠️ Se detectan deficiencias y se documentan para corrección.

---

## 📏 Normas de Calidad
Estándares usados en la industria:

- **BSI (British Standards Institute)** 📘:
  - BS 7925-1: Vocabulario de pruebas de software.
  - BS 7925-2: Pruebas de componentes software.
- **IEEE (Institute of Electrical and Electronics Engineers)** 📗:
  - IEEE 829: Documentación de pruebas.
  - IEEE 1008: Pruebas unitarias.
- **ISO / IEC** 📕:
  - 12207, 15289, 29119.

📌 **Ejemplo de flujo de pruebas en estándares IEEE:**

![IEEE Pruebas](/img/IIEE_Pruebas.png)

---

## 🎯 Conclusión
La planificación de pruebas es clave para asegurar la calidad del software. Con estrategias adecuadas y herramientas de depuración, se pueden detectar errores antes de llegar al cliente final.

🔗 **¿Quieres contribuir o mejorar el proyecto?** ¡No dudes en hacer un pull request! 🚀
