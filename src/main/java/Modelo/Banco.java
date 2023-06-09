package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	private static List<Empresa> lista = new ArrayList<>();;
	private static Integer chaveSequencial = 1;
	private static List<Usuario> usuarios = new ArrayList<>();
	
	
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Caelum");
		adicionar(empresa);
		adicionar(empresa1);
		Usuario usuario = new Usuario();
		Usuario usuario1 = new Usuario();
		usuario.setLogin("Nico");
		usuario.setSenha("Nico123");
		usuario1.setLogin("Ana");
		usuario1.setSenha("Ana123");
		usuarios.add(usuario1);
		usuarios.add(usuario);
		
	}
	
	public static void adicionar(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}
	
	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		while(it.hasNext()) {
			Empresa empresa = it.next();
			if(empresa.getId()==id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
			
		}
		return null;
	}
	
	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : usuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
			
		}
		return null;
	}
	
	
}
