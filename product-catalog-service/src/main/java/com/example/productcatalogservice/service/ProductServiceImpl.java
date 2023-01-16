package com.example.productcatalogservice.service;

import com.example.productcatalogservice.configuration.EnvironmentConfiguration;
import com.example.productcatalogservice.dto.CreateOneProductDto;
import com.example.productcatalogservice.dto.GetOneProductByIdDto;
import com.example.productcatalogservice.exception.CreateOneProductException;
import com.example.productcatalogservice.exception.GetOneProductByIdException;
import com.example.productcatalogservice.entity.ProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Objects;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService {
    @Autowired
    private Environment environment;

    @Autowired
    private EnvironmentConfiguration environmentConfiguration;

    @Value("${pom.version}")
    private String pomVersion;

    @Override
    public Mono<GetOneProductByIdDto.Response> getOneProductById(long id) {
        return Mono.justOrEmpty(id)
                .filter(request -> Objects.nonNull(request))
                .switchIfEmpty(Mono.error(new GetOneProductByIdException(new Throwable("id is invalid"))))
                //.map(Request::getId)
                .flatMap(requestId -> {
                    //iFriendRepository.findEmail1ByEmail2(inputEmail);
                    return Mono.just(ProductEntity.builder().id(1L).productName("laptop").price(BigDecimal.ZERO).description("note").category("tech").availability(1).build());
                })
                .map(productEntity -> GetOneProductByIdDto.Response.builder().success(true).data(productEntity).message("found success").port(environment.getProperty("local.server.port")).build());
    }

    @Override
    public Mono<CreateOneProductDto.Response> createOneProduct(CreateOneProductDto.Request request) {
        return Mono.justOrEmpty(request)
                .filter(req -> Objects.nonNull(req))
                .switchIfEmpty(Mono.error(new CreateOneProductException(new Throwable("request body is invalid"))))
                .flatMap(req -> {
                    log.info("{}", req);
                    return Mono.just(ProductEntity.builder().id(1L).productName(req.getProductName()).price(req.getPrice()).description(req.getDescription()).category(req.getCategory()).availability(req.getAvailability()).build());
                })
                .map(productEntity -> {
                    String env = environmentConfiguration.getEnv();
                    String hostName = environment.getProperty("HOSTNAME");
                    String serviceHost = environment.getProperty("PRODUCT_CATALOG_SERVICE_SERVICE_HOST");
                    String port = environment.getProperty("local.server.port");
                    return CreateOneProductDto.Response.builder().success(true).data(productEntity).message(String.format("created success in env %s and hostName is %s and serviceHost is %s and port is %s and pom version is %s", env, hostName, serviceHost, port, pomVersion)).port(port).build();
                });
    }
}
