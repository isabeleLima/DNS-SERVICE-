import java.util.Scanner;
import java.util.Timer;

public class Client {

	public static void main(String[] args) {
		boolean iniciar = true;
		Timer t = new Timer();
		Service service = new Service();
		Scanner teclado = new Scanner(System.in);
		System.out.println("INICIANDO SERVIDOR DNS");
		service.iniciarDNS();
		t.scheduleAtFixedRate(service, 0, 20000);
		while (iniciar) {
			System.out.println("QUAIS OPERAÇÕES DESEJA FAZER?");
			System.out.println("1- Buscar DNS pela url");
			System.out.println("2- Inserir novo endereço DNS");
			System.out.println("3- Remover novo endereço DNS");
			System.out.println("4- Atualizar endereço pela url");
			System.out.println("5- Imprimir tabelaHash");
			System.out.println("6- encerrar execução");

			int response = teclado.nextInt();

			switch (response) {
			case 1: {
				System.out.println("BUSCAR DNS PELA URL?");
				System.out.println("Digite a url desejada");
				String url = teclado.next();
				service.buscar(url);
				break;
			}
			case 2: {
				System.out.println("INSERIR NOVO ENDERECO DNS");
				System.out.println("Digite a url");
				String url = teclado.next();
				System.out.println("Digite a porta");
				String porta = teclado.next();
				service.inserir(url, porta);
				break;
			}
			case 3: {
				System.out.println("REMOVER ENDERECO DNS");
				System.out.println("Digite a url");
				String url = teclado.next();
				service.remover(url);
				break;
			}
			case 4: {
				System.out.println("ATUALIZAR ENDERECO PELA URL");
				System.out.println("Digite a url");
				String url = teclado.next();
				System.out.println("Digite a porta");
				String porta = teclado.next();
				service.atualizar(url, porta);
				break;
			}
			case 5: {
				service.imprimir();
				break;
			}
			default: {
				System.out.println("ENCERRANDO SERVIDOR DNS");
				iniciar = false;
				break;
			}
			}
		}

	}

}
