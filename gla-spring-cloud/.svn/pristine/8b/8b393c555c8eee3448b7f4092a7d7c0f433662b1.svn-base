package com.gla.datacenter.utils;

import com.gla.datacenter.model.GatewayPredicateDefinition;
import com.gla.datacenter.model.GatewayRouteDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/12/3 15:40
 */
public class RouterUtil {
    public static void main(String[] args) {
        System.out.println(getUtcTime());

    }
    public static   String getUtcTime (){
        ZonedDateTime time=  ZonedDateTime.now();
        System.out.println("zonedDateTime:"+time);

        String  maxTime=ZonedDateTime.now().plusHours(1).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
        System.out.println("maxTime："+maxTime);

        String  minTime=ZonedDateTime.now().minusHours(1).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
        System.out.println("minTime:"+minTime);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String str=time.format(formatter);
       return   str;
    }


    public static RouteDefinition assembleRouteDefinition(GatewayRouteDefinition gwdefinition) {
        RouteDefinition definition = new RouteDefinition();
        List<PredicateDefinition> pdList=new ArrayList<>();
        definition.setId(gwdefinition.getId());
        List<GatewayPredicateDefinition> gatewayPredicateDefinitionList=gwdefinition.getPredicates();
        for (GatewayPredicateDefinition gpDefinition: gatewayPredicateDefinitionList) {
            PredicateDefinition predicate = new PredicateDefinition();
            predicate.setArgs(gpDefinition.getArgs());
            predicate.setName(gpDefinition.getName());
            pdList.add(predicate);
        }
        definition.setPredicates(pdList);
        URI uri = UriComponentsBuilder.fromHttpUrl(gwdefinition.getUri()).build().toUri();
        definition.setUri(uri);
        return definition;
    }

}
