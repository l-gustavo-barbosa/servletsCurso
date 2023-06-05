package Acao;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Banco;
import Modelo.Empresa;

public class NovaEmpresa {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String novaEmpresa = request.getParameter("nome");
    	String paramDataAbertura = request.getParameter("data");
    	
    	Date dataAbertura = null;
    	
    	
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
    	
    	PrintWriter out = response.getWriter();
    	
    	Empresa empresa = new Empresa();
    	empresa.setNome(novaEmpresa);
    	empresa.setData(dataAbertura);
    	
    	Banco banco = new Banco();
    	banco.adicionar(empresa);
    	
    	//RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas");
    	request.setAttribute("empresa", empresa.getNome());
    	return "forward:entrada?acao=ListaEmpresas";

	}
}
