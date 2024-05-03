type Table = [[String]]

disciplinas :: Table
disciplinas = [["id", "nome", "ch"], 
               ["1", "paradigmas", "60"], 
               ["2", "progweb", "60"]]

type Fields = [String]

select :: Fields -> Table -> Table
select [] _ = [[]]
select ["*"] tabela = tail tabela

