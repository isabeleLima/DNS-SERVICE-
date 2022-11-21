package Operacoes;

public class DNS {
	public String url; // CHAVE
	public String ip; // VALOR

	public DNS(String url, String ip) {
		this.url = url;
		this.ip = ip;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
