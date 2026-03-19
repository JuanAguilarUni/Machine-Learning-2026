public class SimpleLinearRegression {

    public static void main(String[] args) {
        
        double[] advertising = {43.60, 50.44, 59.01, 66.30, 82.36, 92.15, 100.51, 110.06, 111.51};
        double[] sales = {1261.08, 1475.28, 1657.52, 2059.05, 2303.76, 2512.64, 2751.46, 2787.67, 2939.13};
        
        int n = advertising.length;
        
        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumX2 = 0;
        
        for (int i = 0; i < n; i++) {
            sumX += advertising[i];
            sumY += sales[i];
            sumXY += (advertising[i] * sales[i]);
            sumX2 += (advertising[i] * advertising[i]);
        }
        
        double beta1 = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        
        double beta0 = (sumY - beta1 * sumX) / n;
        
        System.out.println("\nRESULTADOS DEL MODELO PREDICTIVO:");
        System.out.printf("Ecuación de Regresión: y^ = %.2f + %.2f * x1\n\n", beta0, beta1);
        
        double[] unknownAdvertising = {45.0, 75.0, 95.0, 120.0, 150.0};
        
        System.out.println("PREDICCIONES");
        for (int i = 0; i < unknownAdvertising.length; i++) {
            double x = unknownAdvertising[i];
            double predictedSales = beta0 + (beta1 * x);
            
            System.out.printf("Advertising = %6.2f = Sales = %.2f\n", x, predictedSales);
        }
    }
}