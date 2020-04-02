package com.qintess.projetohibernate.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor_has_produto")
public class FornecedorHasProduto implements EntidadeBase {

	@EmbeddedId
	private FornecedorHasProdutoId id;

	@Column(name = "estoque")
	private int estoque;

	@Column(name = "preco_custo")
	private double precoCusto;

	public FornecedorHasProduto() {
	}

	public FornecedorHasProdutoId getId() {
		return id;
	}

	public void setId(FornecedorHasProdutoId id) {
		this.id = id;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + estoque;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precoCusto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FornecedorHasProduto other = (FornecedorHasProduto) obj;
		if (estoque != other.estoque)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(precoCusto) != Double.doubleToLongBits(other.precoCusto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FornecedorHasProduto [id=" + id + ", estoque=" + estoque + ", precoCusto=" + precoCusto + "]";
	}

}
