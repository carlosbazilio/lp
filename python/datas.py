class MinhaData:

    def __init__(self, dia, mes, ano):
        self.dia = dia
        self.mes = mes
        self.ano = ano

    # Criar um construtor que receba uma string e inicialize a data
    def __init__(self, nome, data):
        self.nome = nome
        lista = data.split("/")
        MinhaData.__init__(self, int(lista[0]), int(lista[1]), int(lista[2]))

    def __str__(self):  # Tostring
        return f"{self.dia}/{self.mes}/{self.ano}"

    def compara(self, data):
        if (self.dia == data.dia) and (self.mes == data.mes) and (self.ano == data.ano):
            return 0

        if (self.ano == data.ano) and (self.mes == data.mes):
            if (self.dia > data.dia):
                return 1
            else:
                return -1
        if (self.ano == data.ano):
            if (self.mes > data.mes):
                return 1
            else:
                return -1
        if (self.ano > data.ano):
            return 1
        else:
            return -1


class DataComemorativa(MinhaData):

    def __init__(self, nome, data):
        super().__init__(nome, data)


class DatasComemorativas:
    def __init__(self):
        self.datas = []

    def adiciona_data(self, data):
        self.datas.append(data)

    def lista_datas(self):
        if self.datas == []:
            print("Lista vazia!")
        print("=" * 30)
        print("Lista de Datas comemorativas: ")

        for data in self.datas:
            print(f"{data.nome}: {data.dia}/{data.mes}/{data.ano}")

        print("=" * 30)

    def remove_data(self, nome):
        if nome in self.datas:
            self.datas.remove(nome)

    def horas_nao_trabalhadas(self):
        cont = 0
        for data in self.datas:
            cont += 1
        return cont * 8


atual = MinhaData("atual", "06/12/2020")
natal = DataComemorativa("natal", "25/12/2020")
print(atual.compara(natal))

dados = DatasComemorativas()
dados.adiciona_data(natal)
print(dados.horas_nao_trabalhadas())