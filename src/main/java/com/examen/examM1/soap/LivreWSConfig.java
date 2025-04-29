package com.examen.examM1.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class LivreWSConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "livres")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema livresSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("LivresPort");
        definition.setLocationUri("/ws");
        definition.setTargetNamespace("http://examen.com/examM1/soap");
        definition.setSchema(livresSchema);
        return definition;
    }

    @Bean
    public XsdSchema livresSchema() {
        return new SimpleXsdSchema(new org.springframework.core.io.ClassPathResource("livres.xsd"));
    }
}
