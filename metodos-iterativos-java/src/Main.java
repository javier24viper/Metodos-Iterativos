/**
 * Módulo 3: Clase principal para la ejecución secuencial de los métodos iterativos.
 */
public class Main {
    public static void main(String[] args) {
        // Instanciar el sistema de ecuaciones
        SistemaEcuaciones sistema = new SistemaEcuaciones();
        MetodosIterativos solver = new MetodosIterativos();

        System.out.println("=======================================================================");
        System.out.println("       PRÁCTICA: MÉTODOS ITERATIVOS (JACOBI Y GAUSS-SEIDEL)           ");
        System.out.println("=======================================================================\n");

        // Ejecución de Método de Jacobi
        solver.resolverJacobi(
            sistema.getA(), 
            sistema.getB(), 
            sistema.getX0(), 
            sistema.getTolerancia()
        );

        // Ejecución de Método de Gauss-Seidel
        solver.resolverGaussSeidel(
            sistema.getA(), 
            sistema.getB(), 
            sistema.getX0(), 
            sistema.getTolerancia()
        );
    }
}