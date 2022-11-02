package com.company.gamestoreinvoicing.congig.util.feign;

import com.company.gamestoreinvoicing.model.Console;
import com.company.gamestoreinvoicing.model.Game;
import com.company.gamestoreinvoicing.model.TShirt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "gamestore-catalog")
public interface CatalogFeignClient {
    @RequestMapping(value = "/console/{id}", method = RequestMethod.GET)
    public Console findConsoleById(@PathVariable long id);

    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    public Game findGameById(@PathVariable long id);

    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.GET)
    public TShirt findTshirtById(@PathVariable long id);
}
