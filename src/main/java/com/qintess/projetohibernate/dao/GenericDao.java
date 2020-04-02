package com.qintess.projetohibernate.dao;

import java.util.List;

public interface GenericDao<T> {

	public void salvar(T item);
	
	public T buscarPorId(Class<T> clazz,Object id);
	
	public List<T> buscarTodos(Class<T> clazz);
	
	public void deletar(Class<T> clazz, Object id);
	
}
