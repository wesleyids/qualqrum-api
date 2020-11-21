package br.com.qualqrum.api.service;

import br.com.qualqrum.api.annotation.Info;
import br.com.qualqrum.api.dto.PathResponseDTO;
import br.com.qualqrum.api.resource.GeneratorResource;
import br.com.qualqrum.api.resource.PessoaFisicaResource;
import br.com.qualqrum.api.resource.ValidatorResource;
import br.com.qualqrum.api.resource.PessoaJuridicaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoaderService {

    @Autowired
    private ApplicationContext applicationContext;

    private static List<PathResponseDTO> paths = new ArrayList<>();

    private String getPathContext() {

        int port = applicationContext.getBean(Environment.class).getProperty("server.port", Integer.class, 8080);

        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            String name = applicationContext.getApplicationName();
            return String.format("http://%s:%s%s", ip, port, (name != "" || name != null ? name : ""));
        } catch (UnknownHostException e) {
            return String.format("http://localhost:%s", port);
        }
    }

    @Bean
    public void config() {

        String pathContext = getPathContext();

        List<Class> classes = new ArrayList<>();
        classes.add(GeneratorResource.class);
        classes.add(PessoaFisicaResource.class);
        classes.add(PessoaJuridicaResource.class);
        classes.add(ValidatorResource.class);

        for (Class clazz : classes) {

            String path = "";

            for (Annotation annotation : clazz.getAnnotations()) {
                if (annotation instanceof RequestMapping) {
                    path = ((RequestMapping) annotation).value()[0];
                }
            }

            Method[] methods = clazz.getMethods();
            for (Method method : methods) {

                Info info = method.getAnnotation(Info.class);
                if (info != null) {

                    String description = info.description();
                    String fullpath = pathContext.concat(path.concat(info.path()));
                    String[] params = info.params();

                    paths.add(new PathResponseDTO(description, fullpath, params));
                }
            }
        }

    }

    public static List<PathResponseDTO> getPaths() {
        return paths;
    }
}
