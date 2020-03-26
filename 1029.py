'''
Uri 1029
Este problema tem como objetivo descobrir para determinados valores n quantas chamadas são necessárias para achar o fibonacci de n. Para atingir este objetivo de forma eficiente foram utilizados conceitos de Programação Dinamica para calcular o fibonacci e as chamadas.

Matheus Morais.
'''


chamadas = [1, 1] #Declaração do vetor que guarda as chamadas
fib = [0, 1]  #Declaração do vetor para calcular o fibonacci
entradas = [] #Declaração do betor que guarda as entradas

n = int(input()) # Entrada da quantidade de entradas
for k in range(n):
    entradas.append(int(input())) #Leitura e armazenamento das n entradas



for k in range(2,40):#Um for que começa a partir do 2 pois os dois primeiros ja estão definidos e termina em 40 pois o problema diz que a entrada seria um valor entre 1 e 39
    fib.append(fib[k-1] + fib[k-2]) #Calculo do fibonacci usando DP
    chamadas.append(chamadas[k-1] + chamadas[k-2] + 1) #Calculo das chamadas

for n in entradas:
     print("fib(%d) = %d calls = %d" %(n, chamadas[n] -1, fib[n])) #Print dos resultados

