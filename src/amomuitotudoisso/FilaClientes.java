package amomuitotudoisso;

import java.util.LinkedList;
import java.util.Queue;

public class FilaClientes {

	Queue<Cliente> fila = new LinkedList<Cliente>();
	
	public void add(Cliente clientes) {
		fila.add(clientes);
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
	
	public void verificarIdade(int idade, Cliente cliente) {
		if(idade > 65) {
			fila.add(cliente);
		}
	}
	
	public Cliente encontrarClienteCpf(String cpf) {
		for(Cliente c : fila) {
			if(c.getCpf().equals(cpf)) {
				return c;
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

	public Queue<Cliente> getFila() {
		return fila;
	}

	public void setFila(Queue<Cliente> fila) {
		this.fila = fila;
	}
	
}
