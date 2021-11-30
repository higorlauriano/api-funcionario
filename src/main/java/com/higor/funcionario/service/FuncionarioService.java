package com.higor.funcionario.service;

import com.higor.funcionario.exception.CustomRuntimeException;
import com.higor.funcionario.exception.enums.EnumErrosFuncionario;
import com.higor.funcionario.model.dto.FuncionarioDto;
import com.higor.funcionario.model.entity.Funcionario;
import com.higor.funcionario.repository.FuncionarioRepository;
import com.higor.funcionario.validador.ValidadorFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class FuncionarioService {

    private final ValidadorFuncionario validadorFuncionario = new ValidadorFuncionario();

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario encontrarFuncionario(final Integer id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException(EnumErrosFuncionario.FUNCIONARIO_NAO_ENCONTRADO));
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario criarFuncionario(final FuncionarioDto funcionarioDto) {

        final Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioDto.getNome());
        funcionario.setSobrenome(funcionarioDto.getSobrenome());
        funcionario.setEmail(funcionarioDto.getEmail());
        funcionario.setNumeroNIS(funcionarioDto.getNumeroNIS());

        validadorFuncionario.validacoesNovoFuncionario(funcionario);

        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizarFuncionario(final Integer idFuncionario, final FuncionarioDto funcionarioDto) {

        final Funcionario funcionario = encontrarFuncionario(idFuncionario);

        if (StringUtils.hasLength(funcionarioDto.getNome())
                && !funcionario.getNome().equals(funcionarioDto.getNome())) {
            funcionario.setNome(funcionarioDto.getNome());
        }

        if (StringUtils.hasLength(funcionarioDto.getSobrenome())
                && !funcionario.getSobrenome().equals(funcionarioDto.getSobrenome())) {
            funcionario.setSobrenome(funcionarioDto.getSobrenome());
        }

        if (StringUtils.hasLength(funcionarioDto.getEmail())
                && !funcionario.getEmail().equals(funcionarioDto.getEmail())) {
            funcionario.setEmail(funcionarioDto.getEmail());
        }

        if (StringUtils.hasLength(funcionarioDto.getNumeroNIS())
                && !funcionario.getNumeroNIS().equals(funcionarioDto.getNumeroNIS())) {
            funcionario.setNumeroNIS(funcionarioDto.getNumeroNIS());
        }

        validadorFuncionario.validacoesNovoFuncionario(funcionario);

        return funcionarioRepository.save(funcionario);
    }

    public void removerFuncionario(final Integer idFuncionario) {
        final Funcionario funcionario = encontrarFuncionario(idFuncionario);

        try {
            funcionarioRepository.delete(funcionario);
        } catch (Exception e) {
            throw new CustomRuntimeException(e);
        }
    }

}
