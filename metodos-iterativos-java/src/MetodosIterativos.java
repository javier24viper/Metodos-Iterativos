/**
 * Módulo 2: Implementación de los Métodos Iterativos (Jacobi y Gauss-Seidel).
 */
public class MetodosIterativos {

    /**
     * Cálculo del error relativo aproximado norma infinito (máxima diferencia entre iteraciones).
     */
    private double calcularError(double[] xNuevo, double[] xViejo) {
        double maxError = 0.0;
        for (int i = 0; i < xNuevo.length; i++) {
            double errorAbs = Math.abs(xNuevo[i] - xViejo[i]);
            if (errorAbs > maxError) {
                maxError = errorAbs;
            }
        }
        return maxError;
    }

    /**
     * Método de Jacobi: Utiliza un vector auxiliar para almacenar los nuevos valores
     * antes de actualizar la solución global.
     */
    public void resolverJacobi(double[][] A, double[] b, double[] x0, double tol) {
        int n = b.length;
        double[] xViejo = x0.clone();
        double[] xNuevo = new double[n];
        int iteracion = 0;
        double error = tol + 1.0;

        System.out.println("=======================================================================");
        System.out.println("                         MÉTODO DE JACOBI                              ");
        System.out.println("=======================================================================");
        System.out.printf("%-10s %-12s %-12s %-12s %-15s\n", "Iter (k)", "x1", "x2", "x3", "Error (||e||)");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-10d %-12.6f %-12.6f %-12.6f %-15s\n", 0, xViejo[0], xViejo[1], xViejo[2], "---");

        while (error > tol && iteracion < 100) {
            iteracion++;

            for (int i = 0; i < n; i++) {
                double suma = 0.0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        suma += A[i][j] * xViejo[j];
                    }
                }
                xNuevo[i] = (b[i] - suma) / A[i][i];
            }

            error = calcularError(xNuevo, xViejo);
            System.out.printf("%-10d %-12.6f %-12.6f %-12.6f %-15.6f\n", 
                              iteracion, xNuevo[0], xNuevo[1], xNuevo[2], error);

            System.arraycopy(xNuevo, 0, xViejo, 0, n);
        }

        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("Convergencia alcanzada en %d iteraciones con error: %.6f\n\n", iteracion, error);
    }

    /**
     * Método de Gauss-Seidel: Emplea la actualización inmediata de variables dentro de la misma iteración.
     */
    public void resolverGaussSeidel(double[][] A, double[] b, double[] x0, double tol) {
        int n = b.length;
        double[] x = x0.clone();
        double[] xAnterior = new double[n];
        int iteracion = 0;
        double error = tol + 1.0;

        System.out.println("=======================================================================");
        System.out.println("                      MÉTODO DE GAUSS-SEIDEL                           ");
        System.out.println("=======================================================================");
        System.out.printf("%-10s %-12s %-12s %-12s %-15s\n", "Iter (k)", "x1", "x2", "x3", "Error (||e||)");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-10d %-12.6f %-12.6f %-12.6f %-15s\n", 0, x[0], x[1], x[2], "---");

        while (error > tol && iteracion < 100) {
            iteracion++;
            System.arraycopy(x, 0, xAnterior, 0, n);

            for (int i = 0; i < n; i++) {
                double suma = 0.0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        suma += A[i][j] * x[j]; // Usa los valores recién calculados en x
                    }
                }
                x[i] = (b[i] - suma) / A[i][i];
            }

            error = calcularError(x, xAnterior);
            System.out.printf("%-10d %-12.6f %-12.6f %-12.6f %-15.6f\n", 
                              iteracion, x[0], x[1], x[2], error);
        }

        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("Convergencia alcanzada en %d iteraciones con error: %.6f\n\n", iteracion, error);
    }
}