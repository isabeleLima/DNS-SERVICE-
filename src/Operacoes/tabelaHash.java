package Operacoes;

import java.util.Iterator;

public class tabelaHash {
	int tamanho;
	Lista tabela[];

	public tabelaHash(int tamanho) {
		this.tamanho = tamanho;
		tabela = new Lista[tamanho];
	}

	private int hash(String url) {
		int key = UrlToKey(url);
		return key % tamanho;
	}

	private int UrlToKey(String url) {
		int h = 0;
		for (int i = 0; i < url.length(); i++) {
			h = (h + url.charAt(i)) % tamanho;
		}
		return h;
	}

	public DNS inserir(DNS endereco) {
		int h = hash(endereco.url);

		Lista lista = tabela[h];

		if (lista == null) {
			lista = new Lista(13);
			lista.inserir(endereco);
			tabela[h] = lista;

			return endereco;
		} else {
				tabela[h].inserir(endereco);	
			    return endereco;
		}
			
	}
	
	public DNS atualizar(DNS endereco) {
		int h = hash(endereco.url);

		Lista lista = tabela[h];

		if (lista == null) {
			return null;
		} else {
			if (tabela[h].atualizar(endereco) == null) {
				return null;
				
			}
			return endereco;
		}
			
	}

	public DNS buscar(DNS endereco) {
		int h = hash(endereco.url);
		if (tabela[h] == null) {
			return null;
		} else {
			Lista.No no = tabela[h].buscarMF(endereco);

			if (no == null) {
				return null;
			} else {
				return no.endereco;
			}
		}
	}

	public DNS remover(DNS endereco) {
		int h = hash(endereco.url);
		if (tabela[h] == null) {
			return null;
		} else {
			Lista.No no = tabela[h].remover(endereco);
			if (no == null) {
				return null;
			} else {
				return no.endereco;
			}
		}
	}

	public void imprimir() {
		for (int i = 0; i < tabela.length; i++) {
			System.out.println("Linha " + i + " da tabela Hash");
			if (tabela[i] != null) {
				for (int j = 0; j < tabela[i].lista.length; j++) {
					if (tabela[i].lista[j] != null) {
						System.out.print(tabela[i].lista[j].endereco.url + ",");
					} else {
						System.out.print("| |, ");
					}

				}
				System.out.println("");
			} else {
				System.out.print("vazia	");

				System.out.println("");
			}

		}
	}
}
