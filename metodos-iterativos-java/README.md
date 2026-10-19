# Práctica: Métodos Iterativos (Jacobi y Gauss-Seidel)

**Docente:** Víctor Hugo Vásquez Herrera  
**Materia:** Métodos Numéricos  
**Institución:** Instituto Tecnológico Superior de Xalapa (ITSX)  

---

## 1. Arquitectura Modular

El proyecto implementa una arquitectura de tres módulos independientes:

1. **`SistemaEcuaciones.java` (Módulo 1):** Define la matriz de coeficientes $A$ (ordenada con estricta dominancia diagonal), el vector $b$, el vector inicial $X^{(0)} = [0,0,0]^T$ y la tolerancia $\epsilon = 0.0001$.
2. **`MetodosIterativos.java` (Módulo 2):** Implementa la lógica de cálculo para Jacobi (utilizando vector auxiliar) y Gauss-Seidel (utilizando actualización inmediata de variables).
3. **`Main.java` (Módulo 3):** Clase principal que ejecuta ambos métodos de forma secuencial y presenta las comparaciones en consola.

---

## 2. Compilación y Ejecución

### Pasos:
1. Abre una terminal dentro de la carpeta `src/`.
2. Compila el código fuente:
   ```bash
   javac *.java