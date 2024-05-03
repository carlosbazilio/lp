/* Disciplina: Computacao Concorrente */
/* Prof.: Silvana Rossetto */
/* Codigo: Encontrar os números primos entre 0 e 10^? */
/* -------------------------------------------------------------------*/

/* Versao concorrente */

//classe do contador compartilhado entre as threads
class Contador {
  //recurso compartilhado
  private long cont; //numeros a serem testados (incremental)
  private double limit; //limite de numeros a serem testados
  private long primos; //qtde de numeros primos encontrados

  //construtor
  public Contador(int i, int exp) { 
     this.cont = i;  //inicia o contador com valor i
     this.limit = Math.pow(10,exp); //inicia o limite com potencia de 10
     this.primos = 0;
  }
  //operacoes sobre o recurso compartilhado
  public synchronized long getinc() { 
    if (this.cont < this.limit) return this.cont++;
    else return -1;
  }
  public synchronized void incprimos() { this.primos++; }
  public synchronized long getprimos() { return this.primos; }
  public synchronized long getcont() { return this.cont; }
}

//classe que estende Thread e implementa a tarefa de cada thread do programa 
class Primos extends Thread {
   //objeto compartilhado com outras threads
   Contador cont;
  
   //construtor
   public Primos(Contador c) { 
      this.cont = c;
   }

   private boolean ehPrimo(long n) {
      if(n<=1) return false;
      if(n==2) return true;
      if(n%2==0) return false;
      for(int i=3; i<Math.sqrt(n)+1; i+=2) {
         if(n%i==0) return false;
      }
      return true;
   }
   
   //metodo main da thread
   public void run() {
      long i = this.cont.getinc(); //pega o próximo valor
      while (i != -1) {
         if (ehPrimo(i)) this.cont.incprimos(); 
         i = this.cont.getinc(); //pega o próximo valor
      }
   }
}


//classe da aplicacao
class TPrimos {
   static final int NTHREADS = 2; //numero de threads da aplicacao

   public static void main (String[] args) {
      //reserva espaço para um vetor de threads
      Thread[] threads = new Thread[NTHREADS];
      //cria uma instancia do recurso compartilhado entre as threads
      Contador cont = new Contador(0,6);

      //cria as threads da aplicacao
      for (int i=0; i<threads.length; i++) {
         threads[i] = new Primos(cont);
      }

      //inicia as threads
      for (int i=0; i<threads.length; i++) {
         threads[i].start();
      }

      //espera pelo termino de todas as threads
      for (int i=0; i<threads.length; i++) {
         try { threads[i].join(); } catch (InterruptedException e) { return; }
      }

      System.out.println("Valor final do numero = " + cont.getcont()); 
      System.out.println("Qtde de primos = " + cont.getprimos()); 
   }
}
