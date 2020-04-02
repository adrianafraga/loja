package com.qintess.projetohibernate.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda implements EntidadeBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "cliente_id")
	private int idCliente;

	@Column(name = "desconto")
	private int desconto;

	@Column(name = "forma_pagamento")
	private int formaPagamento;

	@Column(name = "data")
	private Timestamp data;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "venda_id")
	private List<VendaItens> vendaItens;

	public Venda() {
	}

	public Venda(Integer idCliente, int desconto, Integer formaPagamento, Timestamp data) {
		this.idCliente = idCliente;
		this.desconto = desconto;
		this.formaPagamento = formaPagamento;
		this.data = data;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public int getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(int formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public List<VendaItens> getVendaItens() {
		return vendaItens;
	}

	public void setVendaItens(List<VendaItens> vendaItens) {
		this.vendaItens = vendaItens;
	}

	public void addVendaItens(VendaItens vendaItens) {
		if (this.vendaItens == null) {
			this.vendaItens = new ArrayList<VendaItens>();
		}
		this.vendaItens.add(vendaItens);
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", idCliente=" + idCliente + ", desconto=" + desconto + ", formaPagamento="
				+ formaPagamento + ", data=" + data + "]";
	}
}
