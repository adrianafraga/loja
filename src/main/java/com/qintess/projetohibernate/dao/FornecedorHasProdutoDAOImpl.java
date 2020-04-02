package com.qintess.projetohibernate.dao;

import org.hibernate.Session;

import com.qintess.projetohibernate.model.Fornecedor;
import com.qintess.projetohibernate.model.FornecedorHasProduto;
import com.qintess.projetohibernate.model.FornecedorHasProdutoId;
import com.qintess.projetohibernate.model.Produto;
import com.qintess.projetohibernate.util.HibernateUtil;

public class FornecedorHasProdutoDAOImpl {

	public FornecedorHasProduto getByCompositeId(Integer idFornecedor, Integer idProduto) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Fornecedor fornecedor = session.find(Fornecedor.class, idFornecedor);
			Produto produto = session.find(Produto.class, idProduto);
			return session.find(FornecedorHasProduto.class, new FornecedorHasProdutoId(fornecedor, produto));
		}
	}
	
}
