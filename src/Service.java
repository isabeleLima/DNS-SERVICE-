import java.nio.charset.Charset;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

import Operacoes.DNS;
import Operacoes.tabelaHash;

public class Service extends TimerTask {
	static tabelaHash tabela = new tabelaHash(127);
	static int version = 1;

	public static void iniciarDNS() {
		System.out.println("INICIANDO TABELA DNS");
		tabela.inserir(new DNS("www.seara.com", randomIp()));
		tabela.inserir(new DNS("www.taldi.com", randomIp()));

		for (int i = 0; i < 23; i++) {
			tabela.inserir(new DNS(radomUrl(), randomIp()));
		}
	}

	static void AdicionarDNS() {

		switch (version) {
		case 1: {
			version++;
			break;
		}
		case 2: {
			segundaRodada();
			version++;
			break;
		}
		case 3: {
			terceiraRodada();
			version++;
			break;
		}
		case 4: {
			for (int i = 0; i < 25; i++) {
				tabela.inserir(new DNS(radomUrl(), randomIp()));
			}
			version++;
			break;
		}
		default: {
			break;
		}
		}

	}

	static void segundaRodada() {
		tabela.inserir(new DNS("www.band.com", randomIp()));
		tabela.inserir(new DNS("www.netflix.com", randomIp()));
		tabela.inserir(new DNS("www.amazonPrime.com", randomIp()));
		tabela.inserir(new DNS("www.disney+.com", randomIp()));
		tabela.inserir(new DNS("www.yandex.com", randomIp()));
		tabela.inserir(new DNS("www.uol.com", randomIp()));
		tabela.inserir(new DNS("www.cnn.com", randomIp()));
		tabela.inserir(new DNS("www.fox.com", randomIp()));

		for (int i = 0; i < 17; i++) {
			tabela.inserir(new DNS(radomUrl(), randomIp()));
		}
	}

	static void terceiraRodada() {
		tabela.inserir(new DNS("www.google.com", "216.239.41.99:5000"));
		tabela.inserir(new DNS("www.yahoo.com", "216.109.118.65:7000"));
		tabela.inserir(new DNS("www.espn.com", "199.181.135.201:6000"));
		tabela.inserir(new DNS("www.globo.com", randomIp()));
		tabela.inserir(new DNS("www.r7noticias.com", randomIp()));
		tabela.inserir(new DNS("www.rural.com", randomIp()));
		tabela.inserir(new DNS("www.jogosDaBarbie.com", randomIp()));
		tabela.inserir(new DNS("www.UFERSA.com", randomIp()));
		tabela.inserir(new DNS("www.UERNE.com", randomIp()));
		tabela.inserir(new DNS("www.UNP.com", randomIp()));
		tabela.inserir(new DNS("www.amazom.com", randomIp()));
		tabela.inserir(new DNS("www.ebook.com", randomIp()));
		tabela.inserir(new DNS("www.americanas.com", randomIp()));
		tabela.inserir(new DNS("www.magazineluiza.com", randomIp()));
		tabela.inserir(new DNS("www.friv.com", randomIp()));

		for (int i = 0; i < 10; i++) {
			tabela.inserir(new DNS(radomUrl(), randomIp()));
		}
	}

	public static void imprimir() {
		tabela.imprimir();
	}

	public static void buscar(String url) {
		DNS endereco = new DNS(url, "0");

		DNS response = tabela.buscar(endereco);
		if (response == null) {
			System.out.println("=================================");
			System.out.println("");
			System.out.println("endereco não encontrado");
			System.out.println("");
			System.out.println("=================================");
		} else {
			System.out.println("=================================");
			System.out.println("");
			System.out.println("endereco DNS encontrado");
			System.out.println("URL: " + response.getUrl());
			System.out.println("PORTA: " + response.getIp());
			System.out.println("");
			System.out.println("=================================");
		}
	}

	public static void remover(String url) {
		DNS endereco = new DNS(url, "0");
		DNS response = tabela.remover(endereco);
		if (response == null) {
			System.out.println("=================================");
			System.out.println("");
			System.out.println("endereco não encontrado");
			System.out.println("");
			System.out.println("=================================");
		} else {
			System.out.println("=================================");
			System.out.println("");
			System.out.println("endereco DNS " + response.getUrl() + "removido com sucesso!");
			System.out.println("");
			System.out.println("=================================");
			
		}
	}

	public static void inserir(String url, String porta) {
		DNS response = tabela.inserir(new DNS(url, porta));
		if (response == null) {
			System.out.println("=================================");
			System.out.println("");
			System.out.println("erro ao adicionar novo endereço DNS");
			System.out.println("");
			System.out.println("=================================");
		} else {
			System.out.println("=================================");
			System.out.println("");
			System.out.println("endereco DNS inserido com sucesso");
			System.out.println("URL: " + response.getUrl());
			System.out.println("PORTA: " + response.getIp());
			System.out.println("");
			System.out.println("=================================");
		}
	}
	
	public static void atualizar(String url, String porta) {
		DNS response = tabela.atualizar(new DNS(url, porta));
		if (response == null) {
			System.out.println("=================================");
			System.out.println("");
			System.out.println("erro ao atualizar novo endereço DNS");
			System.out.println("");
			System.out.println("=================================");
		} else {
			System.out.println("=================================");
			System.out.println("");
			System.out.println("endereco DNS atualizado com sucesso");
			System.out.println("URL: " + response.getUrl());
			System.out.println("PORTA: " + response.getIp());
			System.out.println("");
			System.out.println("=================================");
		}
	}

	public static String radomUrl() {
		int leftLimit = 97;
		int rightLimit = 122;
		int targetStringLength = 8;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		String url = "www." + generatedString + ".com";
		return url;
	}

	public static String randomIp() {
		int min_val = 100;
		int max_val = 255;
		ThreadLocalRandom tlr = ThreadLocalRandom.current();

		String n1 = Integer.toString(tlr.nextInt(min_val, max_val + 1));
		String n2 = Integer.toString(tlr.nextInt(min_val, max_val + 1));
		String n3 = Integer.toString(tlr.nextInt(min_val, max_val + 1));
		String n4 = Integer.toString(tlr.nextInt(min_val, max_val + 1));
		min_val = 1000;
		max_val = 10000;

		String porta = Integer.toString(tlr.nextInt(min_val, max_val + 1));

		return n1 + "." + n2 + "." + n3 + "." + n4 + ":" + porta;

	}

	@Override
	public void run() {
		AdicionarDNS();
	}

}
