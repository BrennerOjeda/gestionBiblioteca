package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexion.BDConexion;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BDConexion bd = new BDConexion();
		
		// TODO Auto-generated method stub
		int docIdeUsu =Integer.parseInt(request.getParameter("docIdeUsu"));
		String nomUsu = request.getParameter("nomUsu");
		String apeUsu = request.getParameter("apeUsu");
		//int telUsu = Integer.parseInt(request.getParameter("telUsu"));
		int telUsu = Integer.parseInt(request.getParameter("telUsu"));
		String dirUsu = request.getParameter("dirUsu");
		String emaUsu = request.getParameter("emaUsu");
		String passUsu = request.getParameter("passUsu");
		
		PrintWriter m = response.getWriter();
		m.println(docIdeUsu);
		m.println(nomUsu);
		m.println(apeUsu);
		m.println(telUsu);
		m.println(dirUsu);
		m.println(emaUsu);
		m.println(passUsu);
		bd.conectar();
		bd.nuevoUsuario(docIdeUsu, nomUsu, apeUsu, telUsu, dirUsu, emaUsu, passUsu);
		m.println("<br>registro insertado correctamente");
		bd.cerrarConexion();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
