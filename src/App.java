import java.util.Random;

/** 
 * MIT License
 *
 * Copyright(c) 2024-255 João Caram <caram@pucminas.br>
 *                       Eveline Alonso Veloso
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class App {
    static int[] tamanhosTesteGrande =  { 500_000, 1_000_000, 2_000_000, 3_000_000, 5_000_000, 10_000_000 };
    static int[] tamanhosTesteMedio =   {  12_500,  25_000,  50_000,   100_000,   200_000 };
    static int[] tamanhosTestePequeno = {       3,       6,      12,        24,        48 };
    static Random aleatorio = new Random(42);

    static int codigo1(int[] vetor) {
        int resposta = 0;
        int operacoes = 0;
        for (int i = 0; i < vetor.length; i += 2) {
            resposta += vetor[i] % 2;
            operacoes++;
        }
        System.out.println("Operações (Código 1): " + operacoes);
        return resposta;
    }

    static int codigo2(int[] vetor) {
        int contador = 0;
        int operacoes = 0;
        for (int k = (vetor.length - 1); k > 0; k /= 2) {
            for (int i = 0; i <= k; i++) {
                contador++;
                operacoes++;
            }
        }
        System.out.println("Operações (Código 2): " + operacoes);
        return contador;
    }

    static void codigo3(int[] vetor) {
        int operacoes = 0;
        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor])
                    menor = j;
                operacoes++;
            }
            int temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
        }
        System.out.println("Operações (Código 3): " + operacoes);
    }

    static int codigo4(int n) {
        if (n <= 2)
            return 1;
        else
            return codigo4(n - 1) + codigo4(n - 2);
    }

    static int[] gerarVetor(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        return vetor;
    }

    public static void main(String[] args) {
        long tempoInicio, tempoFim;
        
        for (int tamanho : tamanhosTesteGrande) {
            int[] vetor = gerarVetor(tamanho);
            tempoInicio = System.nanoTime();
            codigo1(vetor);
            tempoFim = System.nanoTime();
            System.out.println("Código 1 - Tamanho: " + tamanho + " - Tempo: " + (tempoFim - tempoInicio) / 1e6 + " ms");
        }
        
        for (int tamanho : tamanhosTesteGrande) {
            int[] vetor = gerarVetor(tamanho);
            tempoInicio = System.nanoTime();
            codigo2(vetor);
            tempoFim = System.nanoTime();
            System.out.println("Código 2 - Tamanho: " + tamanho + " - Tempo: " + (tempoFim - tempoInicio) / 1e6 + " ms");
        }
        
        for (int tamanho : tamanhosTesteMedio) {
            int[] vetor = gerarVetor(tamanho);
            tempoInicio = System.nanoTime();
            codigo3(vetor);
            tempoFim = System.nanoTime();
            System.out.println("Código 3 - Tamanho: " + tamanho + " - Tempo: " + (tempoFim - tempoInicio) / 1e6 + " ms");
        }
        
        for (int tamanho : tamanhosTestePequeno) {
            tempoInicio = System.nanoTime();
            int resultado = codigo4(tamanho);
            tempoFim = System.nanoTime();
            System.out.println("Código 4 - Tamanho: " + tamanho + " - Tempo: " + (tempoFim - tempoInicio) / 1e6 + " ms - Resultado: " + resultado);
        }
    }
}
