package mx.com.cinepolis.scheduler.service.impl;

import mx.com.cinepolis.scheduler.commons.to.GitHubUserTO;
import mx.com.cinepolis.scheduler.commons.to.LoginTO;
import mx.com.cinepolis.scheduler.service.GitHubService;

public class GitHubServiceImpl implements GitHubService {

	@Override
	public GitHubUserTO getGitHubUser(String login) {
	
	GitHubUserTO gitHubUserTO=new GitHubUserTO();
	if(login.equals("Dan95")) {
		gitHubUserTO.setLogin(login);
		gitHubUserTO.setNombre("Daniel");
		gitHubUserTO.setUrl("http://icons.iconarchive.com/icons/paomedia/small-n-flat/512/user-male-icon.png");
		gitHubUserTO.setFollowers(1);
		gitHubUserTO.setFollowing(5);
	}else if(login.equals("Jos30")) {
		gitHubUserTO.setLogin(login);
		gitHubUserTO.setNombre("Jose");
		gitHubUserTO.setUrl("https://thumbs.dreamstime.com/b/icono-del-var%C3%B3n-del-usuario-ninguna-cara-43652345.jpg");
		gitHubUserTO.setFollowers(2);
		gitHubUserTO.setFollowing(3);
	}
	return gitHubUserTO;
	}
	
	@Override
	public LoginTO getLoginSucces(String usuario,String password) {
		LoginTO loginTO=new LoginTO();

		if(usuario.equals("Danieldgd")&&password.equals("1234")) {
			loginTO.setPassword(password);
			loginTO.setUsuario(usuario);
			
		}else {
			loginTO.setUsuario("Usuario incorrecto");
			loginTO.setPassword("Password incorrecto");
		}
		return loginTO;
		
	}

	@Override
	public GitHubUserTO postExample(GitHubUserTO gitHubUserTO) {
		GitHubUserTO gtuser=new GitHubUserTO();
		gtuser.setLogin(gitHubUserTO.getLogin());
		gtuser.setNombre(gitHubUserTO.getNombre());
		gtuser.setUrl(gitHubUserTO.getUrl());
		gtuser.setFollowers(gitHubUserTO.getFollowers());
		gtuser.setFollowing(gitHubUserTO.getFollowing());
		
		return gtuser;
	}
}
