package com.qintess.projetohibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "vendaItens")
@Table(name = "venda_itens")
public class VendaItens implements EntidadeBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER,  cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "venda_id")
	private Venda venda;

	@Column(name = "quantidade")
	private int quantidade;

	@Column(name = "preco_custo")
	private double precoCusto;

	@Column(name = "preco_unit")
	private double precoUnit;

	public VendaItens() {
	}

	public VendaItens(Produto produto, Venda venda, int quantidade, double precoCusto, double precoUnit) {
		this.produto = produto;
		this.venda = venda;
		this.quantidade = quantidade;
		this.precoCusto = precoCusto;
		this.precoUnit = precoUnit;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public double getPrecoUnit() {
		return precoUnit;
	}

	public void setPrecoUnit(double precoUnit) {
		this.precoUnit = precoUnit;
	}

	@Override
	public String toString() {
		return "VendaItens [id=" + id + ", quantidade=" + quantidade + ", precoCusto=" + precoCusto + ", precoUnit="
				+ precoUnit + "]";
	}

}
