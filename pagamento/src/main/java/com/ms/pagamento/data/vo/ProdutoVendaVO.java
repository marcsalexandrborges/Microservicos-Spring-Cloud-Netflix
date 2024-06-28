package com.ms.pagamento.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ms.pagamento.entity.Produto;
import com.ms.pagamento.entity.ProdutoVenda;
import com.ms.pagamento.entity.Venda;
import javax.persistence.*;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id", "idProduto", "quantidade"})
public class ProdutoVendaVO extends RepresentationModel<ProdutoVendaVO> implements Serializable {

    private static final long serialVersionUID = 3367917912510630888L;


    @JsonProperty("id")
    private Long id;

    @JsonProperty("idProduto")
    private Long idProduto;

    @JsonProperty("quantidade")
    private Integer quantidade;

    public ProdutoVendaVO(){

    }

    public ProdutoVendaVO(Long id, Long idProduto, Integer quantidade) {
        this.id = id;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public ProdutoVendaVO(Iterable<Link> initialLinks, Long id, Long idProduto, Integer quantidade) {
        super(initialLinks);
        this.id = id;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ProdutoVendaVO{" +
                "id=" + id +
                ", idProduto=" + idProduto +
                ", quantidade=" + quantidade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProdutoVendaVO that = (ProdutoVendaVO) o;
        return Objects.equals(id, that.id) && Objects.equals(idProduto, that.idProduto) && Objects.equals(quantidade, that.quantidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, idProduto, quantidade);
    }

    public static ProdutoVendaVO create (ProdutoVenda produtoVenda){
        return new ModelMapper().map(produtoVenda, ProdutoVendaVO.class);
    }

}
