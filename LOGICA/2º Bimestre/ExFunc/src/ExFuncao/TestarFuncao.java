package ExFuncao;

import java.util.Scanner;

public class TestarFuncao {
	public static void main(String[] args) {
	ExFuncao func = new ExFuncao();
	boolean vef = true;
	while(vef){
		Scanner input = new Scanner(System.in);
		System.out.print("Digite as horas: ");
		int hora = input.nextInt();
		System.out.print("Digite os minutos: ");
		int min = input.nextInt();
		System.out.println(func.ex6(hora, min));

		System.out.print("Deseja continuar ? [S/N]: ");
		input = new Scanner(System.in);
		String v = input.next();
		if(v.equalsIgnoreCase("N"))
			break;
		}

	}

}
