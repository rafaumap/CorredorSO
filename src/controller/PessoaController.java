package controller;

import java.util.concurrent.Semaphore;

public class PessoaController extends Thread {
  private Semaphore semaphore;
  private int idPessoa;
  private int distanciaPercorrida = 0;

  public PessoaController(int idPessoa, Semaphore semaphore) {
    this.semaphore = semaphore;
    this.idPessoa = idPessoa;
  }

  @Override
  public void run() {
    try {
      do {
        andar();
      } while (distanciaPercorrida <= 200);

      semaphore.acquire();
      abrirPorta();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      semaphore.release();
    }
  }

  private void andar() {
    int passo = (int) (Math.random() * (7 - 4)) + 4;
    distanciaPercorrida += passo;
    System.out.println("Pessoa " + idPessoa + " andou " + passo + "m. Distância percorrida: " + distanciaPercorrida + "m.");
  }

  private void abrirPorta() {
    System.out.println("Pessoa " + idPessoa + " abriu a porta");

    int aberturaDaPorta = (int) (Math.random() * (3 - 1)) + 1;
     
    try {
      sleep(aberturaDaPorta * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Pessoa " + idPessoa + " fechou a porta");
  }
  
}