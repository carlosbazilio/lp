//class Empregado(val nome : String, var salario : Double = 0)

abstract class IEmpregado(val nome : String, private var salario : Double) {
	def this(n : String) = this(n, 0)
	
	def aumentarSalario() : Unit = { salario = salario * 1.1 }
	
	def obterSalario : Double = { salario }
	
	def horario : String
}

class Empregado(override val nome : String, private var salario : Double) extends
	IEmpregado (nome, salario) with Educado {
	
	def horario = "Manha ou Tarde";
}

class Gerente(override val nome : String, private var salario : Double, var area : String) 
	extends IEmpregado(nome, salario) {
	
	def horario = "Manha e Tarde";
}

val emp = new Empregado("Joao da Silva", 1500) with Dedicado
emp aumentarSalario()
println(emp.nome + ", " + emp.obterSalario + ", " + emp.horario)

val ger = new Gerente("Jose Raimundo", 2000, "Financeiro")
ger aumentarSalario()
println(ger.nome + ", " + ger.obterSalario + ", " + ger.area + ", " + ger.horario)

object Presidente extends IEmpregado ("Dilma Rousseff", 5000) {
	def horario = "Integral"
}

Presidente aumentarSalario()
println(Presidente.nome + ", " + Presidente.obterSalario + ", " + Presidente.horario)

trait Educado {
	def saudacao = { println("Muito prazer!") }
}

trait Dedicado extends IEmpregado {
	override def horario = "Integral"
}

val emp2 = new Empregado("Jose da Silva", 1500) with Educado with Dedicado
emp2 aumentarSalario()
println(emp2.nome + ", " + emp2.obterSalario + ", " + emp2.horario)
emp2.saudacao
// emp.saudacao // Not a member!

val eike = new Gerente("Batista", 729.58, "Todas") with Dedicado
println(eike.nome + ", " + eike.obterSalario + ", " + eike.horario)



