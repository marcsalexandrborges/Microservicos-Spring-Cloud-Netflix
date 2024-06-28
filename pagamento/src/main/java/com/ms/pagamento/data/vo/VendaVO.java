package com.ms.pagamento.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ms.pagamento.entity.ProdutoVenda;
import com.ms.pagamento.entity.Venda;
import javax.persistence.*;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({"id", "data", "produtos", "valorTotal"})
public class VendaVO extends RepresentationModel <VendaVO> implements Serializable {

    private static final long serialVersionUID = -6241645904453731517L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("data")
    private Date data;

    @JsonProperty("produtos")
    private List<ProdutoVendaVO> produtos;

    @JsonProperty("valorTotal")
    private Double valorTotal;

    public VendaVO() {
    }

    public VendaVO(Long id, Date data, List<ProdutoVendaVO> produtos, Double valorTotal) {
        this.id = id;
        this.data = data;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public VendaVO(Iterable<Link> initialLinks, Long id, Date data, List<ProdutoVendaVO> produtos, Double valorTotal) {
        super(initialLinks);
        this.id = id;
        this.data = data;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ProdutoVendaVO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoVendaVO> produtos) {
        this.produtos = produtos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "VendaVO{" +
                "id=" + id +
                ", data=" + data +
                ", produtos=" + produtos +
                ", valorTotal=" + valorTotal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VendaVO vendaVO = (VendaVO) o;
        return Objects.equals(id, vendaVO.id) && Objects.equals(data, vendaVO.data) && Objects.equals(produtos, vendaVO.produtos) && Objects.equals(valorTotal, vendaVO.valorTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, data, produtos, valorTotal);
    }

    public static VendaVO create(Venda venda) {
        return new ModelMapper().map(venda, VendaVO.class);
    }
}
