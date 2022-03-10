package mjv.al.notificacao;

import java.util.List;

import com.google.gson.Gson;

import mjv.al.atracao.model.Contrato;
import mjv.al.atracao.service.ContratoService;
import mjv.al.atracao.service.GeradorArquivo;
import mjv.al.atracao.service.LeitorContrato;

public class AguaLuzNotificacaoApp {
	public static void main(String[] args) {
		LeitorContrato leitor = new LeitorContrato();
		ContratoService service = new ContratoService();
		List<Contrato> contratos = leitor.lerArquivo();
		GeradorArquivo gerador = new GeradorArquivo();
		for(Contrato contrato: contratos) {
			Gson gson = new Gson(); // conversor
			String json = gson.toJson( contrato );
			System.out.println(json);
			System.out.println(contrato);
			String conteudo = service.gerarConteudoContrato(contrato);
			gerador.gerarContrato(conteudo, contrato.getPessoa().getCpf());
		}
	}
}
