package com.examen.examM1.soap;

import com.examen.examM1.services.LivreService;
import com.examen.examM1.entities.Livre;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class LivreEndpoint {

    private static final String NAMESPACE_URI = "http://examen.com/examM1/soap";

    private final LivreService livreService;

    public LivreEndpoint(LivreService livreService) {
        this.livreService = livreService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLivresDisponiblesRequest")
    @ResponsePayload
    public LivreListResponse getLivresDisponibles() {
        List<Livre> livresDisponibles = livreService.getLivresDisponibles();
        List<LivreSoapDTO> livreDtos = livresDisponibles.stream()
                .map(l -> new LivreSoapDTO(l.getId(), l.getTitre(), l.getAuteur()))
                .collect(Collectors.toList());

        LivreListResponse response = new LivreListResponse();
        response.setLivres(livreDtos);
        return response;
    }
}
