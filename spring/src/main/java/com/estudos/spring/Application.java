package com.estudos.spring;

import com.estudos.spring.domain.*;
import com.estudos.spring.domain.enums.EstadoPagamento;
import com.estudos.spring.domain.enums.TipoCliente;
import com.estudos.spring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CategoriaRepository catRepo;
    @Autowired
    private ProdutoRepository prodRepo;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//	 	Only use with H2 database (temporary data)
        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Impressora", 800.00);
        Produto p2 = new Produto(null, "Mouse", 300.00);
        Produto p3 = new Produto(null, "Teclado", 150.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p1));

        p1.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p2.getCategorias().addAll(Arrays.asList(cat1));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        catRepo.saveAll(Arrays.asList(cat1, cat2));
        prodRepo.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Espírito Santo", "ES");

        Cidade cid1 = new Cidade(null, "Alegre", est1);

        Cliente cli1 = new Cliente(null, "maycon douglas", "maycondss@live.com", "45852336859", TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("+551530313161", "+556230343312"));

        Endereco end1 = new Endereco(null, "Rua sei la das quantas", "300", null, "Jardiam", "3856125", cli1, cid1);
        Endereco end2 = new Endereco(null, "Rua sei la dasaaaaaa quantas", "300s", null, "Jardim", "3856125", cli1, cid1);

        cli1.getEnderecos().addAll(Arrays.asList(end1, end2));

        estadoRepository.saveAll(Arrays.asList(est1));
        cidadeRepository.saveAll(Arrays.asList(cid1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(end1, end2));

        Pedido ped1 = new Pedido(null, sdt.parse("30/09/2022 10:20"), cli1, end1);
        Pagamento pag1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, ped1, 6);

        ped1.setPagamento(pag1);
        cli1.getPedidos().addAll(Arrays.asList(ped1));

        pedidoRepository.saveAll(Arrays.asList(ped1));
        pagamentoRepository.saveAll(Arrays.asList(pag1));

        ItemPedido ip1 = new ItemPedido(ped1, p1, 00.00, 1, 800.00);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 00.00, 2, 600.00);

        ped1.getItens().addAll(Arrays.asList(ip1, ip2));

        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2));

    }
}
