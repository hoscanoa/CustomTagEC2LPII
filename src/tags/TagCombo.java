package tags;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import bean.ComboBean;

import DAOFactory.DAOCombo;
import DAOFactory.Factory;

public class TagCombo implements Tag {

	PageContext contexto;
	
	private String nombre, sql;
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doStartTag() throws JspException {
		//Permite leer archivos properties
		ResourceBundle rb = ResourceBundle.getBundle("tags");
		JspWriter outHTML = contexto.getOut();
		
		Factory factory = Factory.getTipo(Factory.TIPO_MYSQL);
		DAOCombo dao = factory.getDAOCombo();
		try {
			outHTML.print("<select name='" + nombre + "'>");
			
			ArrayList<ComboBean> lista= dao.listar(rb.getString(sql));
			for (ComboBean comboBean : lista) {
				outHTML.print("<option value='" + comboBean.getValue()+ "'>");
				outHTML.print(comboBean.getText());
				outHTML.print("</option>");
			}
			outHTML.print("</select>");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
				
		return 0;
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPageContext(PageContext arg0) {
		contexto = arg0;
	}

	@Override
	public void setParent(Tag arg0) {
		// TODO Auto-generated method stub

	}

}
