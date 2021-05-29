package com.cuemby.demo.main;

import com.cuemby.demo.core.repositories.PlayerRepository;
import com.cuemby.demo.core.service.PlayerService;
import com.cuemby.demo.core.service.PlayerServiceBase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationFactory {

   /* @Bean
    public PlayerRepository repositoryPlayer(PlayerRepositoryJpa repositoryJPA) {
        return new PlayerRepositoryJpaBase(repositoryJPA);
    }*/

    @Bean
    public PlayerService productService(PlayerRepository repository) {
        return new PlayerServiceBase(repository);
    }
}
