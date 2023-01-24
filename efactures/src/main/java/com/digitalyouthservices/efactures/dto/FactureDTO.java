package com.digitalyouthservices.efactures.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class FactureDTO {
    private Long id;

    private Long factureNumber;

    private LocalDate dateEmission;
    private ClientDTO client;
    private List<ArticleDTO> articles;
    private Double total;
    private MeDTO me;

    public FactureDTO(Long id, Long factureNumber, LocalDate dateEmission, ClientDTO client, List<ArticleDTO> articles, Double total, MeDTO me) {
        this.id = id;
        this.factureNumber = factureNumber;
        this.dateEmission = dateEmission;
        this.client = client;
        this.articles = articles;
        this.total = total;
        this.me = me;
    }

    public FactureDTO() {
    }
}
