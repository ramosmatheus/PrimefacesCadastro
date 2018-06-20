package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.ProdutoDAO;
import modelo.Produto;

@ManagedBean
@ViewScoped
public class ProdutoMB {
	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<>();
	private ProdutoDAO produtoDAO= new ProdutoDAO();
	
	public ProdutoMB() {
		produtos = produtoDAO.buscarTodos();
	}
	
	public void inserir(){
		if(produto.getId() == null){
			produtoDAO.salvar(produto);
		}else {
			produtoDAO.alterar(produto);
		}
		produtoDAO.salvar(produto);
		produtos = produtoDAO.buscarTodos();		
		produto = new Produto();
	}
	
	public void excluir(long id) {
		produtoDAO.excluir(id);
		produtos = produtoDAO.buscarTodos();
		
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
}
