package org.superbiz.struts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean<SiteMeshFilter> sitemesh() {
        FilterRegistrationBean<SiteMeshFilter> filterRegBean = new FilterRegistrationBean<>();
        filterRegBean.setFilter(new SiteMeshFilter());
        filterRegBean.addUrlPatterns("/*");
      //  filterRegBean.setOrder(Ordered.LOWEST_PRECEDENCE -2);
        return filterRegBean;
    }

    @Bean
    public FilterRegistrationBean<StrutsPrepareAndExecuteFilter> struts2() {
        FilterRegistrationBean<StrutsPrepareAndExecuteFilter> filterRegBean = new FilterRegistrationBean<>();
        filterRegBean.setFilter(new StrutsPrepareAndExecuteFilter());
        filterRegBean.addUrlPatterns("/*");
        Map<String,String> map = new HashMap<String,String>();
        map.put("actionPackages","com.lq");
        filterRegBean.setInitParameters(map);
        return filterRegBean;
    }
}

