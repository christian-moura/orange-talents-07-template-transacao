package br.com.zup.transacoes.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/proposta")
public class TransacaoController {

    private TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TransacaoResponse>>buscarTransacoesPorIdCartao(@PathVariable("id") String id,
                                                                              @PageableDefault(sort = "efetivadaEm", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao){
        Page<Transacao> transacoes = transacaoRepository.findAllByCartaoId(id,paginacao);
        return ResponseEntity.ok(transacoes.get().map(TransacaoResponse::new).collect(Collectors.toList()));
    }
}
