package ServidorApresentacao.Action.sop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.action.DynaActionFormClass;
import org.apache.struts.config.FormBeanConfig;
import org.apache.struts.config.ModuleConfig;

import DataBeans.InfoRoom;
import DataBeans.RoomKey;
import ServidorAplicacao.GestorServicos;
import ServidorAplicacao.IUserView;
import ServidorAplicacao.Servico.exceptions.notAuthorizedServiceDeleteException;
import ServidorApresentacao.Action.exceptions.FenixActionException;
import ServidorApresentacao.Action.exceptions.notAuthorizedActionDeleteException;
import ServidorApresentacao.Action.sop.base.FenixSelectedRoomsContextAction;
import ServidorApresentacao.Action.sop.utils.SessionConstants;
import ServidorApresentacao.Action.sop.utils.Util;

/**
 * @author Nuno Ant�o
 * @author Jo�o Pereira
 **/

public class ManipularSalasAction extends FenixSelectedRoomsContextAction {

	/**
	 * Executes the selected action, depending on the pressed button.
	 * The action depends on the value of the "operation" parameter.
	 * It can be prepare the information about the selected sala, to show
	 * or edit it, or delete the selected sala.
	 **/
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		String parameter = request.getParameter("operation");

		if (parameter.equals("Ver Sala")) {
			return prepararVerSala(mapping, form, request, response);
		}
		if (parameter.equals("Editar Sala")) {
			return prepararEditarSala(mapping, form, request, response);
		}
		if (parameter.equals("Apagar Sala")) {
			return apagarSala(mapping, form, request, response);
		}

		return (mapping.findForward("Voltar"));
	}

	/**
	 * Prepares the right information about the selected sala so that it
	 * can be shown to the user. Places a java bean object with
	 * information about the selected sala in the attribute
	 * "salaFormBean" of the session and fowards to the mapping
	 * "VerSala".
	 **/
	public ActionForward prepararVerSala(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		super.execute(mapping, form, request, response);
		
		HttpSession session = getSession(request);
		request.removeAttribute(mapping.getAttribute());		

		DynaActionForm posicaoSalaFormBean = (DynaActionForm) form;
		Integer index = (Integer) posicaoSalaFormBean.get("index");
		request.setAttribute("selectedRoomIndex",index);

		// Reset indexForm value
		DynaActionForm selectRoomIndexForm = (DynaActionForm) form;
		selectRoomIndexForm.set("index",null);	
			
		return (mapping.findForward("VerSala"));
	}

	/**
	 * Prepares the information about the selected sala so that it can
	 * be shown to the user. Places a java bean object with information
	 * about the selected sala in the attribute "salaFormBean" of the
	 * session and forwards to the mapping "EditarSala".
	 **/
	public ActionForward prepararEditarSala(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		super.execute(mapping, form, request, response);			

		HttpSession session = getSession(request);

		InfoRoom salaBean = getSelectedSala(form, request);
		
		DynaActionForm posicaoSalaFormBean = (DynaActionForm) form;
		Integer index = (Integer) posicaoSalaFormBean.get("index");
		request.setAttribute(SessionConstants.SELECTED_ROOM_INDEX,index);	
			
		List edificios = Util.readExistingBuldings(null, null);
		List tipos = Util.readTypesOfRooms(null, null);

		request.setAttribute("publico.buildings", edificios);
		request.setAttribute("publico.types", tipos);

		// create the bean that holds the information about the sala to edit
		DynaActionFormClass cl;
		ModuleConfig moduleConfig = (ModuleConfig) mapping.getModuleConfig();
		FormBeanConfig formBeanConfig =
			moduleConfig.findFormBeanConfig("roomForm");
		cl = DynaActionFormClass.createDynaActionFormClass(formBeanConfig);
		DynaActionForm criarSalaForm = (DynaActionForm) cl.newInstance();
		criarSalaForm.set("name", salaBean.getNome());
		criarSalaForm.set("building", salaBean.getEdificio());
		criarSalaForm.set("floor",String.valueOf(salaBean.getPiso().intValue()));
		criarSalaForm.set("type", String.valueOf(salaBean.getTipo().getTipo()));
		criarSalaForm.set("capacityNormal",	String.valueOf(salaBean.getCapacidadeNormal()));
		criarSalaForm.set("capacityExame", String.valueOf(salaBean.getCapacidadeExame()));
		request.setAttribute("criarSalaForm", criarSalaForm);

		// Reset indexForm value
		DynaActionForm selectRoomIndexForm = (DynaActionForm) form;
		selectRoomIndexForm.set("index",null);		

		return (mapping.findForward("EditarSala"));
	}

	/**
	 * Removes the selected sala from the database used by the application.
	 **/
	public ActionForward apagarSala(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		super.execute(mapping, form, request, response);
		
		HttpSession session = getSession(request);
		IUserView userView = (IUserView) session.getAttribute("UserView");
	
		ArrayList listaSalasBean = (ArrayList) request.getAttribute(SessionConstants.SELECTED_ROOMS);
		InfoRoom selectedSala = getSelectedSala(form, request);

		Object argsCriarSala[] = { new RoomKey(selectedSala.getNome())};
		try {
			GestorServicos.manager().executar(
				userView,
				"ApagarSala",
				argsCriarSala);
		} catch (notAuthorizedServiceDeleteException e) {
			Object[] values = { "a sala", "as aulas" };
			throw new notAuthorizedActionDeleteException(
				"errors.invalid.delete.with.objects",
				values);
		}

		// Reset indexForm value
		DynaActionForm selectRoomIndexForm = (DynaActionForm) form;
		selectRoomIndexForm.set("index",null);
		
		// Update selectedRooms in request
		listaSalasBean.remove(selectedSala);
		request.removeAttribute(mapping.getAttribute());
		if (listaSalasBean.isEmpty()) {
			request.removeAttribute(SessionConstants.SELECTED_ROOMS);
		} else {
			request.setAttribute(SessionConstants.SELECTED_ROOMS, listaSalasBean);
		}


		return mapping.findForward("SalaApagada");
	}

	/**
	 * @returns the name of the selected sala.
	 **/
	private InfoRoom getSelectedSala(
		ActionForm form,
		HttpServletRequest request)
		throws FenixActionException {

		DynaActionForm posicaoSalaFormBean = (DynaActionForm) form;
		Integer salaSelecionada = (Integer) posicaoSalaFormBean.get("index");
		//System.out.println("getSelectedSala: "+salaSelecionada);

		List listaSalasBean = (List) request.getAttribute(SessionConstants.SELECTED_ROOMS);

		InfoRoom sala = null;
		if (listaSalasBean != null && !listaSalasBean.isEmpty()) {
			Collections.sort(listaSalasBean);
			sala = (InfoRoom) listaSalasBean.get(salaSelecionada.intValue());
		}
		else {
			System.out.println("ERROR: Missing lista de salas em request!!");
		}
		return sala; 
	}

}
