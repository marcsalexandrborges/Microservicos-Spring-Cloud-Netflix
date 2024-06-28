package com.ms.pagamento.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ms.pagamento.entity.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;


@JsonPropertyOrder({"id", "data", "produtos", "valorTotal"})
public class ProdutoVO extends RepresentationModel<ProdutoVO> implements Serializable {

    private static final long serialVersionUID = 1267779852993967704L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("estoque")
    private Integer estoque;

    public ProdutoVO(){

    }

    public ProdutoVO(Long id, Integer estoque) {
        this.id = id;
        this.estoque = estoque;
    }

    public ProdutoVO(Iterable<Link> initialLinks, Long id, Integer estoque) {
        super(initialLinks);
        this.id = id;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "ProdutoVO{" +
                "id=" + id +
                ", estoque=" + estoque +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProdutoVO produtoVO = (ProdutoVO) o;
        return Objects.equals(id, produtoVO.id) && Objects.equals(estoque, produtoVO.estoque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, estoque);
    }

    public static ProdutoVO create (Produto produto){
        return new ModelMapper().map(produto, ProdutoVO.class);
    }
}
