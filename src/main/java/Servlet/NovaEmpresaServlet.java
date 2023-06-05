package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Banco;
import Modelo.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovaEmpresaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String novaEmpresa = req.getParameter("nome");
    	String paramDataAbertura = req.getParameter("data");
    	
    	Date dataAbertura = null;
    	
    	
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
    	
    	
    	
    	PrintWriter out = resp.getWriter();
    	
    	Empresa empresa = new Empresa();
    	empresa.setNome(novaEmpresa);
    	empresa.setData(dataAbertura);
    	
    	Banco banco = new Banco();
    	banco.adicionar(empresa);
    	
    	//RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas");
    	req.setAttribute("empresa", empresa.getNome());
    	resp.sendRedirect("listaEmpresas");
    	//req.setAttribute("data", empresa.getData());
    	//rd.forward(req, resp);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}
