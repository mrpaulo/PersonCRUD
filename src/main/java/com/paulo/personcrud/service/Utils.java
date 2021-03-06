/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paulo.personcrud.service;

import com.paulo.personcrud.model.Pessoa;
import java.util.Date;
import java.util.InputMismatchException;

/**
 *
 * @author paulo
 */
public class Utils {

    public static void validaPessoa(Pessoa pessoa) throws ExcecaoPropria {
        if (pessoa.getNome().isEmpty()) {
            throw new ExcecaoPropria("Nome deve ser informado!");
        }
        String cpf = removeFormatCPF(pessoa.getCpf());
        if (cpf.isEmpty()) {
            throw new ExcecaoPropria("CPF deve ser informado!");
        }
        if (!isCPF(cpf)) {
            throw new ExcecaoPropria("CPF inválido!");
        }
        if (pessoa.getDataNascimento() == null) {
            throw new ExcecaoPropria("Data de nascimento inválida, não foi informada ou formato diferente de aaaa-mm-dd!");
        }
        if (pessoa.getDataNascimento().after(new Date())) {
            throw new ExcecaoPropria("Data de nascimento inválida, posterior a hoje!");
        }
        if (!isVazioOuNull(pessoa.getEmail()) && pessoa.getEmail().length() > 100) {
            throw new ExcecaoPropria("E-mail com tamanho maior que 100 caracteres!");
        }
        if (!isVazioOuNull(pessoa.getNacionalidade()) && pessoa.getNacionalidade().length() > 100) {
            throw new ExcecaoPropria("Nacionalidade com tamanho maior que 100 caracteres!");
        }
        if (!isVazioOuNull(pessoa.getNaturalidade()) && pessoa.getNaturalidade().length() > 100) {
            throw new ExcecaoPropria("Naturalidade com tamanho maior que 100 caracteres!");
        }
        if (!isVazioOuNull(pessoa.getSexo()) && (pessoa.getSexo().length() > 1 || (!pessoa.getSexo().equals("M") && !pessoa.getSexo().equals("F")))) {
            throw new ExcecaoPropria("Somente aceito como sexo M ou F!");
        }

    }
    
    public static boolean isVazioOuNull (String value) {
        return value == null || value.isEmpty();
    }

    public static String removeFormatCPF(String CPF) {
        return CPF.replace(".", "").replace("-", "");
    }

    public static boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0         
                // (48 eh a posicao de '0' na tabela ASCII)         
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
}
