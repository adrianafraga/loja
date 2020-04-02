package com.qintess.projetohibernate.executa;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.qintess.projetohibernate.dao.GenericDaoImpl;
import com.qintess.projetohibernate.model.Fornecedor;
import com.qintess.projetohibernate.model.FornecedorHasProduto;
import com.qintess.projetohibernate.model.FornecedorHasProdutoId;
import com.qintess.projetohibernate.model.Produto;
import com.qintess.projetohibernate.model.Venda;
import com.qintess.projetohibernate.model.VendaItens;

public class MainApp {
	public static void main(String[] args) {

		// acesso aos daos
		GenericDaoImpl<Fornecedor> fornecedorDAO = new GenericDaoImpl<>();
		GenericDaoImpl<Produto> produtoDAO = new GenericDaoImpl<>();
		GenericDaoImpl<FornecedorHasProduto> fornecedorHasProdutoDAO = new GenericDaoImpl<>();
		GenericDaoImpl<VendaItens> vendaItensDAO = new GenericDaoImpl<>();
		GenericDaoImpl<Venda> vendaDAO = new GenericDaoImpl<>();

		// criar fornecedores
		Fornecedor fornecedor1 = new Fornecedor("Samsung", "(11)44444-4444", "(11)99999-9999");
		Fornecedor fornecedor2 = new Fornecedor("LG", "(14)22222-2222", "(14)66666-6666");

		// salvando Fornecedores
		fornecedorDAO.salvar(fornecedor1);
		fornecedorDAO.salvar(fornecedor2);
		
		// criando produto para fornecedor 1
		Produto produto1 = new Produto(2500d, 5, "Galaxy S20");
		Produto produto2 = new Produto(6000d, 20, "Televisão 60' 4k");
		
		// criando produto para fornecedor 2
		Produto produto3 = new Produto(1800d, 12, "LG Q6");
		Produto produto4 = new Produto(12000, 3, "televisão 80' 4k");
		
		//salvando produtos
		produtoDAO.salvar(produto1);
		produtoDAO.salvar(produto2);
		produtoDAO.salvar(produto3);
		produtoDAO.salvar(produto4);
		
		// pegando produtos e fornecedores do banco
		Produto produtoSalvo1 = produtoDAO.buscarPorId(Produto.class, 1);
		Produto produtoSalvo2 = produtoDAO.buscarPorId(Produto.class, 2);
		Produto produtoSalvo3 = produtoDAO.buscarPorId(Produto.class, 3);
		Produto produtoSalvo4 = produtoDAO.buscarPorId(Produto.class, 4);
		
		// pegando fornecedores do banco
		Fornecedor fornecedorSalvo1 = fornecedorDAO.buscarPorId(Fornecedor.class, 1);
		Fornecedor fornecedorSalvo2 = fornecedorDAO.buscarPorId(Fornecedor.class, 2);
		
		// vinculando os produtos com o fornecedor
		FornecedorHasProduto fornecedorHasProduto1 = new FornecedorHasProduto();
		FornecedorHasProduto fornecedorHasProduto2 = new FornecedorHasProduto();
		FornecedorHasProduto fornecedorHasProduto3 = new FornecedorHasProduto();
		FornecedorHasProduto fornecedorHasProduto4 = new FornecedorHasProduto();
		fornecedorHasProduto1.setId(new FornecedorHasProdutoId(fornecedorSalvo1, produtoSalvo1));
		fornecedorHasProduto2.setId(new FornecedorHasProdutoId(fornecedorSalvo1, produtoSalvo2));
		fornecedorHasProduto3.setId(new FornecedorHasProdutoId(fornecedorSalvo2, produtoSalvo3));
		fornecedorHasProduto4.setId(new FornecedorHasProdutoId(fornecedorSalvo2, produtoSalvo4));
		
		fornecedorHasProduto1.setEstoque(15);
		fornecedorHasProduto2.setEstoque(50);
		fornecedorHasProduto3.setEstoque(200);
		fornecedorHasProduto4.setEstoque(10);
		
		fornecedorHasProduto1.setPrecoCusto(2000d);
		fornecedorHasProduto2.setPrecoCusto(4600d);
		fornecedorHasProduto3.setPrecoCusto(1200d);
		fornecedorHasProduto4.setPrecoCusto(7500d);
		
		// salvando vinculo
		fornecedorHasProdutoDAO.salvar(fornecedorHasProduto1);
		fornecedorHasProdutoDAO.salvar(fornecedorHasProduto2);
		fornecedorHasProdutoDAO.salvar(fornecedorHasProduto3);
		fornecedorHasProdutoDAO.salvar(fornecedorHasProduto4);
		
		// criando venda
		Venda venda1 = new Venda(1, 2, 1, Timestamp.valueOf(LocalDateTime.now()));
		Venda venda2 = new Venda(2, 5, 2, Timestamp.valueOf(LocalDateTime.now()));
		
		// salvando venda
		vendaDAO.salvar(venda1);
		vendaDAO.salvar(venda2);
		
		// pegando venda do banco
		Venda vendaSalva1 = vendaDAO.buscarPorId(Venda.class, 1);
		Venda vendaSalva2 = vendaDAO.buscarPorId(Venda.class, 2);
		
		// itens para venda
		VendaItens vendaItens1 = new VendaItens(produtoSalvo1, vendaSalva1, 2, fornecedorHasProduto1.getPrecoCusto(), produtoSalvo1.getPrecoVenda());
		VendaItens vendaItens2 = new VendaItens(produtoSalvo2, vendaSalva2, 5, fornecedorHasProduto2.getPrecoCusto(), produtoSalvo2.getPrecoVenda());
		VendaItens vendaItens3 = new VendaItens(produtoSalvo3, vendaSalva1, 6, fornecedorHasProduto3.getPrecoCusto(), produtoSalvo3.getPrecoVenda());
		VendaItens vendaItens4 = new VendaItens(produtoSalvo3, vendaSalva2, 1, fornecedorHasProduto3.getPrecoCusto(), produtoSalvo3.getPrecoVenda());
		
		// salvando venda itens
		vendaItensDAO.salvar(vendaItens1);
		vendaItensDAO.salvar(vendaItens2);
		vendaItensDAO.salvar(vendaItens3);
		vendaItensDAO.salvar(vendaItens4);
		
		// printando fornecedores
		
		for(FornecedorHasProduto f : fornecedorHasProdutoDAO.buscarTodos(FornecedorHasProduto.class)) {
			System.out.println("\n\n");
			System.out.println(f.getId().getFornecedor());
			System.out.println(f.getId().getProduto());
			System.out.println("\n\n");
		}
		
		// printando vendas
		
		for(Venda v : vendaDAO.buscarTodos(Venda.class)) {
			System.out.println("\n\n");
			System.out.println(v);
			System.out.println(v.getVendaItens());
			System.out.println("\n\n");
		}
	}
}
