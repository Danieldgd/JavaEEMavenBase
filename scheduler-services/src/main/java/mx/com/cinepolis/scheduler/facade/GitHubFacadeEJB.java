package mx.com.cinepolis.scheduler.facade;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import mx.com.cinepolis.scheduler.commons.to.GitHubUserTO;
import mx.com.cinepolis.scheduler.commons.to.LoginTO;
import mx.com.cinepolis.scheduler.service.GitHubService;

@Stateless
@LocalBean
public class GitHubFacadeEJB {
	
	@Inject
	GitHubService gitHubService;
	
	public GitHubUserTO getGitUser(String login) {
		return gitHubService.getGitHubUser(login);
	}
	
	public LoginTO getLogTrue(String usuario,String password) {
		return gitHubService.getLoginSucces(usuario, password);
	}

	public GitHubUserTO postGt(GitHubUserTO gitHubUserTO) {
		return gitHubService.postExample(gitHubUserTO);
	}
}
