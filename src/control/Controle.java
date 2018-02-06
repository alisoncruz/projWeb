package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Cliente;
import entity.Endereco;
import persistence.ClienteDao;


@WebServlet("/Controle")
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		if(cmd.equalsIgnoreCase("gravar")) {
			gravar(request, response);
		}
	}
		
	protected void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg = null;
	
		try {
			
			ClienteDao cDao = new ClienteDao();
			Cliente c = new Cliente();
			Endereco e = new Endereco();
			
			
			c.setNome(request.getParameter("nome"));
			c.setEmail(request.getParameter("email"));
			e.setLogradouro(request.getParameter("logradouro"));
			e.setBairro(request.getParameter("bairro"));
			e.setCidade(request.getParameter("cidade"));
			e.setEstado(request.getParameter("estado"));
			e.setCep(request.getParameter("cep"));
			
			c.setEndereco(e);
			
			cDao.create(c);
			
			msg= "Dados gravados";
			
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Error"+ e.getMessage();
		} finally {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
		}
	}

}
