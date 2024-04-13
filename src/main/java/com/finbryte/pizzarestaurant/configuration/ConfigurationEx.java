package com.finbryte.pizzarestaurant.configuration;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages="com.finbryte.pizzarestaurant.configuration")
public class ConfigurationEx {

    @Bean(name="address1")
   // @Primary
    public Address getAddress(){
        return new Address("Vistosha",12);
    }
    @Bean(name="address2")
    public Address getAddress2(){
       return  new Address("Shishman",12);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ConfigurationEx.class);
        ManagerService service = context.getBean(ManagerService.class);
        Manager manager = service.getManager();
        System.out.println(manager.getManagerName());

        Company company = context.getBean(Company.class);
        Address address = company.getAddress();
        System.out.println(address);
    }
}
