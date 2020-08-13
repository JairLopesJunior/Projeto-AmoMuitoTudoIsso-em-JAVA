package amomuitotudoisso;

import java.util.Deque;
import java.util.LinkedList;

public class FilaClientes {

	Deque<Cliente> fila = new LinkedList<Cliente>();
	Deque<ClienteIdoso> filaIdosa = new LinkedList<ClienteIdoso>();
	
	public void add(Cliente clientes) {
		fila.add(clientes);
	}
	
	public void addIdoso(ClienteIdoso clienteIdoso) {
		filaIdosa.addLast(clienteIdoso);
	}
	
	public int verificarIndex(Cliente clientes, int count) {
		for(Cliente c : fila) {
			if(c.getCpf().equals(clientes.getCpf())) {
				return count;
			}
			count++;
		}
		return -1;
	}

	public int verificarIndexIdoso(ClienteIdoso clientes, int count) {
		for(ClienteIdoso c : filaIdosa) {
			if(c.getCpf().equals(clientes.getCpf())) {
				return count;
			}
			count++;
		}
		return -1;
	}
	
	public boolean verificarIdade(int idade) {
		if(idade > 65) {
			return true;
		}
		return false;
	}

	public Cliente verificarClientesIdosos() {
		for(Cliente c : fila) {
			if(c.getIdade() > 65) {
				fila.pop();
			}
		}
		return null;
	}
	
	public Cliente encontrarCliente(String nome) {
		for(Cliente cl : fila) {
			String nomeCerto = cl.getNome();
			if(nomeCerto.equals(nome)) {
				return cl;
			}
		}
		return null;
	}
	
	public ClienteIdoso encontrarClienteIdoso(String nome) {
		for(ClienteIdoso cl : filaIdosa) {
			String nomeCerto = cl.getNome();
			if(nomeCerto.equals(nome)) {
				return cl;
			}
		}
		return null;
	}
	
	public ClienteIdoso encontrarClienteIdosoCpf(String cpf) {
		for(ClienteIdoso cl : filaIdosa) {
			if(cl.getCpf().equals(cpf)) {
				return cl;
			}
		}
		return null;
	}
	
	public Cliente encontrarClienteCpf(String cpf) {
		for(Cliente cl : fila) {
			if(cl.getCpf().equals(cpf)) {
				return cl;
			}
		}
		return null;
	}

	public Deque<Cliente> getFila() {
		return fila;
	}

	public void setFila(Deque<Cliente> fila) {
		this.fila = fila;
	}
	
}
