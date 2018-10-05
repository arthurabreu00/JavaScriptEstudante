package Quest04;

public class EntradaDeCinema {

	String dataDofilme;
	String horario;
	int sala;
	float valor;
	int idadeCli;

	public EntradaDeCinema(String data, String horario, int sala, float valor) {

		this.dataDofilme = data;
		this.horario = horario;
		this.sala = sala;
		this.valor = valor;
	}

	int[] getDataFilme(String data) {

		char dia[] = { data.charAt(0), data.charAt(1) };
		char mes[] = { data.charAt(3), data.charAt(4) };
		char ano[] = { data.charAt(6), data.charAt(7), data.charAt(8), data.charAt(9) };
		int dia1 = Integer.parseInt(String.copyValueOf(dia));
		int mes1 = Integer.parseInt(String.copyValueOf(mes));
		int ano1 = Integer.parseInt(String.copyValueOf(ano));

		int completa[] = { dia1, mes1, ano1 };

		return completa;

	}

	float calculaDesconto(String nasc) {

		if (this.idade(nasc) <= 12) {

			this.valor *= 0.5;
		}

		return this.valor;

	}

	int idade(String nasc) {

		int filme[] = this.getDataFilme(nasc);
		int cliente[] = this.getDataFilme(this.dataDofilme);
		int finala = 0;

		if (filme[1] <= cliente[1])
			
			finala = cliente[2] - (filme[2]);
		
		else if (filme[1] > cliente[1])
			finala = cliente[2] - (filme[2] + 1);
		
		else{
			if (cliente[0] <= filme[0])
				finala = cliente[2] - (filme[2]) ;
			else
				finala = cliente[2] - (filme[2] + 1); ;
		}

		return finala;

	}

	float calculaDescontoEstudante(String nasc, int cart) {
		if (cart != 0) {

			int idade = this.idade(nasc);

			if (idade > 12 && idade <= 15) {

				this.valor *= 0.4;

			}

			else if (idade >= 16 && idade <= 20) {

				this.valor *= 0.3;

			}

			else if (idade > 20) {

				this.valor *= 0.2;

			}
			
		}
		
		return this.valor;

	}
	
	int[] horaMinuto(){
		
		char hora[] = { this.horario.charAt(0), this.horario.charAt(1)};
		char minuto[] = { this.horario.charAt(3), this.horario.charAt(4)};
		
		int hr = Integer.parseInt(String.copyValueOf(hora));
		int min = Integer.parseInt(String.copyValueOf(minuto));
		
		int hm[] = {hr,min};
		
		return hm;
	} 
	
	int getHora(){
		
		int hora[] = this.horaMinuto();
		return hora[0];
		
	}

	float calculaDescontoHorario(String nasc, int cart) {

		this.calculaDesconto(nasc);
		this.calculaDescontoEstudante(nasc, cart);
		
		// ACIMA GARANTO QUE O METODO calculaDescontoHorario() SERA O ULTIMO A
		// SER EXECUTADO.

		if (this.getHora() < 16)
			this.valor *= 0.1;

		return this.valor;
	}

	void imprimaString(String nasc){

		System.out.println("Data do Filme: " + this.dataDofilme);
		System.out.println("Horario: " + this.horario);
		System.out.println("Idade do cliente: " + this.idade(nasc));
		System.out.println("Sala: " + this.sala);
		System.out.println("Valor: R$" + this.valor);


	}

}
