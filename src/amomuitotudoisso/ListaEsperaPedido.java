package amomuitotudoisso;

import java.util.ArrayList;
import java.util.List;

public class ListaEsperaPedido {

	List<Cliente> clientes = new ArrayList<Cliente>();
	List<ClienteIdoso> clientesIdosos = new ArrayList<ClienteIdoso>();
	
	public void add(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void addIdoso(ClienteIdoso clienteIdoso) {
		clientesIdosos.add(clienteIdoso);
	}
	
	public void removerCliente(Cliente c) {
		clientes.remove(c);
	}
	
	public void removerClienteIdoso(ClienteIdoso c) {
		clientesIdosos.remove(c);
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
	
	public Cliente retornarPedido(int num) {
		for(Cliente c : clientes) {
			if(c.getNumeroPedido() == num) {
				return c;
			}
		}
		return null;
	}

	public ClienteIdoso retornarPedidoIdoso(int num) {
		for(ClienteIdoso c : clientesIdosos) {
			if(c.getNumeroPedido() == num) {
				return c;
			}
		}
		return null;
	}
}
