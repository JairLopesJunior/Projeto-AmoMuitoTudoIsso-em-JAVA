package amomuitotudoisso;

import java.util.ArrayList;
import java.util.List;

public class FilaEsperaPedido {

	List<Cliente> clientes = new ArrayList<Cliente>();
	List<ClienteIdoso> clientesIdosos = new ArrayList<ClienteIdoso>();
	
	public void add(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void addIdoso(ClienteIdoso clienteIdoso) {
		clientesIdosos.add(clienteIdoso);
	}
	
	public double retornarSatisfacao() {
		int count = 0;
		double b = 0;
		for(Cliente c : clientes) {
			double a = c.getPedido().getSatisfacao();
			b += a;
			count++;
			b /= count;
		}
		return b;
	}
	
	public double retornarSatisfacaoIdosa() {
		int count = 0;
		double d = 0;
		for(ClienteIdoso c : clientesIdosos) {
			double e = c.getPedido().getSatisfacao();
			d += e;
			count++;
			d /= count;
			return d;
		}
		return 0;
	}
}
