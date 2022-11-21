package Operacoes;

class Lista {
	class No {
		Integer frequencia;
		DNS endereco;

		No(Integer frequencia, DNS endereco) {
			this.frequencia = frequencia;
			this.endereco = endereco;
		}
	}

	No[] lista = null;
	final Integer size;
	Integer tamAtual = 0;

	Lista(Integer tamanho) {
		this.size = tamanho;
		lista = new No[this.size];
	}

	public No[] inserir(DNS endereco) {
		if (this.tamAtual != this.size) { // SE OUVER ESPAÇO NA LISTA
			this.lista[this.tamAtual] = new No(0, endereco);
			this.tamAtual++;

		} else {
			System.out.println("Lista cheia. Redimensionar.");
		}
		return lista;
	}

	No remover(DNS endereco) {
		int i = 0;
		No removido = null;
		while (i < this.tamAtual) {
			if (this.lista[i] != null) {
				if (this.lista[i].endereco.url.equals(endereco.url)) {
					removido = this.lista[i];
					break;
				}
				i++;
			}

		}

		for (int j = i; j <= this.tamAtual; j++) {
			if (j == this.tamAtual) {
				this.lista[j] = null;
			} else {
				this.lista[j] = this.lista[j + 1];
			}

		}
		return removido;
	}

	No buscarMF(DNS endereco) {
		int i = 0;
		while (i < this.tamAtual) {
			if (this.lista[i] != null) {
				if (this.lista[i].endereco.url.equals(endereco.url)) {
					this.moverParaFrente(i);
					return this.lista[0];
				}

			}
			i++;
		}
		return null;
	}

	No atualizar(DNS endereco) {
		int i = 0;
		while (i < this.tamAtual) {
			if (this.lista[i] != null) {
				if (this.lista[i].endereco.url.equals(endereco.url)) {
					this.lista[i].endereco.setUrl(endereco.url);
					this.lista[i].endereco.setIp(endereco.ip);
					return this.lista[i];
				}

			}
			i++;
		}
		return null;
	}

	void moverParaFrente(Integer p) {
		No temp1, temp2 = null;
		int i = 0;
		temp1 = this.lista[p];
		while (i <= p) {
			if (i == 0) {
				temp2 = this.lista[i];
				this.lista[i] = temp1;
			} else {
				temp1 = this.lista[i];
				this.lista[i] = temp2;
				temp2 = temp1;
			}
			i++;
		}
	}
}
