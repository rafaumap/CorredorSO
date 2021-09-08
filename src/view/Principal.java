package view;

import java.util.concurrent.Semaphore;

import controller.PessoaController;

class Principal {
  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(1);

    for (int idPessoa = 1; idPessoa <= 4; idPessoa++) {
      PessoaController pessoa = new PessoaController(idPessoa, semaphore);
      pessoa.start();
    }
  }
}