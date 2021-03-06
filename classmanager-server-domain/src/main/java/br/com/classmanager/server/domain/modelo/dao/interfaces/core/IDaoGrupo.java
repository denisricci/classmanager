package br.com.classmanager.server.domain.modelo.dao.interfaces.core;

import java.util.List;

import br.com.classmanager.client.entidades.core.Grupo;
import br.com.classmanager.client.exceptions.ClassManagerException;
import br.com.classmanager.server.domain.modelo.dao.def.interfaces.IDaoCRUD;

public interface IDaoGrupo extends IDaoCRUD<Grupo, Long> {

	public List<Grupo> pesquisarGrupoAtivoPorUsuario(Long idUsuario)
			throws ClassManagerException;

}
