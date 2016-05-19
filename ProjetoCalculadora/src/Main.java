import java.util.Scanner;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

public class Main {

	public static void main(String[] args) {		
		String nome = lerString();
		Calculadora calc = new Calculadora(nome);

		boolean vaiParaProximo = true;

		Scanner leitor = new Scanner(System.in);
		
		while (vaiParaProximo) {
			System.out.println("Qual operação você quer realizar?\n "
					+ "1-somar;\n 2-subtrair;\n 3-dividir;\n 4-multiplicar;\n 5-ehPar;\n 6-potencia");
			int operacao = leitor.nextInt();
			double valor1, valor2;
			
			switch (operacao) {
			case 1:
				valor1 = lerDouble();
				valor2 = lerDouble();

				imprime("soma", calc.somar(valor1, valor2));
				break;

			case 2:
				valor1 = lerDouble();
				valor2 = lerDouble();

				imprime("subtrair", calc.subtrair(valor1, valor2));
				break;
			case 3:
				valor1 = lerDouble();
				valor2 = lerDouble();

				imprime("divisão", calc.dividir(valor1, valor2));
				break;
			case 4:
				valor1 = lerDouble();
				valor2 = lerDouble();

				imprime("multiplicação", calc.multiplicar(valor1, valor2));
				break;
			case 5:
				System.out.println("Insira o valor: ");
				int valor = leitor.nextInt();

				System.out.println("O resultado de ehPar foi: " + calc.ehPar(valor));
				break;
			case 6:
				System.out.println("Insira o 1º valor: ");
				int v1 = leitor.nextInt();

				System.out.println("Insira o 2º valor: ");
				int v2 = leitor.nextInt();

				imprime("potência", calc.potencia(v1, v2));
				break;

			default:
				System.out.println("Operação inválida! Tente novamente!");
				break;
			}

			System.out.println("Você quer realizar outra operação? [s|n]");
			String continua = leitor.next();

			if (!continua.equals("s")) {
				vaiParaProximo = false;
			}
		}
		
		System.out.println("Obrigado, " + nome);
	}

	public static void imprime(String nomeOper, double resultado) {
		System.out.println("O resultado da " + nomeOper + " foi: " + resultado);
	}
	
	public static String lerString(){
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o nome: ");
		return leitor.next();
	}
	
	public static double lerDouble(){
		boolean naoEDouble = true;
		double valor = 0;
		while (naoEDouble) {
			Scanner leitor = new Scanner(System.in);
			System.out.println("Digite o valor: ");
			try {
				valor = leitor.nextDouble();
				naoEDouble = false;
			} catch (Exception e) {
				System.out.println("Double não é válido!");
			}
		}
		return valor;
	}

}
