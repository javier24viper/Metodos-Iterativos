/**
 * Módulo 1: Definición y almacenamiento de los datos del sistema lineal.
 */
public class SistemaEcuaciones {
    private final double[][] A;
    private final double[] b;
    private final double[] x0;
    private final double tolerancia;

    public SistemaEcuaciones() {
        // Matriz de coeficientes A (reordenada para garantizar dominancia diagonal)
        this.A = new double[][] {
            {5.0, 1.0, 1.0},
            {1.0, 4.0, 1.0},
            {1.0, 2.0, 5.0}
        };

        // Vector de términos independientes b
        this.b = new double[] {7.0, 6.0, 8.0};

        // Vector de aproximación inicial X^(0) = [0, 0, 0]^T
        this.x0 = new double[] {0.0, 0.0, 0.0};

        // Tolerancia de error epsilon = 0.0001
        this.tolerancia = 0.0001;
    }

    public double[][] getA() { return A; }
    public double[] getB() { return b; }
    public double[] getX0() { return x0; }
    public double getTolerancia() { return tolerancia; }
}