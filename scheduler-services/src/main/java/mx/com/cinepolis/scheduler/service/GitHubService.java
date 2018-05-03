package mx.com.cinepolis.scheduler.service;

import mx.com.cinepolis.scheduler.commons.to.GitHubUserTO;
import mx.com.cinepolis.scheduler.commons.to.LoginTO;

public interface GitHubService {
	
	GitHubUserTO getGitHubUser(String login);


	LoginTO getLoginSucces(String usuario, String password);
	
	
	GitHubUserTO postExample(GitHubUserTO gitHubUserTO);
}
