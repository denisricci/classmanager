package br.com.classmanager.core.service.core;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.classmanager.client.dto.action.core.BanirUsuarioGrupoAction;
import br.com.classmanager.client.dto.core.UsuarioGrupoStatus;
import br.com.classmanager.client.dto.geral.NullDTO;
import br.com.classmanager.client.entidades.core.UsuarioGrupo;
import br.com.classmanager.client.entidades.enums.StatusUsuarioGrupo;
import br.com.classmanager.client.exceptions.ClassManagerException;
import br.com.classmanager.server.domain.modelo.dao.def.DAO;
import br.com.classmanager.server.domain.modelo.dao.interfaces.core.IDaoUsuarioGrupo;
import br.com.classmanager.server.domain.service.Servico;

@Named("BanirUsuarioGrupoAction")
public class BanirUsuarioGrupoService extends
		Servico<BanirUsuarioGrupoAction, NullDTO> {

	@Inject
	@DAO
	private IDaoUsuarioGrupo daoUsuarioGrupo;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public NullDTO execute(BanirUsuarioGrupoAction request)
			throws ClassManagerException {

		for (UsuarioGrupoStatus exclusao : request.getListaUsuarios()) {
			UsuarioGrupo usuarioGrupo = daoUsuarioGrupo.pesquisar(exclusao
					.getIdUsuarioGrupo());
			usuarioGrupo.setStatus(StatusUsuarioGrupo.BANIDO);
			daoUsuarioGrupo.alterar(usuarioGrupo);
		}

		return new NullDTO();
	}

}
