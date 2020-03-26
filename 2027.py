'''
Uri 2027
Este problema consite basicamente em corrigir erros um código dado no problema
'''

def GCDsimp (num, den):#Nesta função só foi retirado o print
    if den > 0:
        return GCDsimp (den, num % den)#O calculo feito aqui é o mesmo do cód original
    return num

apostas = [] #Assim como no código original é declarado um vetor
cont = 0 #O contador no código original estava comaçando com -1 e estava dando erro pois estava acessando um indice que não existia então coloquei como 0
while True: # aqui é declarado um laço que tem como condição de parada um espaço em branco, pois assim foi pedido no problema
    try:
        num, den = input().split() #Aqui são lidas as variaveis num e den como no cód original
        apostas.append(GCDsimp(int(num), int(den))) #Aqui o resultado da função GCDsimp é guardado na lista de apostas como no cód original
        if apostas[cont] > 5: #Aqui é utilizado o mesmo critério que no cód original para printar Noel ou Gnomos
            print('Noel')
        else:
            print('Gnomos')

        cont += 1



    except EOFError:
        break

for i in range(cont-1, -1, -1): #Aqui é declarado um for que começa no valor cont-1, até o 0, com decremento de -1 por laço
    print(apostas[i], end = ' ') # Aqui são printados os resultados e no final, assim como pro problema original é adicionado um espaço em branco
print("")#Aqui é printado um espaço em branco
