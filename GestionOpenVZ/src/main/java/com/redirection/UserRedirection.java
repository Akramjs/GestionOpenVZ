package com.redirection;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@ManagedBean
public class UserRedirection {

	/* redirect to createContainer page */
	public void agentCreateContainerPage() {
		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						"/agent/createContainer.xhtml?faces-redirect=true");

	}
	/* redirect to create Custom Container page */
	public void agentCreateCustomContainerPage() {
		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						"/agent/createCustomContainer.xhtml?faces-redirect=true");

	}

	/* redirect to agent Container page */
	public void agentContainerPage() {
		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						"/agent/agentContainer.xhtml?faces-redirect=true");

	}
	/* redirect to agentProfile page */
	public void agentCustomContainerPage() {
		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						"/agent/agentCustomContainer.xhtml?faces-redirect=true");

	}
	/* redirect to agentProfile page */
	public void agentProfilePage() {
		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						"/agent/welcome.xhtml?faces-redirect=true");

	}

	/* redirect to CreateUser page */
	public void adminCreateUserPage() {
		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						"/admin/createUser.xhtml?faces-redirect=true");

	}

	/* redirect to adminProfile page */
	public void adminProfilePage() {
		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						"/admin/welcome.xhtml?faces-redirect=true");

	}
	/* redirect to adminContainer page */
	public void adminContainerPage() {
		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						"/admin/adminContainer.xhtml?faces-redirect=true");

	}
	/* redirect to adminContainer page */
	public void adminAllContainerPage() {
		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						"/admin/allContainer.xhtml?faces-redirect=true");

	}
	/* redirect to all Users page */
	public void adminAllUsersPage() {
		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						"/admin/allUser.xhtml?faces-redirect=true");

	}
	/* redirect to admin createContainer page */
	public void adminCreateContainerPage() {
		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						"/admin/createContainer.xhtml?faces-redirect=true");

	}
	/* redirect to admin validateContainer page */
	public void adminCustomContainerPage() {
		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						"/admin/adminCustomContainer.xhtml?faces-redirect=true");

	}
	/* redirect to 	admin create Custom Container page */
	public void adminManageCustomContainerPage() {
		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						"/admin/manageCustomContainer.xhtml?faces-redirect=true");

	}
	/* redirect to 	admin create Custom Container page */
	public void adminCreateCustomContainerPage() {
		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						"/admin/createCustomContainer.xhtml?faces-redirect=true");

	}

	public void logout() {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		new SecurityContextLogoutHandler().logout(request, null, null);
		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						"/login.xhtml?faces-redirect=true");

	}

}
