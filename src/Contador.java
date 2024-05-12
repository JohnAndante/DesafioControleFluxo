import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in).useLocale(java.util.Locale.US);

        try {
            System.out.println("Digite o primeiro parâmetro:");
            int parametroUm = terminal.nextInt();

            System.out.println("Digite o segundo parâmetro:");
            int parametroDois = terminal.nextInt();

            try {
                contar(parametroUm, parametroDois);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                terminal.close();
            }

        } catch (Exception e) {
            if (e instanceof InputMismatchException) {
                System.out.println("Erro - Digite números inteiros para ambos os parâmetros.");
            } else {
                System.out.println("Erro desconhecido.");
            }
        } finally {
            terminal.close();
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro.");
        }

        int contagem = parametroDois - parametroUm;

        System.out.println("\nContando de " + parametroUm + " até " + contagem + ":");

        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }

        System.out.println("\nContagem finalizada.\n");
    }
}
