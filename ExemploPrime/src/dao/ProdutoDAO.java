package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import banco.Fabrica;
import modelo.Produto;

public class ProdutoDAO {

	private EntityManager manager;
	private EntityTransaction t;

	public Produto salvar(Produto produto) {

		manager = Fabrica.get().createEntityManager();
		t = manager.getTransaction();

		try {
			t.begin();// Inicia transação
			manager.persist(produto); //
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();//
		} finally {
			manager.close();
		}
		return produto;
	}

	public Produto alterar(Produto produto) {

		manager = Fabrica.get().createEntityManager();
		t = manager.getTransaction();

		try {
			t.begin();
			manager.merge(produto);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return produto;
	}

	public boolean excluir(Long id) {

		manager = Fabrica.get().createEntityManager();
		t = manager.getTransaction();

		try {
			Produto produto = manager.find(Produto.class, id);
			if (produto != null) {
				t.begin();
				manager.remove(produto);
				t.commit();
				return true;
			}
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();

		} finally {
			manager.close();
		}
		return false;
	}

	public Produto buscar(long id) {
		manager = Fabrica.get().createEntityManager();
		return manager.find(Produto.class, id);

	}
	public List<Produto> buscarTodos() {
		manager = Fabrica.get().createEntityManager();

		try {
			return manager.createQuery("from Produto").getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		} finally {
			manager.close();
		}
	}

}
