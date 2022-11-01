package com.company.gamestoreinvoicing.congig.util.feign;

import com.company.gamestoreinvoicing.model.Console;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "gamestore-catalog")
public interface CatalogFeignClient {
    @RequestMapping(value = "/console/{id}", method = RequestMethod.GET)
    public Console getConsoleById(long id);

}
