package com.ms.pagamento.config;

import com.ms.pagamento.data.vo.ProdutoVO;
import com.ms.pagamento.entity.Produto;
import com.ms.pagamento.repository.ProdutoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProdutoReceiveMessage {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoReceiveMessage(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @RabbitListener(queues = {"${crud.rabbitmq.queue}"})
    public void receive (@Payload ProdutoVO produtoVO){
        produtoRepository.save(Produto.create(produtoVO));

    }
}
